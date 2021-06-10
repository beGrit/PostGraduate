package org.yan.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.UniversityNews;

public interface UniversityNewsRepository extends CrudRepository<UniversityNews, Long> {
    @Override
    <S extends UniversityNews> S save(S s);

    @Override
    Iterable<UniversityNews> findAll();
}
