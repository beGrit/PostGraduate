package org.yan.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Map getGrades(@RequestParam("uid") Long universityId, @RequestParam("mid") Long majorId) throws QueryException {
        GradeJO data = service.queryAllGrades(universityId, majorId);
        HashMap<String, Object> rtn = new HashMap<>();
        rtn.put("code", 200);
        rtn.put("msg", "成功获取");
        rtn.put("data", data);
        return rtn;
    }

    @ExceptionHandler(value = {QueryException.class})
    public Map handlerQueryException(QueryException e) {
        HashMap<String, Object> rtn = new HashMap<>();
        rtn.put("code", 404);
        rtn.put("message", e.getMessage());
        return rtn;
    }
}
