package org.yan.admin.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "CityController")
@RestController
@RequestMapping(value = "/api/v2.1/city")
public class CityController {
}
