package org.yan.persistence.entity.university;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

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
     * 院校全国排名
     */
    private int rank;

    /**
     * 是否为研究生院校 (0 不是, 1 是)
     */
    private int isYJSY;

    /**
     * 是否为自划线 (0 不是, 1 是)
     */
    private int isZHX;

    /**
     * 是否是985院校
     */
    private int isJBW;

    /**
     * 是否是211院校
     */
    private int isEYY;

    /**
     * icon路径
     */
    private String iconPath;

    /**
     * 官方网站地址
     */
    private String officialUrl;

    /**
     * 该院校所在的城市
     */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIsYJSY() {
        return isYJSY;
    }

    public int getIsZHX() {
        return isZHX;
    }

    public int getRank() {
        return rank;
    }

    public String getOfficialUrl() {
        return officialUrl;
    }

    public String getCity() {
        return city.getName();
    }

    public int getIsJBW() {
        return isJBW;
    }

    public int getIsEYY() {
        return isEYY;
    }


    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsYJSY(int isYJSY) {
        this.isYJSY = isYJSY;
    }

    public void setIsZHX(int isZHX) {
        this.isZHX = isZHX;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setOfficialUrl(String officialUrl) {
        this.officialUrl = officialUrl;
    }

    public void setIsJBW(int isJBW) {
        this.isJBW = isJBW;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setIsEYY(int isEYY) {
        this.isEYY = isEYY;
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

    public University(Long id, String name, int isYJSY, int isZHX, int rank, int isJBW, int isEYY, String officialUrl) {
        this.id = id;
        this.name = name;
        this.isYJSY = isYJSY;
        this.isZHX = isZHX;
        this.rank = rank;
        this.isJBW = isJBW;
        this.isEYY = isEYY;
        this.officialUrl = officialUrl;
    }
}
