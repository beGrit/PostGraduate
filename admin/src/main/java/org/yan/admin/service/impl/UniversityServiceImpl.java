package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.UniversityService;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.UniversityRepository;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityRepository repository;

    @Override
    public List<University> queryByPage(Integer pageIndex, Integer pageSize) {
        List<University> rtn = (List<University>) repository.findAll();
        return rtn;
    }
}
