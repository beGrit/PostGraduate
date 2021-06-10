package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.yan.admin.service.manager.CityManager;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityManagerImpl implements CityManager {
    @Autowired
    CityRepository repository;

    @Override
    public List<City> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException {
        Page<City> rtn = repository.findAll(PageRequest.of(pageIndex - 1, pageSize));
        if (rtn.getNumberOfElements() == 0) {
            throw new QueryException("数据集为空");
        } else {
            return rtn.getContent();
        }
    }

    @Override
    public List<City> queryAll() throws QueryException {
        Iterable<City> all = repository.findAll();
        return (List<City>) all;
    }

    @Override
    public City queryById(Long id) throws QueryException {
        Optional<City> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new QueryException("未找到相关的City: " + id);
        } else {
            return optional.get();
        }
    }

    @Override
    public Long getTotal() {
        return repository.countDistinctByIdNotNull();
    }
}
