package org.yan.restful.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class SelectMajorServiceImplTest {

    @Autowired
    SelectMajorServiceImpl service;

    @Test
    void getSelectList() throws CrudException {
        List<MasterMajor> list = service.getSelectList();
        System.out.println();
    }
}