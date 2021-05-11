package org.yan.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yan.admin.service.UniversityService;
import org.yan.persistence.entity.university.University;

import java.util.List;

@Controller
@RequestMapping(value = {"/admin/university"})
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @RequestMapping("/page")
    public String page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       Model model) {
        List<University> universities = universityService.queryByPage(pageIndex, pageSize);
        model.addAttribute("universities", universities);
        return "university/index";
    }
}
