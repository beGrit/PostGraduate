package org.yan.restful.service;


import org.yan.common.exception.basic.CrudException;

import java.util.List;

public interface SelectUniversityService {
    public List<Object> getSelectList() throws CrudException;
}
