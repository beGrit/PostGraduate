package org.yan.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.persistence.repository.MasterMajorRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/portal/masterMajor/")
public class MasterMajorController {
    @Autowired
    MasterMajorRepository repository;

    @RequestMapping("/id/{id}")
    public Map queryUniversityById(@PathVariable("id") Long id) {
        Optional<MasterMajor> optional = repository.findById(id);
        MasterMajor masterMajor = optional.get();
        HashMap<String, Object> rtn = new HashMap<>();
        rtn.put("code", 200);
        rtn.put("message", "成功");
        rtn.put("data", Collections.singletonMap("masterMajor", masterMajor));
        return rtn;
    }
}
