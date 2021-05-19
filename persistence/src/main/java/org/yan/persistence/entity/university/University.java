package org.yan.persistence.entity.university;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "UMS_UNIVERSITY")
public class University {

    @Id
    private Long id;

    /**
     * 院校名
     */
    private String name;

    /**
     * 是否为研究生院校 (0 不是, 1 是)
     */
    private int isYJSY;

    /**
     * 是否为自划线 (0 不是, 1 是)
     */
    private int isZHX;

    /**
     * 院校全国排名
     */
    private int rank;

    /**
     * 是否是985院校
     */
    private int isJBW;

    /**
     * 是否是211院校
     */
    private int isEYY;

    /**
     * 官方网站地址
     */
    private String officialUrl;

    /**
     * 该院校所在的城市
     */
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsYJSY() {
        return isYJSY;
    }

    public void setIsYJSY(int isYJSY) {
        this.isYJSY = isYJSY;
    }

    public int getIsZHX() {
        return isZHX;
    }

    public void setIsZHX(int isZHX) {
        this.isZHX = isZHX;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getOfficialUrl() {
        return officialUrl;
    }

    public void setOfficialUrl(String officialUrl) {
        this.officialUrl = officialUrl;
    }

    public String getCity() {
        return city.getName();
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getIsJBW() {
        return isJBW;
    }

    public void setIsJBW(int isJBW) {
        this.isJBW = isJBW;
    }

    public int getIsEYY() {
        return isEYY;
    }

    public void setIsEYY(int isEYY) {
        this.isEYY = isEYY;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public University() {
    }

    public University(String name, int isYJSY, int isZHX, int rank, int isJBW, int isEYY, String officialUrl) {
        this.name = name;
        this.isYJSY = isYJSY;
        this.isZHX = isZHX;
        this.rank = rank;
        this.isJBW = isJBW;
        this.isEYY = isEYY;
        this.officialUrl = officialUrl;
    }
}
