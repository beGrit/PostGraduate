package org.yan.persistence.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "AMS_BOOK_USER_BASIC_INFO")
public class BookStoreUser extends UserBasicInfo {
    private int age;

    private int gender;

    private String img;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getImg() {
        return this.getAvatarPath();
    }

    public void setImg(String img) {
        this.img = img;
        this.setAvatarPath(img);
    }
}
