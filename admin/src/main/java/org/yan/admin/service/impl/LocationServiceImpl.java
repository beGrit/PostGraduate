package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.exception.basic.DeleteException;
import org.yan.admin.service.LocationService;
import org.yan.admin.service.UniversityManager;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.repository.LocationRepository;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UniversityManager universityManager;

    @Override
    public boolean isExist(Location location) {
        boolean rtn = false;
        boolean b1 = locationRepository.existsLocationByLongitudeAndLatitude(location.getLongitude(), location.getLatitude());
        Optional<Location> byId = locationRepository.findById(location.getId());
        if (!(!b1 && !byId.isPresent())) {
            rtn = true;
        }
        return rtn;
    }

    public boolean isExist(Long locationId) {
        Optional<Location> locationOptional = locationRepository.findById(locationId);
        return locationOptional.isPresent();
    }

    @Override
    public boolean delete(Long locationId) throws DeleteException {
        boolean isExist = isExist(locationId);
        // 判断是否有院校依赖该位置
        boolean b2 = universityManager.isLocationUsed(locationId);
        if (isExist && !b2) { // 位置存在且位置信息没有依赖关系
            Optional<Location> locationOptional = locationRepository.findById(locationId);
            Location location = locationOptional.get();
            locationRepository.delete(location);
            return true;
        } else {
            if (!isExist) {
                throw new DeleteException("位置信息不存在: " + locationId);
            } else {
                throw new DeleteException("删除失败,有某个院校依赖该位置: " + locationId);
            }
        }
    }

    @Override
    public void save(Location location) {
        return;
    }
}
