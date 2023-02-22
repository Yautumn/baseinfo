package com.yautumn.control;

import com.yautumn.common.entity.market.MarketInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.param.request.common.PageParam;
import com.yautumn.param.request.market.MarketParam;
import com.yautumn.service.market.MarketInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "市场信息接口")
@RestController
@RequestMapping("/market")
public class MarketInfoController {

    @Autowired
    private MarketInfoService marketInfoService;

    @ApiOperation(value = "新增市场方法")
    @PostMapping("/add")
    public ResultUtil insert(@RequestBody MarketParam marketParam){
        String msg = marketInfoService.insert(marketParam);
        return ResultUtil.success(msg);
    }

    @ApiOperation(value = "根据市场id删除市场方法")
    @DeleteMapping("/del/id")
    public ResultUtil del(@RequestParam @ApiParam(value = "市场id" , defaultValue = "a54754b885054bc3ba8fed163abc6c04") String marketId){
        String msg = marketInfoService.delete(marketId);
        return ResultUtil.success(msg);
    }

    @ApiOperation(value = "更新市场方法")
    @PostMapping("/update")
    public ResultUtil update(@RequestBody MarketParam marketParam){
        String msg = marketInfoService.update(marketParam);
        return ResultUtil.success(msg);
    }

    @ApiOperation(value = "根据id查询市场方法")
    @GetMapping("/find/id")
    public ResultUtil findById(@RequestParam @ApiParam(value = "市场id" , defaultValue = "a54754b885054bc3ba8fed163abc6c04") String marketId){
        MarketInfo marketInfo = marketInfoService.findById(marketId);
        return ResultUtil.success(marketInfo);
    }

    @ApiOperation(value = "查询所有市场方法")
    @PostMapping("/find/all")
    public PageBeanUtil findAll(@RequestBody PageParam pageParam){
        PageBeanUtil<MarketInfo> marketInfos = marketInfoService.findMarketAll(pageParam);
        return marketInfos;
    }

    @ApiOperation(value = "查询所有市场数量方法")
    @GetMapping("/count")
    public int findAllCount(){
        int count = marketInfoService.countMarket();
        return count;
    }

}
