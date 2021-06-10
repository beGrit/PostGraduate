package org.yan.restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.yan.persistence.entity.major.MasterMajor;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "major", path = "major")
public interface MasterMajorRestFulRepository extends PagingAndSortingRepository<MasterMajor, Long> {
    List<MasterMajor> findByName(@Param("name") String name);
}
