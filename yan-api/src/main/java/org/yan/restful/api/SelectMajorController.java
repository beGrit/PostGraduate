package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.restful.service.SelectMajorService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.2/major/selectView")
public class SelectMajorController {
    @Autowired
    SelectMajorService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResult selectViewData() throws CrudException {
        List<MasterMajor> data = service.getSelectList();
        return CommonResult.success(data);
    }
}
