package org.yan.common.api;

import org.yan.common.domain.Page;

public class PageResult<T> {
    private long code;
    /**
     * 提示信息
     */
    private String message;

    private Page<T> data;
}
