package com.unbreakableheart.stackoverflowclone.common.response;

import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Getter
public class MultiResponse<T> {
    private PageInfo pageInfo;
    private List<T> data;

    public MultiResponse(Page page, List<T> data) {
        this.pageInfo = new PageInfo(page.getNumber() + 1, page.getSize(), page.getTotalElements(), page.getTotalPages());
        this.data = data;
    }
}
