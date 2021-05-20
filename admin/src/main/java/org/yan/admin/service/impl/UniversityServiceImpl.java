package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.LocationService;
import org.yan.admin.service.UniversityService;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.LocationRepository;
import org.yan.persistence.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    public boolean idAnyUniversityRelyOnSpecLocation(Long locationId) {
        boolean b = universityRepository.existsUniversityByLocation_Id(locationId);
        return b;
    }

    public University queryById(Long uid) throws Exception {
        Optional<University> universityOptional = universityRepository.findById(uid);
        if (universityOptional.isPresent()) {
            University university = universityOptional.get();
            return university;
        } else {
            throw new Exception("查询不到指定的院校");
        }
    }

    @Override
    public List<University> queryByPage(Integer pageIndex, Integer pageSize) {
        List<University> rtn = (List<University>) universityRepository.findAll();
        return rtn;
    }

    @Override
    public void updateUniversityLocation(Long uid, Location newLocation) throws Exception {
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
        // 查询
        /*
        Optional<Location> byId = locationRepository.findById(newLocation.getId());
        Optional<University> universityOptional = universityRepository.findById(uid);
        if (universityOptional.isPresent()) {
            University university = universityOptional.get();
            Location oldLocation = university.getLocation();

            Long oldId = oldLocation.getId();
            Long newId = newLocation.getId();

            if (oldLocation != null && oldId.equals(newId)) { // 该院校没有位置信息
                locationRepository.save(newLocation);
            } else if (oldLocation != null && !oldId.equals(newId)) {
                if (!universityRepository.existsUniversityByLocation_Id(newId)) {
                    locationRepository.delete(oldLocation);
                    newLocation = locationRepository.save(newLocation);
                    university.setLocation(newLocation);
                    universityRepository.save(university);
                } else {
                    throw new Exception("新位置的ID已被占用");
                }
            } else if (oldLocation == null) {
                if (!universityRepository.existsUniversityByLocation_Id(newId)) {
                    locationRepository.delete(oldLocation);
                    newLocation = locationRepository.save(newLocation);
                    university.setLocation(newLocation);
                    universityRepository.save(university);
                } else {
                    throw new Exception("新位置的ID已被占用");
                }
            }
        } else {
            // 查询不到指定的院校
            throw new Exception("查询不到指定的院校");
        }
        */


    }
}
