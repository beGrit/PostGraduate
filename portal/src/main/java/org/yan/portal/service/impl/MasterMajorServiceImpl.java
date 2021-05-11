package org.yan.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.repository.GradeRepository;
import org.yan.persistence.repository.MasterMajorRepository;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;
import org.yan.portal.service.MasterMajorService;

import java.util.List;
import java.util.Optional;

@Service
public class MasterMajorServiceImpl implements MasterMajorService {

    @Autowired
    MasterMajorRepository repository;

    @Autowired
    UniversityOpenMasterMajorRepository uomRepository;

    @Override
    public void addNewMajor(MasterMajor masterMajor) throws Exception {
        MasterMajor major = repository.findMajorById(masterMajor.getId());
        if (major == null) {
            repository.save(masterMajor);
        } else {
            throw new Exception("重复添加");
        }
    }
}
