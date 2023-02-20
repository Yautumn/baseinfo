package com.yautumn.control;

import com.yautumn.common.entity.ShopCommodityInformation;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.param.request.shop.ShopCommodityParam;
import com.yautumn.service.shop.ShopCommodityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commodity")
public class ShopCommodityController {

    @Autowired
    private ShopCommodityInfoService shopCommodityInfoService;

    @PostMapping("/save")
    public ResultUtil saveCommodity(@RequestBody ShopCommodityParam shopCommodityParam){
        String msg = shopCommodityInfoService.insert(shopCommodityParam);
        return ResultUtil.success(msg);
    }

    @DeleteMapping("/delete/id")
    public ResultUtil delCommodity(@RequestBody ShopCommodityParam shopCommodityParam){
        String msg = shopCommodityInfoService.delShopCommodityByID(shopCommodityParam);
        return ResultUtil.success(msg);
    }

    @PostMapping("/update")
    public ResultUtil updateCommodity(@RequestBody ShopCommodityParam shopCommodityParam){
        String msg = shopCommodityInfoService.updateCommdityByID(shopCommodityParam);
        return ResultUtil.success(msg);
    }

    @GetMapping("/find/id")
    public ResultUtil findShopById(@RequestBody ShopCommodityParam shopCommodityParam){
        ShopCommodityInformation shopCommodityInformation = shopCommodityInfoService.findShopCommodityByID(shopCommodityParam);
        if (null != shopCommodityInformation){
            return ResultUtil.success(shopCommodityInformation);
        }else {
            return ResultUtil.success("商户信息不存在");
        }
    }

    @GetMapping("/count")
    public ResultUtil countCommoditys(){
        int count = 0;
        count = shopCommodityInfoService.countCommoditys();
        return ResultUtil.success(count);
    }


    @GetMapping("/find/all")
    public ResultUtil findCommodityAll(@RequestBody ShopCommodityParam shopCommodityParam){
        PageBeanUtil pageBeanUtil = shopCommodityInfoService.findCommdityAll(shopCommodityParam);
        return ResultUtil.success(pageBeanUtil);
    }

    @PostMapping("/batch/insert")
    public ResultUtil batchInsert(@RequestBody List<ShopCommodityParam> shopCommodityParams){
        String msg = shopCommodityInfoService.batchInsert(shopCommodityParams);
        return ResultUtil.success(msg);
    }
}
