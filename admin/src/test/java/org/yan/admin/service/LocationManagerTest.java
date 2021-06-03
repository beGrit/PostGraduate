package org.yan.admin.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.common.exception.basic.DeleteException;
import org.yan.persistence.entity.university.Location;

@SpringBootTest
@RunWith(SpringRunner.class)
class LocationManagerTest {

    @Autowired
    LocationManager locationManager;

    @Test
    void isExist() {
        Location location1 = new Location(1L, 1.0, 2.0);
        boolean exist1 = locationManager.isExist(location1);
        assert exist1;

        Location location2 = new Location(5L, 1.0, 1.0);
        boolean exist2 = locationManager.isExist(location2);
        assert exist2;

        Location location3 = new Location(5L, 5.0, 3.0);
        boolean exist3 = locationManager.isExist(location3);
        assert !exist3;
    }

    @Test
    @Transactional
    void delete() {
        boolean b1 = false;
        try {
            b1 = locationManager.delete(3L);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        assert !b1;

        boolean b2 = false;
        try {
            b2 = locationManager.delete(4L);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        assert b2;


        boolean b3 = false;
        try {
            b3 = locationManager.delete(5L);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        assert !b3;
    }
}