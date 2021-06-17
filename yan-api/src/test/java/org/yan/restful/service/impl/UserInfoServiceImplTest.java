package org.yan.restful.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.common.exception.basic.CrudException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserInfoServiceImplTest {

    @Autowired
    UserInfoServiceImpl service;

    @Test
    @Transactional
    void changeConcernedUniversity() throws CrudException {
        service.changeConcernedUniversity(1L, 2L, 1L);
        System.out.println();
    }
}