package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {

}
