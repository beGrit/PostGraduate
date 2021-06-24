package org.yan.restful.service;

import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.entity.user.UserBasicInfo;
import org.yan.persistence.entity.user.UserDetailInfo;
import org.yan.restful.vo.UniversityGradesVO;

import java.util.List;
import java.util.Set;

public interface UserInfoService {
    UserBasicInfo getBasic(Long userId) throws QueryException;

    UserDetailInfo getDetail(Long userId);

    Set<University> getConcernedUniversities(Long userId);

    MasterMajor getConcernedMasterMajor(Long userId);

    List<UniversityGradesVO> getUniversityGradesVOList(Long userId) throws CrudException;

    void changeConcernedMasterMajor(Long userId, Long mid) throws CrudException;

    void changeConcernedUniversity(Long userId, Long newUid, Long oldUid) throws CrudException;

    void addConcernedUniversity(Long userId, Long uid) throws CrudException;
}
