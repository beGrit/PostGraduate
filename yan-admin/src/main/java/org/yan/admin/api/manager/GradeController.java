package org.yan.admin.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.service.manager.GradeManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.Page;
import org.yan.common.domain.page.PageParam;
import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.major.Grade;
import org.yan.persistence.entity.university.Location;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.1/grade")
public class GradeController {

    @Autowired
    GradeManager manager;

    @RequestMapping(value = "/one")
    public CommonResult addOne(@RequestBody Location location) throws CrudException {
        manager.add(location);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult queryByPage(PageParam pageParam) throws QueryException {
        List<Grade> data = manager.queryByPage(pageParam.getPageIndex(), pageParam.getPageSize());
        Long count = manager.getTotal();
        Page<Grade> page = new PageFactory<Grade>().getPage(pageParam.getPageIndex(), pageParam.getPageSize(), count, data);
        return CommonResult.success(page);
    }
}
