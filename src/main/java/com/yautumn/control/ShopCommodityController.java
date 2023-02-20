package com.yautumn.control;

import com.yautumn.common.entity.ShopCommodityInformation;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.param.request.ShopCommodityParam;
import com.yautumn.service.ShopCommodityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("commodity")
public class ShopCommodityController {
    @Autowired
    private ShopCommodityInfoService shopCommodityInfoService;

    @RequestMapping("/save")
    public ResultUtil saveCommodity(@RequestBody ShopCommodityParam shopCommodityParam){
        String msg = shopCommodityInfoService.insert(shopCommodityParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/delete/id")
    public ResultUtil delCommodity(@RequestBody ShopCommodityParam shopCommodityParam){
        String msg = shopCommodityInfoService.delShopCommodityByID(shopCommodityParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/update")
    public ResultUtil updateCommodity(@RequestBody ShopCommodityParam shopCommodityParam){
        String msg = shopCommodityInfoService.updateCommdityByID(shopCommodityParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/find/id")
    public ResultUtil findShopById(@RequestBody ShopCommodityParam shopCommodityParam){
        ShopCommodityInformation shopCommodityInformation = shopCommodityInfoService.findShopCommodityByID(shopCommodityParam);
        if (null != shopCommodityInformation){
            return ResultUtil.success(shopCommodityInformation);
        }else {
            return ResultUtil.success("商户信息不存在");
        }
    }

    @RequestMapping("/count")
    public ResultUtil countCommoditys(){
        int count = 0;
        count = shopCommodityInfoService.countCommoditys();
        return ResultUtil.success(count);
    }


    @RequestMapping("/find/all")
    public ResultUtil findCommodityAll(@RequestBody ShopCommodityParam shopCommodityParam){
        PageBeanUtil pageBeanUtil = shopCommodityInfoService.findCommdityAll(shopCommodityParam);
        return ResultUtil.success(pageBeanUtil);
    }
}
