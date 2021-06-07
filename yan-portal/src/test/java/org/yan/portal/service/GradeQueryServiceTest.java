package org.yan.portal.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.major.Grade;
import org.yan.portal.exception.QueryException;

@SpringBootTest
@RunWith(SpringRunner.class)
class GradeQueryServiceTest {

    @Autowired
    GradeQueryService gradeQueryService;

    @Test
    void testQueryGradesCase1() {
        try {
            Grade grade = gradeQueryService.queryGrade(1L, 1L, "2019");
            System.out.println(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testQueryGradesCase2() {
        try {
            Grade grade = gradeQueryService.queryGrade(1L, 1L, "2018");
            System.out.println(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testQueryGradesCase3() {
        try {
            Grade grade = gradeQueryService.queryGrade(1L, 3L, "2018");
            System.out.println(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testQueryGradesCase4() {
        try {
            gradeQueryService.queryAllGrades(1L, 2L);
        } catch (QueryException e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryLatestYearGradeCase1() {
        try {
            Grade grade = gradeQueryService.queryLatestYearGrade(1L, 1L);
            System.out.println(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryLatestYearGradeCase2() {
        try {
            Grade grade = gradeQueryService.queryLatestYearGrade(2L, 1L);
            System.out.println(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}