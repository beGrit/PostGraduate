package org.yan.admin.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yan.admin.exception.basic.CrudException;
import org.yan.common.api.CommonResult;

@ControllerAdvice(basePackages = "org.yan.admin.api")
@ResponseBody
public class CrudAdvice {
    @ExceptionHandler(value = {CrudException.class})
    public CommonResult handle(CrudException e) {
        return CommonResult.failed(e.getMessage());
    }
}
