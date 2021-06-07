package org.yan.portal.service;

import org.yan.persistence.entity.major.Grade;
import org.yan.portal.exception.QueryException;
import org.yan.portal.jo.GradeJO;

public interface GradeQueryService {
    /**
     * 根据 院校id专业id和年份 查询 指定年份的 分数线
     *
     * @param universityId 院校id
     * @param majorId      专业 id
     * @param year         年份
     * @return 成绩
     */
    Grade queryGrade(Long universityId, Long majorId, String year) throws Exception;

    /**
     * 根据 院校id和专业id 查询 最近一年的 分数线
     *
     * @param universityId 院校ID
     * @param majorId      专业ID
     * @return 成绩
     * @throws Exception
     */
    Grade queryLatestYearGrade(Long universityId, Long majorId) throws Exception;

    /**
     * 根据 院校id和专业id 获取相关的所有分数线
     *
     * @param universityId
     * @param majorId
     * @return
     * @throws QueryException
     */
    GradeJO queryAllGrades(Long universityId, Long majorId) throws QueryException;
}
