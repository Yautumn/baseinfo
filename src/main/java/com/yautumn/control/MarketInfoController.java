package com.yautumn.control;

import com.yautumn.common.entity.MarketInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.common.utils.ResultUtil;
import com.yautumn.param.request.MarketParam;
import com.yautumn.service.market.MarketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class MarketInfoController {

    @Autowired
    private MarketInfoService marketInfoService;

    @RequestMapping("/add")
    public ResultUtil insert(@RequestBody MarketParam marketParam){
        String msg = marketInfoService.insert(marketParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/del")
    public ResultUtil del(@RequestBody MarketParam marketParam){
        String msg = marketInfoService.delete(marketParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/update")
    public ResultUtil update(@RequestBody MarketParam marketParam){
        String msg = marketInfoService.update(marketParam);
        return ResultUtil.success(msg);
    }

    @RequestMapping("/find/id")
    public ResultUtil findById(@RequestBody MarketParam marketParam){
        MarketInfo marketInfo = marketInfoService.findById(marketParam);
        return ResultUtil.success(marketInfo);
    }

    @RequestMapping("/find/all")
    public PageBeanUtil findAll(@RequestBody MarketParam marketParam){
        PageBeanUtil<MarketInfo> marketInfos = marketInfoService.findMarketAll(marketParam);
        return marketInfos;
    }

}
