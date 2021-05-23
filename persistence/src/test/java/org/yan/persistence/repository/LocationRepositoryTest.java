package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.persistence.entity.university.Location;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class LocationRepositoryTest {
    @Autowired
    LocationRepository locationRepository;

    @Test
    void save() {
        Location location = new Location(110.0, 100.0);
        location.setId(4L);
        location = locationRepository.save(location);
        System.out.println(location.getId());
    }

    @Test
    @Transactional
    void save_case2() {
        Location location = new Location(130.0, 200.0);
        locationRepository.save(location);
    }

    @Test
    void testFindAll() {
        Iterable<Location> locations = locationRepository.findAll();
        locations.forEach(System.out::println);
    }

    @Test
    void findOneByUniversityId() {
        Location location = locationRepository.findByUniversity_Id(3L);
        System.out.println(location);
    }

    @Test
    void findById() {
        Optional<Location> optional = locationRepository.findById(new Long(4));
        Location location = optional.get();
        System.out.println(location);
    }

    @Test
    void findByLongitudeAndAndLatitude() {
        Location location = locationRepository.findByLongitudeAndAndLatitude(120, 200);
        System.out.println(location);
    }

    @Test
    void existsLocationByLongitudeAndLatitude() {
        // case1.
        boolean b1 = locationRepository.existsLocationByLongitudeAndLatitude(1, 1);
        assert b1;

        // cas2.
        boolean b2 = locationRepository.existsLocationByLongitudeAndLatitude(1, 10);
        assert !b2;
    }
}