package org.yan.admin.service;


import org.yan.common.domain.page.PageParam;
import org.yan.common.exception.basic.DeleteException;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.exception.basic.UpdateException;
import org.yan.persistence.entity.university.Location;

import java.util.List;

public interface LocationManager {
    boolean isExist(Location location);

    boolean delete(Long locationId) throws DeleteException;

    List<Location> queryByPage(PageParam pageParam) throws QueryException;

    Location save(Location location) throws UpdateException;

    /**
     * 获取当前所有的位置数量
     * @return
     */
    Long getTotal();
}
