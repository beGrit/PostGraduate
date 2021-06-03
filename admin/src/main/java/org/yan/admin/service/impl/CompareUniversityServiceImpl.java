package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.domain.ComparedInfo;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.service.CompareUniversityService;
import org.yan.admin.service.GradeManager;
import org.yan.admin.service.UniversityManager;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.university.University;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class CompareUniversityServiceImpl implements CompareUniversityService {

    @Autowired
    UniversityManager universityManager;

    @Autowired
    GradeManager gradeManager;

    @Override
    public ComparedInfo compareUniversities(Long[] uidList, Long mid) throws QueryException {
        int length = uidList.length;
        Map rtn = new HashMap<String, List<Grade>>();

        // 获取所有院校信息
        List<University> universityList = universityManager.queryByIdList(uidList);

        // 获取所有成绩信息
        List<Grade> gradeList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            gradeList = gradeManager.findGradeListByUidAndMid(uidList[i], mid);
            if (gradeList == null) {
                rtn.clear();
                break;
            } else {
                Collections.sort(gradeList, Grade::gradeYearCompare);
                rtn.put(universityList.get(i).getName(), gradeList);
            }
        }

        // 筛选成绩信息
        List<Grade> preList;
        for (int i = 0; i < length; i++) {

        }

        return null;
    }

    public void filter(List<List<String>> rawData) {

    }

}
