package org.yan.admin.service.manager;

import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.Grade;

import java.util.List;

public interface GradeManager extends PageManager, CrudManager {

    /**
     * 根据 uid + mid 查询成绩
     * @param uid
     * @param mid
     * @return null || List<Grade>
     */
    List<Grade> findGradeListByUidAndMid(Long uid, Long mid);

    @Override
    List<Grade> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;

    @Override
    Grade queryById(Long id) throws QueryException;

    @Override
    List<Grade> queryByIdList(Long[] idList) throws QueryException;
}
