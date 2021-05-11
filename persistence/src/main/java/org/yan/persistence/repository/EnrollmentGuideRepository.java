package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.EnrollmentGuide;

import java.util.List;

public interface EnrollmentGuideRepository extends CrudRepository<EnrollmentGuide, Long> {
    List<EnrollmentGuide> findByUniversity_Id(Long id);
}
