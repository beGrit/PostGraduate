package org.yan.portal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.portal.exception.QueryException;
import org.yan.portal.service.GradeQueryService;
import org.yan.portal.jo.GradeJO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/portal/grade/")
public class GradeController {

    @Autowired
    GradeQueryService service;

    @RequestMapping("/grades")
    public CommonResult<GradeJO> getGrades(@RequestParam("uid") Long universityId, @RequestParam("mid") Long majorId) throws QueryException {
        GradeJO data = service.queryAllGrades(universityId, majorId);
        return CommonResult.success(data);
    }

    @ExceptionHandler(value = {QueryException.class})
    public CommonResult handlerQueryException(QueryException e) {
        return CommonResult.failed(e.getMessage());
    }
}
