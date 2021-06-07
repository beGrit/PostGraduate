package org.yan.admin.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.major.Grade;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class GradeManagerImplTest {

    @Autowired
    GradeManagerImpl gradeManager;

    @Test
    void findGradeListByUidAndMid() {
        // case.1
        List<Grade> gradeList1 = gradeManager.findGradeListByUidAndMid(1L, 1L);
        System.out.println(gradeList1);

        // case.2
        List<Grade> gradeList2 = gradeManager.findGradeListByUidAndMid(2L, 1L);
        System.out.println(gradeList2);
    }
}