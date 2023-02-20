package com.yautumn.param.request.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageParam {

    private int currentPage;
    private int pageSize;
    private int totalPage;

}
