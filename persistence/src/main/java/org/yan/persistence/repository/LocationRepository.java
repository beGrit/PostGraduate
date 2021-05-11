package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByUniversity_Id(Long uid);
}
