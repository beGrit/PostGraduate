package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityRepositoryTest {
    @Autowired
    UniversityRepository repository;

    @Test
    void testQueryAll() {
        List<University> universities = (List<University>) repository.findAll();
//        Long city = universities.get(0).getCity();
        String city = universities.get(0).getCity();
        System.out.println(city);
    }

    @Test
    void findAllByIsYJSYEquals() {
        Pageable first = PageRequest.of(0, 2).first();
        Page<University> list = repository.findByNameIs("北京大学", first);
        System.out.println(list.getTotalPages());
        list.getTotalElements();
        list.stream().forEach(System.out::println);
    }

    @Test
    void saveTest() {
        City beijing = new City("北京市");

        University beida = new University(
                "北京大学", 1, 1, 1, 1, 1, "www.beida.com"
        );
        Location beijingLocation = new Location(1.0, 1.0);

        beida.setCity(beijing);
        beida.setLocation(beijingLocation);

        repository.save(beida);
    }

    @Test
    void testFindLocationById() {
        Optional<University> universityOptional = repository.findById(1L);
        universityOptional.ifPresent(university -> {
            System.out.println(university.getLocation());
        });
    }

    @Test
    void testFindAllLocation() {
        Iterable<University> universities = repository.findAll();
        universities.forEach(university -> {
            System.out.println(university.getLocation());
        });
    }
}