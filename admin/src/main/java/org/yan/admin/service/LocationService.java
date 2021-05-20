package org.yan.admin.service;

import org.yan.admin.exception.basic.DeleteException;
import org.yan.persistence.entity.university.Location;

public interface LocationService {
    boolean isExist(Location location);

    boolean delete(Long locationId) throws DeleteException;

    void save(Location location);
}
