package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.repository.UserDetailInfoRepository;
import org.yan.restful.service.UniversityHeatService;

@Service
public class UniversityHeatServiceImpl implements UniversityHeatService {

    @Autowired
    UserDetailInfoRepository userDetailInfoRepository;

    @Override
    public int getTotalConcernedUserByUid(Long uid) throws CrudException {
        int count = userDetailInfoRepository.countDistinctByUniversity(uid);
        return count;
    }
}
