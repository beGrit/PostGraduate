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

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    MasterMajorRepository masterMajorRepository;

    @Test
    void findById() {
        University u1 = universityRepository.findById(1L).get();
        MasterMajor m1 = masterMajorRepository.findById(1L).get();

        UserDetailInfo userDetailInfo = new UserDetailInfo();


        userDetailInfo.setId(1L);
        userDetailInfo.setNickName("pocky1314");
        userDetailInfo.setAvatarPath("/image/pocky.png");

        repository.save(userDetailInfo);
        UserDetailInfo saved = repository.findById(1L).get();

        saved.addConcernedUniversity(u1);
        saved.setConcernedMasterMajor(m1);

        repository.save(saved);


        Optional<UserDetailInfo> optional = repository.findById(1L);
        optional.ifPresent(System.out::println);
    }
}