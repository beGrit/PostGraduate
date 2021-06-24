package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;
import org.yan.persistence.entity.university.University;
import org.yan.restful.service.UserInfoService;

import javax.servlet.http.HttpSession;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v2.3/user/university")
public class UserUniversityController {
    @Autowired
    UserInfoService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<Set<University>> list(HttpSession session) {
        Long userId = getCurUserId(session);
        Set<University> data = service.getConcernedUniversities(userId);
        return CommonResult.success(data);
    }

    @RequestMapping(value = "/one", method = RequestMethod.PUT)
    public CommonResult change(@RequestParam(value = "oldUid") Long oldUid, @RequestParam(value = "newUid") Long newUid, HttpSession session) throws CrudException {
        Long userId = getCurUserId(session);
        service.changeConcernedUniversity(userId, newUid, oldUid);
        return CommonResult.success(null);
    }


    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public CommonResult add(@RequestParam(value = "uid") Long uid, HttpSession session) throws CrudException {
        Long userId = getCurUserId(session);
        service.addConcernedUniversity(userId, uid);
        return CommonResult.success(null);
    }

    public Long getCurUserId(HttpSession session) {
        Long userId = 1L;
        session.setAttribute("userId", userId);
        return userId;
    }
}
