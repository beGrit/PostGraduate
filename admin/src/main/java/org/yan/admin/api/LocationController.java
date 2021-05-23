package org.yan.admin.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.exception.basic.UpdateException;
import org.yan.admin.service.LocationService;
import org.yan.common.api.CommonResult;
import org.yan.persistence.entity.university.Location;

@Api(tags = "LocationController")
@RestController
@RequestMapping(value = "/api/v2.1/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @ApiOperation("添加一个Location")
    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public CommonResult addOne(@RequestBody Location location) throws UpdateException {
        location = locationService.save(location);
        return CommonResult.success(location.getId(), "添加位置成功");
    }
}
