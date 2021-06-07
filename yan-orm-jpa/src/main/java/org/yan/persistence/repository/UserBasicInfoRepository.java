package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.user.UserBasicInfo;

import java.util.Optional;

public interface UserBasicInfoRepository extends CrudRepository<UserBasicInfo, Long> {
    Optional<UserBasicInfo> findById(Long id);
}
