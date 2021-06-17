package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.manager.MasterMajorManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.repository.MasterMajorRepository;
import org.yan.restful.service.SelectMajorService;

import java.util.List;

@Service
public class SelectMajorServiceImpl implements SelectMajorService {
    @Autowired
    MasterMajorRepository repository;

    @Override
    public List<MasterMajor> getSelectList() throws CrudException {
        try {
            Iterable<MasterMajor> iterable = repository.findAll();
            return (List<MasterMajor>) (iterable);
        } catch (Exception e) {
            throw new CrudException();
        }
    }
}
