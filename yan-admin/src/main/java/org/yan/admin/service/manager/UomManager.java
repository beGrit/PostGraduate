package org.yan.admin.service.manager;

import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.university.University;

import java.util.List;

public interface UomManager {
    List<University> findUniversityListByMajorId(Long mid) throws CrudException;
}
