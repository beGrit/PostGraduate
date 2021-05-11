package org.yan.persistence.entity.major;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMS_GRADE")
public class Grade {
    @Id
    private Long id;

    @Column(nullable = false)
    private String year;

    private Integer average;

    private Integer maxGrade;

    private Integer minGrade;

    private Integer numberOfExaminee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Integer getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Integer maxGrade) {
        this.maxGrade = maxGrade;
    }

    public Integer getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(Integer minGrade) {
        this.minGrade = minGrade;
    }

    public Integer getNumberOfExaminee() {
        return numberOfExaminee;
    }

    public void setNumberOfExaminee(Integer numberOfExaminee) {
        this.numberOfExaminee = numberOfExaminee;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", average=" + average +
                ", maxGrade=" + maxGrade +
                ", minGrade=" + minGrade +
                ", numberOfExaminee=" + numberOfExaminee +
                '}';
    }
}
