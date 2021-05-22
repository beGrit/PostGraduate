package org.yan.persistence.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityRepositoryTest {
    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    LocationRepository locationRepository;

    @Test
    void testQueryAll() {
        List<University> universities = (List<University>) universityRepository.findAll();
        String city = universities.get(0).getCity();
        System.out.println(city);
    }

    @Test
    void findAllByIsYJSYEquals() {
        Pageable first = PageRequest.of(0, 2).first();
        Page<University> list = universityRepository.findByNameIs("北京大学", first);
        System.out.println(list.getTotalPages());
        list.getTotalElements();
        list.stream().forEach(System.out::println);
    }

    @Test
//    @Transactional
    void saveTest() {
        University hzsfdx = new University(11L, "杭州师范大学", 1, 1, 20, 0, 0, "www.hzsfdx.com");
        Location location = locationRepository.save(new Location(9L, 222.0, 210.0));

        City hz = cityRepository.findByNameIs("杭州");

        hzsfdx.setLocation(location);
        hzsfdx.setCity(hz);

        universityRepository.save(hzsfdx);
    }

    @Test
    void testFindLocationById() {
        Optional<University> universityOptional = universityRepository.findById(1L);
        universityOptional.ifPresent(university -> {
            System.out.println(university.getLocation());
        });
    }

    @Test
    void testFindAllLocation() {
        Iterable<University> universities = universityRepository.findAll();
        universities.forEach(university -> {
            System.out.println(university.getLocation());
        });
    }

    @Test
    void existsUniversityByLocation_Id() {
        // case 1
        boolean b1 = universityRepository.existsUniversityByLocation_Id(7L);
        assert b1;

        // case 2
        boolean b2 = universityRepository.existsUniversityByLocation_Id(1L);
        assert !b2;
    }

    @Test
    void countDistinctByIdNotNull() {
        Long count = universityRepository.countDistinctByIdNotNull();
        System.out.println(count);
    }

    @Test
    void testFindById() {
        Optional<University> byId = universityRepository.findById(9L);
        assert !byId.isPresent();
    }

    @Test
    void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<University> page = universityRepository.findAll(pageRequest);
        List<University> content = page.getContent();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(page);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
//    @Transactional
    void testDelete() {
        Optional<University> optionalUniversity = universityRepository.findById(11L);
        if (optionalUniversity.isPresent()) {
            University university = optionalUniversity.get();
            universityRepository.delete(university);
        }
    }

    @Test
    @Transactional
    void delete() {
        Optional<University> optional = universityRepository.findById(1L);
        University university = optional.get();
        universityRepository.delete(university);
    }

    @Test
    @Transactional
    void deleteById() {
        // case1.
        universityRepository.deleteById(4L);
        System.out.println();
    }
}