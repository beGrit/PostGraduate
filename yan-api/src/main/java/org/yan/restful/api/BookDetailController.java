package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.persistence.entity.book.BookDetail;
import org.yan.persistence.repository.BookDetailRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v2.2/book/detail")
public class BookDetailController {

    @Autowired
    BookDetailRepository repository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResult list() {
        Iterable<BookDetail> bookDetails = repository.findAll();
        return CommonResult.success(bookDetails);
    }

    @RequestMapping(value = "one", method = RequestMethod.GET)
    public CommonResult one(@RequestParam("bid") Long bid) {
        Optional<BookDetail> optional = repository.findById(bid);
        BookDetail bookDetail = optional.get();
        return CommonResult.success(bookDetail);
    }
}
