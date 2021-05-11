package org.yan.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.service.UniversityService;
import org.yan.persistence.entity.university.University;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/admin/university")
public class ApiUniversityController {

    @Autowired
    UniversityService universityService;

    @RequestMapping(value = "/page")
    public Map<String, Object> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    Model model) {
        List<University> universities = universityService.queryByPage(pageIndex, pageSize);
        return Collections.singletonMap("universities", universities);
    }
}
