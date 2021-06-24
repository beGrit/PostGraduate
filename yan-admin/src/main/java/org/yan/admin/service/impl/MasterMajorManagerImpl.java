package org.yan.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yan.admin.service.manager.MasterMajorManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.MasterMajorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MasterMajorManagerImpl implements MasterMajorManager {

    @Autowired
    MasterMajorRepository repository;

    @Override
    public List<MasterMajor> queryByPage(Integer pageIndex, Integer pageSize) throws QueryException {
        Page<MasterMajor> rtn = repository.findAll(PageRequest.of(pageIndex - 1, pageSize));
        if (rtn.getNumberOfElements() == 0) {
            throw new QueryException("数据集为空");
        } else {
            return rtn.getContent();
        }
    }

    @Override
    public Long getTotal() {
        return repository.countDistinctByIdNotNull();
    }


    @Override
    @Transactional
    public void add(Object b) throws CrudException {
        MasterMajor major = (MasterMajor) b;
        try {
            repository.save(major);
        } catch (Exception e) {
            throw new CrudException();
        }
    }

    @Override
    public MasterMajor queryById(Long id) throws QueryException {
        Optional<MasterMajor> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new QueryException("查找失败");
        }
    }

    @Override
    public List<MasterMajor> queryByIdList(Long[] idList) throws QueryException {
        return null;
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
