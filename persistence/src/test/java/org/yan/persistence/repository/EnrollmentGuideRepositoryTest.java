package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.university.EnrollmentGuide;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class EnrollmentGuideRepositoryTest {

    @Autowired
    EnrollmentGuideRepository repository;

    @Test
    void findByUniversity_Id() {
        List<EnrollmentGuide> enrollmentGuides = repository.findByUniversity_Id(2L);
        enrollmentGuides.stream().forEach(System.out::println);
    }
}