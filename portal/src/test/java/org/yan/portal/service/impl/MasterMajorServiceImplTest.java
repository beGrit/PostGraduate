package org.yan.portal.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.portal.service.MasterMajorService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MasterMajorServiceImplTest {

    @Autowired
    MasterMajorService service;

    @Test
    void addNewMajor() {
        try {
//            service.addNewMajor(new MasterMajor(1L, "软件工程", "11120", "软件"));
            service.addNewMajor(new MasterMajor(2L, "哲学", "11130", "哲学"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}