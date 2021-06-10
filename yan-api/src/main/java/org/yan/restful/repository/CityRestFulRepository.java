package org.yan.restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.yan.persistence.entity.university.City;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "city")
public interface CityRestFulRepository extends PagingAndSortingRepository<City, Long> {
    List<City> findByName(@Param("name") String name);
}
