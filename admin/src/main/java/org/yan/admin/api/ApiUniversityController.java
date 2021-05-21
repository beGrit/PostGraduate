package org.yan.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.service.UniversityManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.Page;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.university.University;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.1/university")
public class ApiUniversityController {

    private final UniversityManager universityManager;

    @Autowired
    public ApiUniversityController(UniversityManager universityManager) {
        this.universityManager = universityManager;
    }

    @RequestMapping(value = "/page")
    public CommonResult<Page> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) throws QueryException {
        List<University> universities = universityManager.queryByPage(pageIndex, pageSize);
        Long total = universityManager.getTotal();
        Page<University> page = new PageFactory<University>().getPage(pageIndex, pageSize, total, universities);
        return CommonResult.success(page);
    }
}
