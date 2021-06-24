package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.QueryException;
import org.yan.persistence.entity.user.UserBasicInfo;
import org.yan.persistence.entity.user.UserDetailInfo;
import org.yan.restful.service.UserInfoService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/v2.2/userinfo")
public class UserInfoIndexController {

    public Long getCurUserId(HttpSession session) {
        Long userId = 1L;
        session.setAttribute("userId", userId);
        return userId;
    }

    @Autowired
    UserInfoService service;

    @RequestMapping(value = "basic", method = RequestMethod.GET)
    public CommonResult getBasic(HttpSession session) throws QueryException {
        Long userId = getCurUserId(session);
        UserBasicInfo basicInfo = service.getBasic(userId);
        return CommonResult.success(basicInfo);
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public CommonResult getData(HttpSession session) {
        Long userId = getCurUserId(session);
        UserDetailInfo detailInfo = service.getDetail(userId);
        return CommonResult.success(detailInfo);
    }
}
