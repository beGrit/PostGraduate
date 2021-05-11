package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.university.Location;

@SpringBootTest
@RunWith(SpringRunner.class)
class LocationRepositoryTest {
    @Autowired
    LocationRepository repository;

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
}