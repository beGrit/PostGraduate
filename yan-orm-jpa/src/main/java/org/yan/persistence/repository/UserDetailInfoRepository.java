package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.user.UserDetailInfo;

import java.util.Optional;

public interface UserDetailInfoRepository extends CrudRepository<UserDetailInfo, Long> {

    @Override
    Optional<UserDetailInfo> findById(Long aLong);
}
