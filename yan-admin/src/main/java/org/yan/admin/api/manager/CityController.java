package org.yan.admin.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.service.manager.CityManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.Page;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.university.City;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.1/city")
public class CityController {

    @Autowired
    CityManager cityManager;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<Page> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) throws QueryException {
        List<City> cities = cityManager.queryByPage(pageIndex, pageSize);
        Long total = cityManager.getTotal();
        Page<City> page = new PageFactory<City>().getPage(pageIndex, pageSize, total, cities);
        return CommonResult.success(page);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<City>> list() throws QueryException {
        List<City> cities = cityManager.queryAll();
        return CommonResult.success(cities);
    }
}
