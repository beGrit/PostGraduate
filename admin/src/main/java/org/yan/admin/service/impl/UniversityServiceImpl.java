package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    UniversityRepository repository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<University> queryByPage(Integer pageIndex, Integer pageSize) {
        List<University> rtn = (List<University>) repository.findAll();
        return rtn;
    }

    @Override
    public void updateLocation(Location location) {
        Optional<Location> byId = locationRepository.findById(location.getId());
        if (byId.isPresent()) {
            locationRepository.save(location);
        } else {
            // 查询的到
        }
    }
}
