package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;
import org.yan.restful.service.SelectUniversityService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.2/university/selectView")
public class SelectUniversityController {

    @Autowired
    SelectUniversityService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResult selectViewData() throws CrudException {
        List<Object> data = service.getSelectList();
        return CommonResult.success(data);
    }
}
