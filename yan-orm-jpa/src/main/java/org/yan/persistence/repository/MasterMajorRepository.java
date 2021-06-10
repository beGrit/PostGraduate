package org.yan.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.entity.university.City;

public interface MasterMajorRepository extends CrudRepository<MasterMajor, Long> {
    MasterMajor findMajorById(Long id);

    @Query(value = "SELECT * FROM MMS_MASTER_MAJOR",
            countQuery = "SELECT count(*) FROM MMS_MASTER_MAJOR",
            nativeQuery = true)
    Page<MasterMajor> findAll(Pageable pageable);

    Long countDistinctByIdNotNull();
}
