package org.yan.admin.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UniversityServiceTest {
    @Autowired
    UniversityService universityService;

    @Test
    void queryByPage() {
    }

    @Test
    void updateUniversityLocation() {
        try {
            universityService.updateUniversityLocation(1L, new Location(7L, 1.0, 2.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryById() {
        try {
            University university = universityService.queryById(1L);
            System.out.println(university);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
//    @Transactional
    void testUpdateUniversityLocation() {
        // case1.
        try {
            new Location(1L, 1.0, 1.0);
            universityService.updateUniversityLocation(1L, new Location(8L, 2.0, 11.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
