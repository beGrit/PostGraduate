package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;
import org.yan.restful.service.GradeService;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    UniversityOpenMasterMajorRepository repository;

    @Override
    public List<Grade> queryGrade(Long uid, Long mid) {
        List<Grade> rtn = null;
        Optional<UniversityOpenMasterMajor> optional = repository.findByUniversity_IdAndMasterMajor_Id(uid, mid);
        if (optional.isPresent()) {
            List<Grade> grades = optional.get().getGrades();
            grades.sort(Grade::gradeYearCompare);
            rtn = grades;
        }

        return rtn;
    }
}
