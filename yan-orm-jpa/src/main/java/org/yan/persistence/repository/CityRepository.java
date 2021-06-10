package org.yan.persistence.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.City;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "cities", path = "city")
public interface CityRepository extends CrudRepository<City, Long> {
    City findByNameIs(String name);

    @Override
    Optional<City> findById(Long id);

    @Override
    boolean existsById(Long aLong);

    @Override
    City save(City s);

    @Query(value = "SELECT * FROM UMS_CITY",
            countQuery = "SELECT count(*) FROM UMS_CITY",
            nativeQuery = true)
    Page<City> findAll(Pageable pageable);

    Long countDistinctByIdNotNull();
}
