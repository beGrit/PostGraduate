package org.yan.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.University;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    City findByNameIs(String name);

    @Override
    Optional<City> findById(Long id);

    @Override
    City save(City s);
}
