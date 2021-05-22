package org.yan.common.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    @ApiModelProperty(value = "分页详情")
    private PageContentInfo<T> pageContentInfo;

    @ApiModelProperty(value = "分页条")
    private PageBar pageBar;
}