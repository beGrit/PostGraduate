package org.yan.admin.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.exception.basic.UpdateException;
import org.yan.persistence.entity.university.Location;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class LocationServiceImplTest {

    @Autowired
    LocationServiceImpl locationService;

    @Test
    @Transactional
    void   save() {
        try {
            locationService.save(new Location(88.0, 99.0));
        } catch (UpdateException e) {
            e.printStackTrace();
        }
    }
}