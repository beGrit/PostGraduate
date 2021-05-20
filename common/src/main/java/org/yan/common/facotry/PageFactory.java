package org.yan.common.facotry;

import org.yan.common.builders.PageBuilder;
import org.yan.common.domain.Page;

import java.util.List;

public class PageFactory<T> {
    public Page<T> getPage(Integer pageIndex, Integer pageSize, Long totalRecords, List<T> data) {
        PageBuilder<T> pageBuilder = new PageBuilder<>();
        Page<T> page = pageBuilder.getResult(pageIndex, pageSize, totalRecords, data);
        return page;
    }
}

