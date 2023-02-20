package com.yautumn.param.request.market;

import com.yautumn.param.request.common.PageParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketParam {
    private String id;

    private String marketName;

    private String marketProvince;

    private String marketCity;

    private String marketAddr;

    private String remark;

    private PageParam pageParam;
}