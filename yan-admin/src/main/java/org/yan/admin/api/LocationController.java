package org.yan.admin.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yan.admin.service.LocationManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.Page;
import org.yan.common.domain.page.PageParam;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.exception.basic.UpdateException;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.university.Location;

import java.util.List;

@Api(tags = "LocationController")
@RestController
@RequestMapping(value = "/api/v2.1/location")
public class LocationController {

    @Autowired
    LocationManager locationManager;

    @ApiOperation("添加一个Location")
    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public CommonResult addOne(@RequestBody Location location) throws UpdateException {
        location = locationManager.save(location);
        return CommonResult.success(location.getId(), "添加位置成功");
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult queryByPage(PageParam pageParam) throws QueryException {
        List<Location> locations = locationManager.queryByPage(pageParam);
        Long count = locationManager.getTotal();
        Page<Location> page = new PageFactory<Location>().getPage(pageParam.getPageIndex(), pageParam.getPageSize(), count, locations);
        return CommonResult.success(page);
    }
}
