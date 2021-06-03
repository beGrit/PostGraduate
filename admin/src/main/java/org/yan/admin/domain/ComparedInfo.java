package org.yan.admin.domain;

import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.university.University;

import java.util.List;
import java.util.Map;

/**
 * 比较后的结果
 */
public class ComparedInfo {

    /**
     * 被比较的院校列表
     */
    private List<University> universityList;

    /**
     * 院校的分数线
     */
    private Map<String, List<Grade>> gradeList;

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }
}
