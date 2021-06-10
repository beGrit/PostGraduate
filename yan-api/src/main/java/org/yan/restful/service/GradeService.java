package org.yan.restful.service;

import org.yan.persistence.entity.major.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> queryGrade(Long uid, Long mid);
}
