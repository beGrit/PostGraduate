package org.yan.admin.form;


import org.springframework.beans.BeanUtils;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

public class AddUniversityForm {
    private Long id;

    /**
     * 院校名
     */
    private String name;

    /**
     * 是否为研究生院校 (0 不是, 1 是)
     */
    private int isYJSY = 0;

    /**
     * 是否为自划线 (0 不是, 1 是)
     */
    private int isZHX = 0;

    /**
     * 院校全国排名
     */
    private int rank = 0;

    /**
     * 是否是985院校
     */
    private int isJBW = 0;

    /**
     * 是否是211院校
     */
    private int isEYY = 0;

    /**
     * icon路径
     */
    private String iconPath;

    /**
     * 官方网站地址
     */
    private String officialUrl;

    private Double longitude;

    private Double latitude;

    private Long cityId;

    private Long locationId;

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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getOfficialUrl() {
        return officialUrl;
    }

    public void setOfficialUrl(String officialUrl) {
        this.officialUrl = officialUrl;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public University toUniversity() {
        University university = new University();
        Location location = new Location();

        BeanUtils.copyProperties(this, university);
        BeanUtils.copyProperties(this, location);

        location.setId(this.getLocationId());

        university.setLocation(location);
        return university;
    }
}
