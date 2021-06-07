package org.yan.admin.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.exception.basic.CrudException;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.service.UniversityManager;
import org.yan.persistence.entity.university.University;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityManagerImplTest {

    @Autowired
    UniversityManager universityManager;

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
    void queryById() {
    }

    @Test
    void queryByPage() {
    }

    @Test
    void queryAll() {
    }

    @Test
    void updateUniversityLocation() {
    }
}