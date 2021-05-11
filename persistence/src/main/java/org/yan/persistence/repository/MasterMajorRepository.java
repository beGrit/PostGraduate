package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.MasterMajor;

public interface MasterMajorRepository extends CrudRepository<MasterMajor, Long> {
    MasterMajor findMajorById(Long id);
}
