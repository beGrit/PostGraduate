package org.yan.restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.yan.persistence.entity.university.UniversityNews;

@RepositoryRestResource(collectionResourceRel = "newsList", path = "news")
public interface UniversityNewsRestFulRepository extends PagingAndSortingRepository<UniversityNews, Long> {
}
