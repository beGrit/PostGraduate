package org.yan.persistence.entity.university;

import org.yan.persistence.enums.NewsType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UMS_UNIVERSITY_NEWS")
public class UniversityNews extends Announcement {

    private NewsType newsType;

    @ManyToOne(optional = true)
    private University university;

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
