package org.yan.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.yan.persistence.entity.user.UserBasicInfo;

import java.util.Optional;

public interface UserBasicInfoRepository extends PagingAndSortingRepository<UserBasicInfo, Long> {
    Optional<UserBasicInfo> findById(Long id);
}
