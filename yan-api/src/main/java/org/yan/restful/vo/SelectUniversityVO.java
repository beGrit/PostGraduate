package org.yan.restful.vo;

import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.University;

import java.util.List;

public class SelectUniversityVO {
    private List<University> universities;
    private City city;

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
