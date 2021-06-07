package org.yan.persistence.entity.major;

import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.University;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP")
public class UniversityOpenMasterMajor { // 院校开放专业
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToOne
    @JoinColumn(name = "master_major_id")
    private MasterMajor masterMajor;

    private Integer curHasStudents;

    private Date theOpeningTime;

    private String description;

    private Integer rank;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MMS_MASTER_MAJOR_GRADES", joinColumns = {
            @JoinColumn(name = "mater_major_id")}, inverseJoinColumns = {@JoinColumn(name = "grade_id")})
    private List<Grade> grades;

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
