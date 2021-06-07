package org.yan.admin.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yan.admin.service.UniversityManager;

@Controller
@RequestMapping(value = {"/admin/university"})
public class UniversityRouter {

    @Autowired
    UniversityManager universityManager;

    @RequestMapping("/page")
    public String page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       Model model) {
        return "university/index";
    }
}
