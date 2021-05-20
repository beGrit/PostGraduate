package org.yan.admin.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.exception.basic.DeleteException;
import org.yan.persistence.entity.university.Location;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @Test
    void isExist() {
        Location location1 = new Location(1L, 1.0, 2.0);
        boolean exist1 = locationService.isExist(location1);
        assert exist1;

        Location location2 = new Location(5L, 1.0, 1.0);
        boolean exist2 = locationService.isExist(location2);
        assert exist2;

        Location location3 = new Location(5L, 5.0, 3.0);
        boolean exist3 = locationService.isExist(location3);
        assert !exist3;
    }

    @Test
    @Transactional
    void delete() {
        boolean b1 = false;
        try {
            b1 = locationService.delete(3L);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        assert !b1;

        boolean b2 = false;
        try {
            b2 = locationService.delete(4L);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        assert b2;


        boolean b3 = false;
        try {
            b3 = locationService.delete(5L);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        assert !b3;
    }
}