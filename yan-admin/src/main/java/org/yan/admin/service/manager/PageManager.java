package org.yan.admin.service.manager;

import org.yan.common.exception.basic.QueryException;

import java.util.List;

public interface PageManager {

    List queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;

    Long getTotal();
}
