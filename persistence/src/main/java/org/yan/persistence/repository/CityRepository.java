package org.yan.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.City;

public interface CityRepository extends CrudRepository<City, Long> {
}
