package org.yan.portal.jo;

import org.yan.persistence.entity.major.Grade;

import java.util.List;

public class GradeJO { // Grade JSON域形式
    private Integer number;

    /**
     * 根据发布时间排好序的成绩单
     */
    private List<Grade> sortedGradeList;

    public GradeJO(Integer number, List<Grade> sortedGradeList) {
        this.number = number;
        this.sortedGradeList = sortedGradeList;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Grade> getSortedGradeList() {
        return sortedGradeList;
    }

    public void setSortedGradeList(List<Grade> sortedGradeList) {
        this.sortedGradeList = sortedGradeList;
    }
}
