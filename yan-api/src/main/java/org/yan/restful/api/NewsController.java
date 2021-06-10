package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.UniversityNews;
import org.yan.restful.service.NewsService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.1/news")
public class NewsController {
    @Autowired
    NewsService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResult list() throws QueryException {
        List<UniversityNews> newsList = service.getAllNews();
        return CommonResult.success(newsList);
    }

    @RequestMapping(value = "one", method = RequestMethod.GET)
    public CommonResult one(@RequestParam("newsId") Long newsId) throws QueryException {
        return CommonResult.success(service.getById(newsId));
    }
}
