package com.yautumn.control;

import com.yautumn.common.entity.ShopInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.param.request.shop.ShopParam;
import com.yautumn.service.shop.ShopInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商户信息接口")
@RestController
@RequestMapping("/shop")
public class ShopInfoController {

    @Autowired
    private ShopInfoService shopInfoService;

    @ApiOperation(value = "添加商户信息方法")
    @PostMapping("/save")
    public ResultUtil saveShopInfo(@RequestBody ShopParam shopParam) {
        String message = shopInfoService.insert(shopParam);
        return ResultUtil.success(message);
    }

    @DeleteMapping("/del/id")
    public ResultUtil delShopInfo(@RequestBody ShopParam shopParam) {
        String msg = shopInfoService.delShopByID(shopParam);
        return ResultUtil.success(msg);
    }

    @PostMapping("/update")
    public ResultUtil updateShop(@RequestBody ShopParam shopParam) {

        String msg = shopInfoService.updateShop(shopParam);
        return ResultUtil.success(msg);
    }

    @GetMapping("/find/id")
    public ResultUtil findShopById(@RequestBody ShopParam shopParam) {
        ShopInfo shopInfo = shopInfoService.findShopById(shopParam);
        if (null != shopInfo) {
            return ResultUtil.success(shopInfo);
        } else {
            return ResultUtil.success("商户信息不存在");
        }
    }

    @GetMapping("/count")
    public ResultUtil countShops() {
        int count = 0;
        count = shopInfoService.countShop();
        return ResultUtil.success(count);
    }

    @GetMapping("/find/all")
    public ResultUtil findShopAll(@RequestBody ShopParam shopParam) {
        PageBeanUtil pageBeanUtil = shopInfoService.findShopAll(shopParam);
        return ResultUtil.success(pageBeanUtil);
    }


}
