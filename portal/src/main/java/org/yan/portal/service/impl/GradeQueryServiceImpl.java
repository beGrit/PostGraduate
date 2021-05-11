package org.yan.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;
import org.yan.portal.exception.QueryException;
import org.yan.portal.service.GradeQueryService;
import org.yan.portal.jo.GradeJO;

import java.util.List;

@Service
public class GradeQueryServiceImpl implements GradeQueryService {
    @Autowired
    UniversityOpenMasterMajorRepository uomRepository;

    public Grade queryGrade(Long universityId, Long majorId, String year) throws Exception {
        Grade rtn = null;
        UniversityOpenMasterMajor uom = uomRepository.findByUniversity_IdAndMasterMajor_Id(universityId, majorId);
        if (uom != null) {
            List<Grade> grades = uom.getGrades();
            for (Grade grade : grades) {
                if (grade.getYear().equals(year)) {
                    rtn = grade;
                }
            }
            if (rtn != null) {
                return rtn;
            } else {
                throw new Exception("该院校开设了该专业,但是未公布 + " + year + "的成绩");
            }
        } else {
            throw new Exception("该院校未开设该专业");
        }
    }

    @Override
    public Grade queryLatestYearGrade(Long universityId, Long majorId) throws Exception {
        Grade rtn = null;
        UniversityOpenMasterMajor uom = uomRepository.findByUniversity_IdAndMasterMajor_Id(universityId, majorId);
        if (uom != null) {
            List<Grade> grades = uom.getGrades();
            if (grades != null) {
                grades.sort((grade, otherGrade) -> {
                    int year1 = Integer.parseInt(grade.getYear());
                    int year2 = Integer.parseInt(otherGrade.getYear());
                    if (year1 < year2) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                return grades.get(0);
            } else {
                throw new Exception("该院校未公布任何成绩");
            }
        } else {
            throw new Exception("该院校未开设该专业");
        }
    }

    @Override
    public GradeJO queryAllGrades(Long universityId, Long majorId) throws QueryException {
        GradeJO rtn = null;
        UniversityOpenMasterMajor uom = uomRepository.findByUniversity_IdAndMasterMajor_Id(universityId, majorId);
        if (uom != null) {
            List<Grade> grades = uom.getGrades();
            if (grades != null) {
                grades.sort((grade, otherGrade) -> {
                    int year1 = Integer.parseInt(grade.getYear());
                    int year2 = Integer.parseInt(otherGrade.getYear());
                    if (year1 < year2) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                return new GradeJO(grades.size(), grades);
            } else {
                throw new QueryException("该院校未公布任何成绩");
            }
        } else {
            throw new QueryException("该院校未开设该专业");
        }
    }
}
