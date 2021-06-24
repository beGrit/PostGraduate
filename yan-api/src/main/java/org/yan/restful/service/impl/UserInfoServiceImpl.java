package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.service.manager.GradeManager;
import org.yan.admin.service.manager.MasterMajorManager;
import org.yan.admin.service.manager.UniversityManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.entity.user.UserBasicInfo;
import org.yan.persistence.entity.user.UserDetailInfo;
import org.yan.persistence.repository.UserBasicInfoRepository;
import org.yan.persistence.repository.UserDetailInfoRepository;
import org.yan.restful.service.UserInfoService;
import org.yan.restful.vo.UniversityGradesVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserDetailInfoRepository userDetailInfoRepository;

    @Autowired
    UserBasicInfoRepository userBasicInfoRepository;

    @Autowired
    MasterMajorManager masterMajorManager;

    @Autowired
    UniversityManager universityManager;

    @Autowired
    GradeManager gradeManager;

    @Override
    public UserBasicInfo getBasic(Long userId) throws QueryException {
        Optional<UserBasicInfo> optional = userBasicInfoRepository.findById(userId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new QueryException("查无此人");
        }
    }

    @Override
    public UserDetailInfo getDetail(Long id) {
        Optional<UserDetailInfo> optional = userDetailInfoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public Set<University> getConcernedUniversities(Long id) {
        return this.getDetail(id).getConcernedUniversities();
    }

    @Override
    public MasterMajor getConcernedMasterMajor(Long id) {
        return this.getDetail(id).getConcernedMasterMajor();
    }

    @Override
    public List<UniversityGradesVO> getUniversityGradesVOList(Long userId) throws CrudException {
        List<UniversityGradesVO> res = new ArrayList<>();
        Set<University> universities = getConcernedUniversities(userId);
        Long mid = getConcernedMasterMajor(userId).getId();
        for (University u : universities) {
            List<Grade> gradeList = gradeManager.findGradeListByUidAndMid(u.getId(), mid);
            UniversityGradesVO universityGradesVO = new UniversityGradesVO(u, gradeList);
            res.add(universityGradesVO);
        }
        return res;
    }

    @Override
    public void changeConcernedMasterMajor(Long userId, Long mid) throws CrudException {
        UserDetailInfo userDetailInfo = this.getDetail(userId);

        MasterMajor masterMajor = masterMajorManager.queryById(mid);
        userDetailInfo.setConcernedMasterMajor(masterMajor);

        userDetailInfoRepository.save(userDetailInfo);
    }

    @Override
    @Transactional
    public void changeConcernedUniversity(Long userId, Long newUid, Long oldUid) throws CrudException {
        UserDetailInfo userDetailInfo = this.getDetail(userId);

        Set<University> universities = userDetailInfo.getConcernedUniversities();
        University temp = null;
        for (University u : universities) {
            if (u.getId() == oldUid) {
                temp = u;
                break;
            }
        }

        if (temp != null) {
            universities.remove(temp);
        }

        University newUniversity = universityManager.queryById(newUid);
        universities.add(newUniversity);

        userDetailInfo.setConcernedUniversities(universities);

        userDetailInfoRepository.save(userDetailInfo);
    }

    @Override
    @Transactional
    public void addConcernedUniversity(Long userId, Long uid) throws CrudException {
        UserDetailInfo user = this.getDetail(userId);
        if (user != null) {
            Set<University> concernedUniversities = user.getConcernedUniversities();
            if (concernedUniversities.size() == 3) {
                throw new CrudException("最多关注三个院校");
            } else {
                for (University university : concernedUniversities) {
                    if (university.getId() == uid) {
                        throw new CrudException("已经关注了");
                    }
                }
                University university = universityManager.queryById(uid);
                concernedUniversities.add(university);
                user.setConcernedUniversities(concernedUniversities);
                userDetailInfoRepository.save(user);
            }
        } else {
            throw new CrudException("查无此人");
        }
    }
}
