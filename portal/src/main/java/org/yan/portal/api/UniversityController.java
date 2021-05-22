package org.yan.portal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.UniversityRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/portal/university/")
public class UniversityController {

    @Autowired
    UniversityRepository repository;

    @RequestMapping("/id/{id}")
    public CommonResult<University> queryUniversityById(@PathVariable("id") Long id) {
        Optional<University> byId = repository.findById(id);
        University university = byId.get();
        return CommonResult.success(university);
    }
}
