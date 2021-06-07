package org.yan.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.major.Grade;

import java.util.List;

public interface GradeRepository extends CrudRepository<Grade, Long> {

}
