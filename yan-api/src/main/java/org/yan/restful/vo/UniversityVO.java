package org.yan.restful.vo;

import org.yan.persistence.entity.university.City;
import org.yan.persistence.entity.university.University;

import java.util.List;
import java.util.Map;

public class UniversityVO {
    Map<City, List<University>> map;

    /*
    * data [{
    *   city: {
    *
    *   },
    *   universities: [
    *
    *   ],
    *   selected: ,
    *
    * }]
    * */
}
