package org.yan.portal.service;


import org.yan.persistence.entity.university.University;

public interface UniversityService {
    /***
     * 院校添加专业服务
     * @param uid
     * @param majorId
     */
    void addMajor(Integer uid, Integer majorId);
}
