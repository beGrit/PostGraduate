package org.yan.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.exception.basic.DeleteException;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.exception.basic.UpdateException;
import org.yan.admin.service.LocationService;
import org.yan.admin.service.UniversityManager;
import org.yan.common.domain.page.PageParam;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UniversityManager universityManager;

    @Override
    public boolean isExist(Location location) { // 判断是否重复
        boolean rtn = false;
        // (经度,纬度)是否重复
        rtn = locationRepository.existsLocationByLongitudeAndLatitude(location.getLongitude(), location.getLatitude());
        if (location.getId() != null) { // id重复
            Optional<Location> byId = locationRepository.findById(location.getId());
            boolean b2 = byId.isPresent();
            rtn = rtn && b2;
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
    public List<Location> queryByPage(PageParam pageParam) throws QueryException {
        int pageIndex = pageParam.getPageIndex();
        int pageSize = pageParam.getPageSize();
        Page<Location> rtn = locationRepository.findAll(PageRequest.of(pageIndex - 1, pageSize));
        if (rtn.getNumberOfElements() == 0) {
            throw new QueryException("数据集为空");
        } else {
            return rtn.getContent();
        }
    }

    @Override
    @Transactional
    public Location save(Location location) throws UpdateException {
        if (isExist(location)) {
            LOGGER.error("更新失败");
            throw new UpdateException("位置信息有误: " + location.getId());
        } else {
            Location saved = locationRepository.save(location);
            return saved;
        }
    }
}
