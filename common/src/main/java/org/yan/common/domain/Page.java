package org.yan.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private PageContentInfo<T> pageContentInfo;
    private PageBar pageBar;
}