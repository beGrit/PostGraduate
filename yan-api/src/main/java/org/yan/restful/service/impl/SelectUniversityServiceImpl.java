package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.repository.CityRepository;
import org.yan.persistence.repository.UniversityRepository;
import org.yan.restful.service.SelectUniversityService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class SelectUniversityServiceImpl implements SelectUniversityService {

    @Autowired
    CityRepository cityRepository;

    public List<Object> getSelectList() throws CrudException {

        List rtn = new LinkedList();
        Iterable<City> cityIterable = cityRepository.findAll();
        cityIterable.forEach(city -> {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("city", city);
            if (city.getUniversitySet().isEmpty()) {
                map1.put("universities", null);
            } else {
                map1.put("universities", city.getUniversitySet());
            }
            rtn.add(map1);
        });
        return rtn;
    }
}
