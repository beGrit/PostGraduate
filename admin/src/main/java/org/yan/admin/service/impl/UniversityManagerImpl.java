package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.exception.basic.CrudException;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.service.LocationService;
import org.yan.admin.service.UniversityManager;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.LocationRepository;
import org.yan.persistence.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityManagerImpl implements UniversityManager {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    public boolean isLocationUsed(Long locationId) {
        boolean b = universityRepository.existsUniversityByLocation_Id(locationId);
        return b;
    }

    @Override
    public Long getTotal() {
        return universityRepository.countDistinctByIdNotNull();
    }

    public University queryById(Long uid) throws QueryException {
        Optional<University> universityOptional = universityRepository.findById(uid);
        if (universityOptional.isPresent()) {
            University university = universityOptional.get();
            return university;
        } else {
            throw new QueryException("查询不到指定的院校");
        }
    }

    @Override
    public List<University> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException {
        List<University> rtn = (List<University>) universityRepository.findAll();
        if (rtn == null) {
            throw new QueryException("数据集为空");
        } else  {
            return rtn;
        }
    }

    @Override
    public void updateUniversityLocation(Long uid, Location newLocation) throws CrudException {
        University university = queryById(uid);
        Location oldLocation = university.getLocation();
        boolean exist = locationService.isExist(newLocation);
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
            locationService.delete(oldLocation.getId());
        }
    }
}
