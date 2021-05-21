package org.yan.admin.api.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yan.admin.domain.AdminIndexPageMeta;
import org.yan.common.api.CommonResult;

@RestController
@RequestMapping("/api/v2.1/admin/page/meta")
public class AdminPageController {
    @RequestMapping
    public CommonResult<AdminIndexPageMeta> meta() {
        AdminIndexPageMeta adminIndexPageMeta = new AdminIndexPageMeta("后台管理子系统", "v2.1");
        return CommonResult.success(adminIndexPageMeta);
    }
}
