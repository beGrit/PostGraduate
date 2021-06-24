package org.yan.restful.service;

import org.yan.common.exception.basic.CrudException;

public interface UniversityHeatService {
    int getTotalConcernedUserByUid(Long uid) throws CrudException;
}
