package org.yan.admin.service;

import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.List;

public interface UniversityService {
    List<University> queryByPage(Integer pageIndex, Integer pageSize);

    void updateLocation(Location location);
}
