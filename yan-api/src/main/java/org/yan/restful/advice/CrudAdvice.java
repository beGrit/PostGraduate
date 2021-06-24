package org.yan.restful.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yan.common.api.CommonResult;
import org.yan.common.exception.basic.CrudException;

@ControllerAdvice(basePackages = "org.yan.restful.api")
@ResponseBody
public class CrudAdvice {
    @ExceptionHandler(value = {CrudException.class})
    public CommonResult handle(CrudException e) {
        return CommonResult.failed("Restful API Occur Error: " + e.getMessage());
    }
}
