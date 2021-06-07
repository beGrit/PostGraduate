package org.yan.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.form.LoginForm;
import org.yan.security.service.UserAuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/v2.1/authentication")
public class UserAuthenticationController {

    @Autowired
    UserAuthenticationService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult login(@RequestBody LoginForm form,
                              HttpServletRequest req, HttpServletResponse resp) {
        boolean rtn = service.authentication(form.getUsername(), form.getPassword());
        if (rtn) {
            // 修改session状态
            req.getSession().setAttribute("userId", 1L);
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("登录信息有误");
        }
    }
}
