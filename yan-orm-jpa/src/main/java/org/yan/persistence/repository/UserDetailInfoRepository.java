package org.yan.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.yan.persistence.entity.user.UserDetailInfo;

import java.util.Optional;

public interface UserDetailInfoRepository extends CrudRepository<UserDetailInfo, Long> {

    @Override
    Optional<UserDetailInfo> findById(Long aLong);

    @Query(value = "SELECT count(*) FROM " +
            "YanDatabase.AMS_USER_BASIC_INFO_UMS_UNIVERSITY " +
            "where concernedUniversities_id = :uid",
            nativeQuery = true)
    int countDistinctByUniversity(@Param("uid") Long uid);
}
