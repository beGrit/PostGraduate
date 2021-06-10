package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.persistence.entity.major.Grade;
import org.yan.restful.service.GradeService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.3/grade")
public class GradeController {

    @Autowired
    GradeService service;

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public CommonResult<List<Grade>> queryOne(@Param(value = "uid") Long uid, @Param(value = "mid") Long mid) {
        List<Grade> grades = service.queryGrade(uid, mid);
        return CommonResult.success(grades);
    }
}
