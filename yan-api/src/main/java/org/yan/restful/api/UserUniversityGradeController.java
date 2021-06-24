package org.yan.restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;
import org.yan.restful.service.UserInfoService;
import org.yan.restful.vo.UniversityGradesVO;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v2.3/user/UniversityGradesVO")
public class UserUniversityGradeController {
    @Autowired
    UserInfoService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResult list(HttpSession session) throws CrudException {
        Long userId = getCurUserId(session);
        List<UniversityGradesVO> data = service.getUniversityGradesVOList(userId);
        return CommonResult.success(data);
    }

    public Long getCurUserId(HttpSession session) {
        Long userId = 1L;
        session.setAttribute("userId", userId);
        return userId;
    }
}
