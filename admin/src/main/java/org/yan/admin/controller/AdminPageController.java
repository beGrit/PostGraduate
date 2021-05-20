package org.yan.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.domain.AdminIndexPageMeta;
import org.yan.common.api.CommonResult;

@RestController
@RequestMapping("/api/admin/page/meta")
public class AdminPageController {
    @RequestMapping
    public CommonResult<AdminIndexPageMeta> meta() {
        AdminIndexPageMeta adminIndexPageMeta = new AdminIndexPageMeta("后台管理子系统", "v2.1");
        return CommonResult.success(adminIndexPageMeta);
    }
}
