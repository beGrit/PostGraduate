package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.yan.admin.service.manager.GradeManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.major.UniversityOpenMasterMajor;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.repository.GradeRepository;
import org.yan.persistence.repository.UniversityOpenMasterMajorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GradeManagerImpl implements GradeManager {

    @Autowired
    GradeRepository gradeRepository;

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

    @Override
    public List<Grade> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException {
        Page<Grade> rtn = gradeRepository.findAll(PageRequest.of(pageIndex - 1, pageSize));
        if (rtn.getNumberOfElements() == 0) {
            throw new QueryException("数据集为空");
        } else {
            return rtn.getContent();
        }
    }

    @Override
    public Grade queryById(Long id) throws QueryException {
        return null;
    }

    @Override
    public List<Grade> queryByIdList(Long[] idList) throws QueryException {
        return null;
    }

    @Override
    public Long getTotal() {
        return gradeRepository.countDistinctByIdNotNull();
    }

    @Override
    public void add(Object b) throws CrudException {

    }

    @Override
    public void delete(Long id) throws CrudException {

    }

    @Override
    public void batchDelete(List<Long> idList) throws CrudException {

    }

    @Override
    public void save(Object b) throws CrudException {

    }
}
