package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.persistence.entity.user.UserDetailInfo;
import org.yan.restful.service.UserInfoService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/v2.2/userinfo")
public class UserInfoIndexController {

    @Autowired
    UserInfoService service;

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public CommonResult getData(HttpSession session) {
        Long userId = Long.parseLong(String.valueOf(session.getAttribute("userId")));
        UserDetailInfo detailInfo = service.getDetail(userId);
        return CommonResult.success(detailInfo);
    }
}
