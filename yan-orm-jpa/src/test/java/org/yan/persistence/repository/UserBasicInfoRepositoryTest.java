package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.user.UserBasicInfo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserBasicInfoRepositoryTest {

    @Autowired
    UserBasicInfoRepository repository;

    @Test
    void findById() {
        Optional<UserBasicInfo> optional = repository.findById(1L);

        optional.ifPresent(System.out::println);
    }
}