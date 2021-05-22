package org.yan.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.yan.persistence.entity.university.University;

public interface UniversityRepository extends PagingAndSortingRepository<University, Long> {
    Page<University> findByNameIs(String name, Pageable pageable);

    boolean existsUniversityByLocation_Id(Long locationId);

    Long countDistinctByIdNotNull();


    /**
     * 查询第n页的数据
     *
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM UMS_UNIVERSITY",
            countQuery = "SELECT count(*) FROM UMS_UNIVERSITY",
            nativeQuery = true)
    Page<University> findAll(Pageable pageable);


    @Override
    void delete(University university);

    @Override
    void deleteById(Long aLong);
}
