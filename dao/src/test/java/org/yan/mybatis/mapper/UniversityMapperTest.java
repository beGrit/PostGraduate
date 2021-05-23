package org.yan.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityMapperTest {

    @Autowired
    UniversityMapper universityMapper;

    @Test
    void findNameById() {
        String name = universityMapper.findNameById(1L);
        System.out.println(name);
    }
}