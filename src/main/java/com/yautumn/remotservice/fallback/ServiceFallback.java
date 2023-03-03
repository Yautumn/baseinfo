package com.yautumn.remotservice.fallback;

import com.yautumn.common.utils.ResultUtil;
import com.yautumn.remotservice.IMarketInfoService;
import org.springframework.stereotype.Component;

@Component
public class ServiceFallback implements IMarketInfoService {
    @Override
    public ResultUtil findById(Integer marketId) {
        return ResultUtil.error("服务调用失败");
    }
}
