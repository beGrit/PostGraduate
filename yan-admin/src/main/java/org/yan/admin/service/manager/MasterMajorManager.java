package org.yan.admin.service.manager;

import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.MasterMajor;

import java.util.List;

public interface MasterMajorManager extends PageManager, CrudManager {
    @Override
    List<MasterMajor> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;

    void add(Object b) throws CrudException;

    @Override
    MasterMajor queryById(Long id) throws QueryException;

    @Override
    List<MasterMajor> queryByIdList(Long[] idList) throws QueryException;
}
