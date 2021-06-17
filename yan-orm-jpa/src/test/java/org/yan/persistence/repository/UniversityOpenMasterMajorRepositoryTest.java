package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityOpenMasterMajorRepositoryTest {

    @Autowired
    UniversityOpenMasterMajorRepository repository;

    @Test
    void existsByUniversity_IdAndMasterMajor_Id() {
    }

    @Test
    void findByUniversity_IdAndMasterMajor_Id() {
    }

    @Test
    void findAllByMasterMajorId() {
        List<UniversityOpenMasterMajor> allByMasterMajorId = repository.findAllByMasterMajorId(1L);
        System.out.println(allByMasterMajorId);
    }
}