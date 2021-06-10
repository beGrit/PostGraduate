package org.yan.admin.service.impl;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.yan.admin.service.manager.CityManager;
import org.yan.admin.service.manager.LocationManager;
import org.yan.admin.service.manager.UniversityManager;

import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.DeleteException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.LocationRepository;
import org.yan.persistence.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityManagerImpl implements UniversityManager {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationManager locationManager;

    @Autowired
    CityManager cityManager;

    public boolean isLocationUsed(Long locationId) {
        boolean b = universityRepository.existsUniversityByLocation_Id(locationId);
        return b;
    }

    @Override
    public Long getTotal() {
        return universityRepository.countDistinctByIdNotNull();
    }

    @Override
    @Transactional
    public void add(Object b) throws CrudException {
        University newUniversity = (University) b;

        /*添加location*/
        Location location = newUniversity.getLocation();
        Location newLocation = locationManager.save(location);

        universityRepository.save(newUniversity);
    }

    @Override
    @Transactional
    public void delete(Long uid) throws CrudException {
        try {
            University university = queryById(uid);
            universityRepository.delete(university);
        } catch (QueryException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void batchDelete(List<Long> idList) throws CrudException {
        for (Long id : idList) {
            delete(id);
        }
    }

    @Override
    @Transactional
    public void save(Object b) throws CrudException {
        University university = (University) b;
        try {
            universityRepository.save(university);
        } catch (Exception e) {
            throw new CrudException();
        }
    }

    @Override
    public List<University> queryByIdList(Long[] idList) throws QueryException {
        List<University> universityList = new ArrayList<>();
        for (int i = 0; i < idList.length; i++) {
            University university = this.queryById(idList[i]);
            universityList.add(university);
        }
        return universityList;
    }

    @Override
    public void save(University university, Long cityId) throws CrudException {
        City city = cityManager.queryById(cityId);
        university.setCity(city);
        this.save(university);
    }

    public University queryById(Long uid) throws QueryException {
        Optional<University> universityOptional = universityRepository.findById(uid);
        if (universityOptional.isPresent()) {
            University university = universityOptional.get();
            return university;
        } else {
            throw new QueryException("查询不到指定的院校: " + uid);
        }
    }

    @Override
    public List<University> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException {
        Page<University> rtn = universityRepository.findAll(PageRequest.of(pageIndex - 1, pageSize));
        if (rtn.getNumberOfElements() == 0) {
            throw new QueryException("数据集为空");
        } else {
            return rtn.getContent();
        }
    }

    @Override
    public List<University> queryAll() throws QueryException {
        List<University> rtn = (List<University>) universityRepository.findAll();
        if (rtn.size() == 0) {
            // 数据为空
            throw new QueryException("无数据");
        } else {
            return rtn;
        }
    }

    @Override
    public void updateUniversityLocation(Long uid, Location newLocation) throws CrudException, DeleteException {
        University university = queryById(uid);
        Location oldLocation = university.getLocation();
        boolean exist = locationManager.isExist(newLocation);
        if (exist) {
            if (oldLocation.getId().equals(newLocation.getId())) {
                locationRepository.save(newLocation);
            } else {
                // id 有问题
            }
        } else {
            newLocation = locationRepository.save(newLocation);
            university.setLocation(newLocation);
            universityRepository.save(university);
            locationManager.delete(oldLocation.getId());
        }
    }
}
