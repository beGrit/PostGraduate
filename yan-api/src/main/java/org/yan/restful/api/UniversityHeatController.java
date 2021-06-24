package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;
import org.yan.restful.service.UniversityHeatService;

@RestController
@RequestMapping(value = "/api/v2.3/university/heat")
public class UniversityHeatController {
    @Autowired
    UniversityHeatService service;

    @RequestMapping(value = "one", method = RequestMethod.GET)
    public CommonResult one(@Param("uid") Long uid) throws CrudException {
        int count = service.getTotalConcernedUserByUid(uid);
        return CommonResult.success(count);
    }
}
