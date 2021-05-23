package org.yan.admin.service;

import org.yan.admin.exception.basic.DeleteException;
import org.yan.admin.exception.basic.UpdateException;
import org.yan.persistence.entity.university.Location;

public interface LocationService {
    boolean isExist(Location location);

    boolean delete(Long locationId) throws DeleteException;

    Location save(Location location) throws UpdateException;
}
