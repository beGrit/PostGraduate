package org.yan.persistence.repository;


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
}
