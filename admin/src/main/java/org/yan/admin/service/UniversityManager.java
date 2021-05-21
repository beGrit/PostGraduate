package org.yan.admin.service;

import org.yan.admin.exception.basic.CrudException;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.exception.basic.UpdateException;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.List;

public interface UniversityManager {
    University queryById(Long uid) throws QueryException;

    /**
     * 根据 PageIndex(页码) PageSize(页容量) 获取数据集
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<University> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;

    /**
     * 更新院校的位置信息
     * @param uid
     * @param location
     * @throws UpdateException
     */
    void updateUniversityLocation(Long uid, Location location) throws CrudException;

    /**
     * 判断某个Location是否被占用
     * @param locationId
     * @return
     */
    boolean isLocationUsed(Long locationId);

    /**
     * 获取当前所有的院校数量
     * @return
     */
    Long getTotal();
}
