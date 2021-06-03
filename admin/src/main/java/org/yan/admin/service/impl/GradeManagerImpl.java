package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.GradeManager;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GradeManagerImpl implements GradeManager {

    @Autowired
    UniversityOpenMasterMajorRepository repository;

    @Override
    public List<Grade> findGradeListByUidAndMid(Long uid, Long mid) {
        Optional<UniversityOpenMasterMajor> optional = repository.findByUniversity_IdAndMasterMajor_Id(uid, mid);
        if (optional.isPresent()) {
            return optional.get().getGrades();
        } else {
            return null;
        }
    }
}
