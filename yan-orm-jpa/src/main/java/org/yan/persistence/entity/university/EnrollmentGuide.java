package org.yan.persistence.entity.university;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UMS_ENROLLMENT_GUIDE")
public class EnrollmentGuide extends Announcement {
    /**
     * 发布者的姓名*/
    @Column(nullable = false)
    private String publisherName;

    /**
     * 该招生文件属于哪一年*/
    private Date belongToYear;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "university_id")
    private University university;

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getBelongToYear() {
        return belongToYear;
    }

    public void setBelongToYear(Date belongToYear) {
        this.belongToYear = belongToYear;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }


}
