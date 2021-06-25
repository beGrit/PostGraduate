package org.yan.persistence.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yan.persistence.entity.book.BookDetail;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookDetailRepositoryTest {

    @Autowired
    BookDetailRepository repository;

    @Test
    void findById() {
        Optional<BookDetail> optional = repository.findById(1L);

        BookDetail bookDetail = optional.get();
        System.out.println(bookDetail);
    }

    @Test
    void findAll() {
        Iterable<BookDetail> bookDetails = repository.findAll();
        System.out.println();
    }
}