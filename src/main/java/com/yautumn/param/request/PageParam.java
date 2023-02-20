package com.yautumn.param.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageParam {

    private int currentPage;
    private int pageSize;
    private int totalPage;

}
