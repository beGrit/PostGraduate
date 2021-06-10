package org.yan.admin.service.manager;

import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.City;

import java.util.List;

public interface CityManager extends PageManager {
    @Override
    List<City> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;

    List<City> queryAll() throws QueryException;

    City queryById(Long id) throws QueryException;
}
