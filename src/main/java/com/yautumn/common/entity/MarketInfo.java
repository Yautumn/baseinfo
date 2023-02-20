package com.yautumn.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MarketInfo implements Serializable {
    private String id;

    private String marketName;

    private String marketProvince;

    private String marketCity;

    private String marketAddr;

    private String status;

    private String createtime;

    private String updatetime;

    private String remark;

}