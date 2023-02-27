package com.yautumn.param.request.shop;

import com.yautumn.param.request.common.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopCommodityParam {

    @ApiModelProperty(example = "",value = "商品id")
    private int id;

    @ApiModelProperty(example = "",value = "商户id")
    private int shopId;

    @ApiModelProperty(example = "XXX",value = "商品品牌")
    private String productBrand;

    @ApiModelProperty(example = "电线",value = "商品名称")
    private String productName;

    @ApiModelProperty(example = "XXX",value = "商品型号")
    private String productType;

    @ApiModelProperty(example = "2.5㎡",value = "商品规格")
    private String productSpecific;

    @ApiModelProperty(example = "米",value = "商品单位")
    private String productUnit;

    @ApiModelProperty(example = "1",value = "状态 1生效 0无效")
    private String status;

    @ApiModelProperty(example = "",value = "备注")
    private String remark;

}