package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.manager.UomManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class UomManagerImpl implements UomManager {

    @Autowired
    UniversityOpenMasterMajorRepository repository;

    @Override
    public List<University> findUniversityListByMajorId(Long mid) throws CrudException {
        try {
            List<UniversityOpenMasterMajor> universityOpenMasterMajors = repository.findAllByMasterMajorId(mid);
            List<University> res = new LinkedList<>();
            for (UniversityOpenMasterMajor item : universityOpenMasterMajors) {
                res.add(item.getUniversity());
            }
            return res;
        } catch (Exception e) {
            throw new CrudException("根据专业查询院校失败");
        }
    }
}
