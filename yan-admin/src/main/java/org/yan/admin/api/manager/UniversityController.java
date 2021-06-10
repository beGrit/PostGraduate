package org.yan.admin.api.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yan.admin.dto.AddUniversityDTO;

import org.yan.admin.form.AddUniversityForm;
import org.yan.admin.service.manager.UniversityManager;
import org.yan.common.api.CommonResult;
import org.yan.common.domain.page.Page;
import org.yan.common.exception.basic.CrudException;
import org.yan.common.exception.basic.QueryException;
import org.yan.common.facotry.PageFactory;
import org.yan.persistence.entity.university.Location;
import org.yan.persistence.entity.university.University;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v2.1/university")
public class UniversityController {

    @Autowired
    private UniversityManager universityManager;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<Page> page(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) throws QueryException {
        List<University> universities = universityManager.queryByPage(pageIndex, pageSize);
        Long total = universityManager.getTotal();
        Page<University> page = new PageFactory<University>().getPage(pageIndex, pageSize, total, universities);
        return CommonResult.success(page);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list() {
        try {
            List<University> universities = universityManager.queryAll();
            return CommonResult.success(universities);
        } catch (QueryException e) {
            return CommonResult.failed(e.getMessage());
        }
    }

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
    public CommonResult addOne(@RequestBody AddUniversityForm data) throws CrudException {
        University university = data.toUniversity();
        universityManager.save(university, data.getCityId());
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/list/criteria", method = RequestMethod.GET)
    public CommonResult getByTwoId(@RequestParam(value = "id1") Long id1, @RequestParam(value = "id2") Long id2) throws QueryException {
        University university1 = universityManager.queryById(id1);
        University university2 = universityManager.queryById(id2);
        List<University> universities = Arrays.asList(university1, university2);
        return CommonResult.success(universities);
    }
}
