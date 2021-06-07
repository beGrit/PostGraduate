package org.yan.admin.dto;

import org.yan.persistence.entity.university.University;

public class AddUniversityDTO {
    private University university;

    private Long cid;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
