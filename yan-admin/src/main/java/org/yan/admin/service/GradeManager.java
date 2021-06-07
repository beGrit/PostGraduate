package org.yan.admin.service;

import org.yan.persistence.entity.major.Grade;

import java.util.List;

public interface GradeManager {

    /**
     * 根据 uid + mid 查询成绩
     * @param uid
     * @param mid
     * @return null || List<Grade>
     */
    List<Grade> findGradeListByUidAndMid(Long uid, Long mid);
}
