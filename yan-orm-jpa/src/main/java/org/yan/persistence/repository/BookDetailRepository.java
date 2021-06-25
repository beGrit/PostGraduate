package org.yan.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.yan.persistence.entity.book.BookDetail;

import java.util.Optional;

public interface BookDetailRepository extends CrudRepository<BookDetail, Long> {
    @Override
    Optional<BookDetail> findById(Long aLong);

    @Override
    Iterable<BookDetail> findAll();
}
