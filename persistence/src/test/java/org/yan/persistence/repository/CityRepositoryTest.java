package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.University;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CityRepositoryTest {
    @Autowired
    CityRepository repository;

    @Test
    void save() {
        City hz = new City("杭州");
        hz.setId(1L);
        repository.save(hz);
    }

    @Test
    void findById() {
        Optional<City> byId = repository.findById(1L);
        City hz = byId.get();
        System.out.println(hz);
    }

    @Test
    void testFindByNameIs() {
        City hz = repository.findByNameIs("杭州");
        for (University university : hz.getUniversitySet()) {
            System.out.println(university.getName());
        }
    }
}