package org.yan.admin.service.manager;


import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.List;

public interface UniversityManager extends CrudManager, PageManager {

    List<University> queryAll() throws QueryException;

    void updateUniversityLocation(Long uid, Location location) throws CrudException;

    /**
     * 判断某个Location是否被占用
     *
     * @param locationId
     * @return
     */
    boolean isLocationUsed(Long locationId);

    @Override
    List<University> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;

    @Override
    University queryById(Long uid) throws QueryException;

    @Override
    List<University> queryByIdList(Long[] idList) throws QueryException;

    void save(University university, Long cityId) throws CrudException;
}
