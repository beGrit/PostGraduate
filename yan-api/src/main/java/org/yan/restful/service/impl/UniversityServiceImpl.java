package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;

import java.util.LinkedList;
import java.util.List;

public class UniversityServiceImpl {
    @Autowired
    UniversityOpenMasterMajorRepository uomRepository;

    public List<University> findByMid(Long mid) throws QueryException {
        try {
            List<UniversityOpenMasterMajor> allUOM = uomRepository.findAllByMasterMajorId(mid);
            List<University> universityList = new LinkedList<>();
            allUOM.stream().forEach(t -> {
                universityList.add(t.getUniversity());
            });
            return universityList;
        } catch (Exception e) {
            throw new QueryException();
        }
    }
}
