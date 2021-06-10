package org.yan.admin.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.service.manager.UniversityManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.CityRepository;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityManagerImplTest {

    @Autowired
    UniversityManager universityManager;

    @Autowired
    CityRepository cityRepository;

    @Test
    void isLocationUsed() {
    }

    @Test
    void getTotal() {
    }

    @Test
    @Transactional
    void delete() throws CrudException {
        universityManager.delete(1L);
    }

    @Test
    @Transactional
    void batchDelete() throws CrudException {
        // case1.
        universityManager.batchDelete(Arrays.asList(new Long[]{1L, 2L, 3L}));

        // case2.
        universityManager.batchDelete(Arrays.asList(new Long[]{4L}));
    }


    @Test
    void queryByPage() {
    }

    @Test
    void updateUniversityLocation() {
        try {
            universityManager.updateUniversityLocation(1L, new Location(7L, 1.0, 2.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryById() {
        try {
            University u1 = universityManager.queryById(1L);
            System.out.println(u1);

            University u2 = universityManager.queryById(2L);
            System.out.println(u2);
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
            universityManager.updateUniversityLocation(1L, new Location(8L, 2.0, 11.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
//    @Transactional
    void add() throws CrudException {
        Location location = new Location(11L, 200.901101, 108.918798);
        City city = cityRepository.findByNameIs("杭州");

        University university = new University(9L, "浙江师范大学", 0, 0, 102, 0, 0, "www.zjsfdx.com");
        university.setLocation(location);
        university.setCity(city);

        universityManager.add(university);
    }

    @Test
    void save() throws CrudException {
        Location location = new Location(11L, 20.901101, 108.918798);
        City city = cityRepository.findByNameIs("杭州");

        University university = new University(9L, "浙江师范大学", 0, 0, 102, 0, 0, "www.zjsfdx.com");
        university.setLocation(location);
        university.setCity(city);

        universityManager.save(university);
    }
}