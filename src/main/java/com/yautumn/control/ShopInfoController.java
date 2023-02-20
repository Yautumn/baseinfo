package com.yautumn.control;

import com.yautumn.common.entity.ShopInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.param.request.ShopParam;
import com.yautumn.service.shop.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopInfoController {

    @Autowired
    private ShopInfoService shopInfoService;

    @RequestMapping("/save")
    public ResultUtil saveShopInfo(@RequestBody ShopParam shopParam){
        String message = shopInfoService.insert(shopParam);
        return ResultUtil.success(message);
    }

    @DeleteMapping("/del/id")
    public ResultUtil delShopInfo(@RequestBody ShopParam shopParam){
        String msg = shopInfoService.delShopByID(shopParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/update")
    public ResultUtil updateShop(@RequestBody ShopParam shopParam){

        String msg = shopInfoService.updateShop(shopParam);
        return ResultUtil.success(msg);
    }
    @RequestMapping("/find/id")
    public ResultUtil findShopById(@RequestBody ShopParam shopParam){
        ShopInfo shopInfo = shopInfoService.findShopById(shopParam);
        if (null != shopInfo){
            return ResultUtil.success(shopInfo);
        }else {
            return ResultUtil.success("商户信息不存在");
        }
    }

    @RequestMapping("/count")
    public ResultUtil countShops(){
        int count = 0;
        count = shopInfoService.countShop();
        return ResultUtil.success(count);
    }

    @RequestMapping("/find/all")
    public ResultUtil findShopAll(@RequestBody ShopParam shopParam){
        PageBeanUtil pageBeanUtil = shopInfoService.findShopAll(shopParam);
        return ResultUtil.success(pageBeanUtil);
    }


}
