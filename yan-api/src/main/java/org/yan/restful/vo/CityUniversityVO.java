package org.yan.restful.vo;

import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.University;

import java.util.LinkedList;
import java.util.List;

public class CityUniversityVO {
    private City city;
    private List<University> universities;

    public CityUniversityVO() {

    }

    public CityUniversityVO(City city) {
        this.city = city;
        this.universities = new LinkedList<>();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }
}
