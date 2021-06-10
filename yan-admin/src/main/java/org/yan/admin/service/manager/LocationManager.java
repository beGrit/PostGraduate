package org.yan.admin.service.manager;


import org.yan.common.exception.basic.DeleteException;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.exception.basic.UpdateException;
import org.yan.persistence.entity.university.Location;

import java.util.List;

public interface LocationManager extends PageManager {
    boolean isExist(Location location);

    boolean delete(Long locationId) throws DeleteException;

    Location save(Location location) throws UpdateException;

    @Override
    List<Location> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException;
}
