package org.yan.restful.service;

import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;

import java.util.List;

public interface SelectMajorService {
    public List<MasterMajor> getSelectList() throws CrudException;
}
