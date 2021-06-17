package org.yan.restful.service;

import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.entity.user.UserDetailInfo;

import java.util.Set;

public interface UserInfoService {
    UserDetailInfo getDetail(Long id);

    Set<University> getConcernedUniversities(Long id);

    MasterMajor getConcernedMasterMajor(Long id);

    void changeConcernedMasterMajor(Long userId, Long mid) throws CrudException;

    void changeConcernedUniversity(Long userId, Long newUid, Long oldUid) throws CrudException;
}
