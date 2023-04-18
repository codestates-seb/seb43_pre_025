package com.unbreakableheart.stackoverflowclone.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MultiResponse<T> {
    private PageInfo pageInfo;
    private List<T> data;
}
