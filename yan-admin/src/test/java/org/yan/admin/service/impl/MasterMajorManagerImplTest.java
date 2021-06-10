package org.yan.admin.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MasterMajorManagerImplTest {

    @Autowired
    MasterMajorManagerImpl manager;

    @Test
    @Transactional
    void add() throws CrudException {
        MasterMajor major = new MasterMajor(20L, "农业", "1000200", "");
        manager.add(major);
    }
}