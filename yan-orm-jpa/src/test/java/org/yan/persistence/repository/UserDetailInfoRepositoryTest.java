package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.entity.user.UserDetailInfo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserDetailInfoRepositoryTest {

    @Autowired
    UserDetailInfoRepository repository;

    @Test
    void findById() {
        Optional<UserDetailInfo> optional = repository.findById(1L);
        optional.ifPresent(userDetailInfo -> {
            System.out.println();
        });
    }

    @Test
    void countDistinctByUniversity() {
        int count = repository.countDistinctByUniversity(1L);
        System.out.println();
    }
}