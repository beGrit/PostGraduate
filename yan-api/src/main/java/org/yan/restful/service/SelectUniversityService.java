package org.yan.restful.service;


import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.university.University;
import org.yan.restful.vo.CityUniversityVO;

import java.util.List;

public interface SelectUniversityService {
    public List<Object> getSelectList() throws CrudException;

    public List<CityUniversityVO> getSelectListByMajor(Long mid) throws CrudException;
}
