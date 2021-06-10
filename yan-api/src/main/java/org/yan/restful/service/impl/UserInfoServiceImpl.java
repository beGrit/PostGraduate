package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.manager.MasterMajorManager;
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
    public void changeConcernedMasterMajo(Long userId, Long mid) throws CrudException {
        UserDetailInfo userDetailInfo = this.getDetail(userId);

        MasterMajor masterMajor = masterMajorManager.queryById(mid);
        userDetailInfo.setConcernedMasterMajor(masterMajor);

        repository.save(userDetailInfo);
    }
}
