package org.yan.common.domain.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageContentInfo<T> {
    private Integer curPageIndex;
    private Integer pageSize;
    private List<T> data;
}
