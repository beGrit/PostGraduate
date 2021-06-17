package org.yan.restful.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.major.MasterMajor;
import org.yan.restful.service.UserInfoService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/v2.3/user/major")
public class UserMajorController {
    @Autowired
    UserInfoService service;

    public Long getCurUserId(HttpSession session) {
        Long userId = 1L;
        session.setAttribute("userId", userId);
        return userId;
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public CommonResult one(HttpSession session) {
        Long userId = getCurUserId(session);
        MasterMajor data = service.getConcernedMasterMajor(userId);
        return CommonResult.success(data);
    }

    @RequestMapping(value = "/one", method = RequestMethod.PUT)
    public CommonResult change(@RequestParam(value = "mid") Long mid, HttpSession session) throws CrudException {
        Long userId = getCurUserId(session);
        service.changeConcernedMasterMajor(userId, mid);
        return CommonResult.success(null);
    }
}
