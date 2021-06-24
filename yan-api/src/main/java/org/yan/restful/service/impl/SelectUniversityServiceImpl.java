package org.yan.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yan.admin.service.manager.UomManager;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.University;
import org.yan.persistence.repository.CityRepository;
import org.yan.persistence.repository.UniversityRepository;
import org.yan.restful.service.SelectUniversityService;
import org.yan.restful.vo.CityUniversityVO;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class SelectUniversityServiceImpl implements SelectUniversityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    UomManager uomManager;


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

    @Override
    public List<CityUniversityVO> getSelectListByMajor(Long mid) throws CrudException {
        List<CityUniversityVO> rtn = new LinkedList<>();
        Map<String, CityUniversityVO> map = new HashMap<>();

        List<University> universities = uomManager.findUniversityListByMajorId(mid);
        for (University university : universities) {
            try {
                String cityName = university.getCity();
                if (map.containsKey(cityName)) {
                    map.get(cityName).getUniversities().add(university);
                } else {
                    Class<? extends University> universityClass = university.getClass();
                    Field cityFiled = universityClass.getDeclaredField("city");
                    cityFiled.setAccessible(true);
                    City city = (City) cityFiled.get(university);
                    map.put(cityName, new CityUniversityVO(city));

                    map.get(cityName).getUniversities().add(university);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        for (String key : map.keySet()) {
            rtn.add(map.get(key));
        }

        return rtn;
    }
}
