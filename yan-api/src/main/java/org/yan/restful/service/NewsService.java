package org.yan.restful.service;

import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.UniversityNews;

import java.util.List;

public interface NewsService {
    List<UniversityNews> getAllNews() throws QueryException;

    UniversityNews getById(Long id) throws QueryException;
}
