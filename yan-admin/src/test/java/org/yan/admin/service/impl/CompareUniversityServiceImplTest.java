package org.yan.admin.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.admin.domain.ComparedInfo;
import org.yan.common.exception.basic.QueryException;


@SpringBootTest
@RunWith(SpringRunner.class)
class CompareUniversityServiceImplTest {

    @Autowired
    CompareUniversityServiceImpl service;

    @Test
    void compareUniversities() {
        try {
            Long[] idList = new Long[]{1L, 2L, 3L};
            ComparedInfo comparedInfo = service.compareUniversities(idList, 1L);
            System.out.println(comparedInfo);
        } catch (QueryException e) {
            e.printStackTrace();
        }
    }
}