package org.yan.admin.service;

import org.yan.admin.exception.basic.DeleteException;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.exception.basic.UpdateException;
import org.yan.common.domain.page.PageParam;
import org.yan.persistence.entity.university.Location;

import java.util.List;

public interface LocationService {
    boolean isExist(Location location);

    boolean delete(Long locationId) throws DeleteException;

    List<Location> queryByPage(PageParam pageParam) throws QueryException;

    Location save(Location location) throws UpdateException;
}
