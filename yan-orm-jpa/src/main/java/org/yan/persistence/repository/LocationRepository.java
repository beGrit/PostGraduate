package org.yan.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import javax.persistence.NamedQuery;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByUniversity_Id(Long uid);

    Location findByLongitudeAndAndLatitude(double longitude, double latitude);

    boolean existsLocationByLongitudeAndLatitude(double longitude, double latitude);

    @Override
    @Query("select l from Location l where l.id = ?1")
    Optional<Location> findById(Long locationId);

    @Query(value = "SELECT * FROM UMS_LOCATION",
            countQuery = "SELECT count(*) FROM UMS_LOCATION",
            nativeQuery = true)
    Page<Location> findAll(Pageable pageable);


    @Override
    Location save(Location location);
}
