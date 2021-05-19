package org.yan.persistence.entity.university;

import org.yan.persistence.entity.university.University;

import javax.persistence.*;

@Entity
@Table(name = "UMS_LOCATION")
public class Location {

    @Id
    private Long id;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    @OneToOne(mappedBy = "location")
    private University university;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Location() {
    }

    public Location(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return id + "( " + latitude + "," + longitude + " )";
    }
}