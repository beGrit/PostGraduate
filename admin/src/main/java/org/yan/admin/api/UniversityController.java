package org.yan.admin.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;
import org.yan.admin.dto.AddUniversityDTO;
import org.yan.admin.exception.basic.CrudException;
import org.yan.admin.exception.basic.QueryException;
import org.yan.admin.service.UniversityManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.Page;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.university.University;

import java.util.Arrays;
import java.util.List;

@Api(tags = "UniversityController")
@RestController
@RequestMapping(value = "/api/v2.1/university")
public class UniversityController {

    private final UniversityManager universityManager;

    @Autowired
    public UniversityController(UniversityManager universityManager) {
        this.universityManager = universityManager;
    }

    @ApiOperation("根据 页码+页容量 获取数据")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<Page> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) throws QueryException {
        List<University> universities = universityManager.queryByPage(pageIndex, pageSize);
        Long total = universityManager.getTotal();
        Page<University> page = new PageFactory<University>().getPage(pageIndex, pageSize, total, universities);
        return CommonResult.success(page);
    }

    @ApiOperation("获取院校列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list() {
        try {
            List<University> universities = universityManager.queryAll();
            return CommonResult.success(universities);
        } catch (QueryException e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation("根据 uid列表 删除指定的数据")
    @RequestMapping(value = "/list", method = RequestMethod.DELETE, consumes = "application/json")
    public CommonResult deleteByIdList(@RequestBody List<Long> idList) {
        try {
            universityManager.batchDelete(idList);
            return CommonResult.success(null, "删除成功");
        } catch (CrudException e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST, consumes = "application/json")
    public CommonResult addOne(@RequestBody AddUniversityDTO dto) {
        return null;
    }

    @RequestMapping(value = "/list/criteria", method = RequestMethod.GET)
    public CommonResult getByTwoId(@RequestParam(value = "id1") Long id1, @RequestParam(value = "id2") Long id2) throws QueryException {
        University university1 = universityManager.queryById(id1);
        University university2 = universityManager.queryById(id2);
        List<University> universities = Arrays.asList(university1, university2);
        return CommonResult.success(universities);
    }
}
