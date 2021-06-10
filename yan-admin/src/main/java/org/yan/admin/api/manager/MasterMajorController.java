package org.yan.admin.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yan.admin.service.manager.MasterMajorManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.Page;
import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.major.MasterMajor;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.1/major")
public class MasterMajorController {
    @Autowired
    MasterMajorManager manager;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<Page> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) throws QueryException {
        List<MasterMajor> masterMajors = manager.queryByPage(pageIndex, pageSize);
        Long count = manager.getTotal();
        Page<MasterMajor> page = new PageFactory<MasterMajor>().getPage(pageIndex, pageSize, count, masterMajors);
        return CommonResult.success(page);
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST, consumes = "application/json")
    public CommonResult addOne(@RequestBody MasterMajor masterMajor) throws CrudException {
        manager.add(masterMajor);
        return CommonResult.success(null);
    }

}
