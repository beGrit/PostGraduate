package org.yan.restful.vo;

import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.university.University;

import java.util.List;

public class UniversityGradesVO {
    private University university;

    private List<Grade> grades;

    public UniversityGradesVO() {
    }

    public UniversityGradesVO(University university, List<Grade> grades) {
        this.university = university;
        this.grades = grades;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
