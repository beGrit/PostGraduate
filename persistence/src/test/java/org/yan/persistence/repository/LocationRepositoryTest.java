package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.university.Location;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class LocationRepositoryTest {
    @Autowired
    LocationRepository repository;

    @Test
    void save() {
        Location location = new Location(110.0, 100.0);
        location.setId(4L);
        location = repository.save(location);
        System.out.println(location.getId());
    }

    @Test
    void testFindAll() {
        Iterable<Location> locations = repository.findAll();
        locations.forEach(System.out::println);
    }

    @Test
    void findOneByUniversityId() {
        Location location = repository.findByUniversity_Id(3L);
        System.out.println(location);
    }

    @Test
    void findById() {
        Optional<Location> optional = repository.findById(new Long(3));
        Location location = optional.get();
        System.out.println(location);
    }

    @Test
    void findByLongitudeAndAndLatitude() {
        Location location = repository.findByLongitudeAndAndLatitude(120, 200);
        System.out.println(location);
    }
}