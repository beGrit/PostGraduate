package org.yan.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.university.Location;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade, Long> {

    @Override
    Grade save(Grade grade);

    @Query(value = "SELECT * FROM YanDatabase.MMS_GRADE",
            countQuery = "SELECT count(*) FROM YanDatabase.MMS_GRADE",
            nativeQuery = true)
    Page<Grade> findAll(Pageable pageable);

    Long countDistinctByIdNotNull();

    @Override
    @Query("select g from Grade g where g.id = ?1")
    Optional<Grade> findById(Long locationId);
}
