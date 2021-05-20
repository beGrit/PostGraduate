package org.yan.admin.service;

import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.List;

public interface UniversityService {
    University queryById(Long uid) throws Exception;

    List<University> queryByPage(Integer pageIndex, Integer pageSize);

    void updateUniversityLocation(Long uid, Location location) throws Exception;

    boolean idAnyUniversityRelyOnSpecLocation(Long locationId);
}
