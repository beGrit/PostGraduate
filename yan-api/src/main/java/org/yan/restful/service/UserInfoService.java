package org.yan.restful.service;

import org.yan.persistence.entity.user.UserDetailInfo;

public interface UserInfoService {
    UserDetailInfo getDetail(Long id);
}
