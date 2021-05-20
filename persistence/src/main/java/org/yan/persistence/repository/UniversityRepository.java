package org.yan.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.yan.persistence.entity.university.University;

public interface UniversityRepository extends PagingAndSortingRepository<University, Long> {
    Page<University> findByNameIs(String name, Pageable pageable);

    boolean existsUniversityByLocation_Id(Long locationId);
}
