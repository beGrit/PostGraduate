package org.yan.restful.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.admin.exception.basic.CrudException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class SelectUniversityServiceImplTest {

    @Autowired
    SelectUniversityServiceImpl service;

    @Test
    void getSelectList() throws CrudException {
        List<Object> rtn = service.getSelectList();
        System.out.println();
    }
}