package org.yan.admin.service;

import org.yan.admin.domain.ComparedInfo;
import org.yan.admin.exception.basic.QueryException;

public interface CompareUniversityService {
    ComparedInfo compareUniversities(Long[] uidList, Long mid) throws QueryException;
}
