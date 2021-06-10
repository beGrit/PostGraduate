package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.entity.university.UniversityNews;
import org.yan.persistence.enums.AttachmentType;
import org.yan.persistence.enums.NewsType;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniversityNewsRepositoryTest {

    @Autowired
    UniversityNewsRepository repository;

    @Autowired
    UniversityRepository universityRepository;

    @Test
    void save() {
        University university = universityRepository.findById(3L).get();
        UniversityNews news = new UniversityNews(3L, "成都理工大学摄影专业相关资讯!",
                new Date(), "/university/news/foo3.txt",
                AttachmentType.ATTACHMENT_TYPE_DOC,
                NewsType.NEWS_TYPE_FUN, university);
        UniversityNews saved = repository.save(news);
        System.out.println();
    }
}