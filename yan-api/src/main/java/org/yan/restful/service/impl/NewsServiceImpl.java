package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.university.UniversityNews;
import org.yan.persistence.repository.UniversityNewsRepository;
import org.yan.restful.service.NewsService;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    UniversityNewsRepository repository;

    @Override
    public List<UniversityNews> getAllNews() throws QueryException {
        try {
            return (List<UniversityNews>) repository.findAll();
        } catch (Exception e) {
            throw new QueryException();
        }
    }

    @Override
    public UniversityNews getById(Long id) throws QueryException {
        Optional<UniversityNews> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new QueryException();
        } else {
            return optional.get();
        }
    }
}
