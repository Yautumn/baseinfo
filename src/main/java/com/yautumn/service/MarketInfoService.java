package com.yautumn.service;

import com.yautumn.common.entity.MarketInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.param.request.MarketParam;
import org.springframework.stereotype.Service;

@Service
public interface MarketInfoService {

    /**
     * 新增市场信息
     * @param marketParam
     * @return
     */
    String insert(MarketParam marketParam);

    /**
     * 更新市场信息
     * @param marketParam
     * @return
     */
    String update(MarketParam marketParam);

    /**
     * 根据条件删除市场信息
     * @param marketParam
     * @return
     */
    String delete(MarketParam marketParam);

    /**
     * 根据id查询市场信息
     * @param marketParam
     * @return
     */
    MarketInfo findById(MarketParam marketParam);

    /**
     * 分页查询市场信息列表
     * @param marketParam
     * @return
     */
    PageBeanUtil findMarketAll(MarketParam marketParam);

    /**
     * 统计市场信息总数
     * @return
     */
    int countMarket(MarketParam marketParam);
}
