package org.yan.admin.service.manager;

import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;

import java.util.List;

public interface CrudManager {
    void add(Object b) throws CrudException;


    void delete(Long id) throws CrudException;

    void batchDelete(List<Long> idList) throws CrudException;


    void save(Object b) throws CrudException;


    Object queryById(Long id) throws QueryException;

    List queryByIdList(Long[] idList) throws QueryException;
}
