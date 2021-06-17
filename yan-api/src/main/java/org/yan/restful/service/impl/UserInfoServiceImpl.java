package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.service.manager.MasterMajorManager;
import org.yan.admin.service.manager.UniversityManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.entity.user.UserDetailInfo;
import org.yan.persistence.repository.UserDetailInfoRepository;
import org.yan.restful.service.UserInfoService;

import java.util.Optional;
import java.util.Set;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserDetailInfoRepository repository;

    @Autowired
    MasterMajorManager masterMajorManager;

    @Autowired
    UniversityManager universityManager;

    @Override
    public UserDetailInfo getDetail(Long id) {
        Optional<UserDetailInfo> optional = repository.findById(id);
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
    public void changeConcernedMasterMajor(Long userId, Long mid) throws CrudException {
        UserDetailInfo userDetailInfo = this.getDetail(userId);

        MasterMajor masterMajor = masterMajorManager.queryById(mid);
        userDetailInfo.setConcernedMasterMajor(masterMajor);

        repository.save(userDetailInfo);
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

        repository.save(userDetailInfo);
    }
}
