package org.yan.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Map queryUniversityById(@PathVariable("id") Long id) {
        Optional<University> byId = repository.findById(id);
        University university = byId.get();
        HashMap<String, Object> rtn = new HashMap<>();
        rtn.put("code", 200);
        rtn.put("message", "成功");
        rtn.put("data", Collections.singletonMap("university", university));
        return rtn;
    }
}
