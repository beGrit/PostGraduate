package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.persistence.entity.user.UserDetailInfo;
import org.yan.persistence.repository.UserDetailInfoRepository;
import org.yan.restful.service.UserInfoService;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserDetailInfoRepository repository;

    @Override
    public UserDetailInfo getDetail(Long id) {
        Optional<UserDetailInfo> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
}
