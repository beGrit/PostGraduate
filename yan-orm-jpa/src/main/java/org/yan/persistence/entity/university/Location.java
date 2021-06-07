package org.yan.persistence.entity.university;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "UMS_LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 经度
     */
    @ApiModelProperty("经度")
    private Double longitude;

    /**
     * 纬度
     */
    @ApiModelProperty("纬度")
        private Double latitude;

    @OneToOne(mappedBy = "location", fetch = FetchType.LAZY)
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

    public Location(Long id, Double longitude, Double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return id + "( " + latitude + "," + longitude + " )";
    }
}