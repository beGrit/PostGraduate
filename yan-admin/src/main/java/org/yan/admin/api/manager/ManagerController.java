package org.yan.admin.api.manager;

import org.springframework.web.bind.annotation.RequestBody;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.PageParam;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.exception.basic.UpdateException;
import org.yan.persistence.entity.university.Location;

public interface ManagerController {
    CommonResult addOne(@RequestBody Location location) throws UpdateException;

    CommonResult queryByPage(PageParam pageParam) throws QueryException;
}
