package com.yautumn.service.market.impl;


import com.yautumn.common.entity.market.MarketInfo;
import com.yautumn.common.utils.DateUtils;
import com.yautumn.common.utils.GenerateUtil;
import com.yautumn.common.utils.JedisUtils;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.dao.market.MarketInfoMapper;
import com.yautumn.param.request.market.MarketParam;
import com.yautumn.param.request.common.PageParam;
import com.yautumn.service.market.MarketInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarketInfoServiceImpl implements MarketInfoService {

    private final Logger logger = LoggerFactory.getLogger(MarketInfoServiceImpl.class);

    @Autowired
    private MarketInfoMapper marketInfoMapper;

    @Autowired
    private JedisUtils jedisUtils;

    @Value("${redisprefix}")
    private String keyPre;

    @Override
    public String insert(MarketParam marketParam) {
        MarketInfo marketInfo = new MarketInfo();
        BeanUtils.copyProperties(marketParam,marketInfo);
        Date createTime = new Date();
        marketInfo.setCreatetime(DateUtils.dateTimeToString(createTime));
        int i = marketInfoMapper.insert(marketInfo);
        if (i == 1){
            return "操作成功";
        }else {
            return "市场信息插入失败";
        }
    }

    @Override
    public String update(MarketParam marketParam) {
        if (this.isNull(marketParam.getId())){
            return "市场信息不存在";
        }
        MarketInfo marketInfo = this.findById(marketParam.getId());
        BeanUtils.copyProperties(marketParam, marketInfo);
        marketInfo.setUpdatetime(DateUtils.dateTimeToString(new Date()));
        int i = marketInfoMapper.updateByPrimaryKey(marketInfo);
        if (i == 1){
            return "操作成功";
        }else {
            return "市场信息删除失败";
        }
    }

    @Override
    public String delete(Integer marketId) {
        if (this.isNull(marketId)){
            return "市场信息不存在";
        }
        MarketInfo marketInfo = marketInfoMapper.selectByPrimaryKey(marketId);
        marketInfo.setStatus("0");
        marketInfo.setUpdatetime(DateUtils.dateTimeToString(new Date()));
        int i = marketInfoMapper.updateByPrimaryKey(marketInfo);
        if (i == 1) {
            return "操作成功";
        } else {
            return "市场信息删除失败";
        }
    }

    @Override
    public MarketInfo findById(Integer marketId) {
        MarketInfo marketInfo = marketInfoMapper.selectByPrimaryKey(marketId);
        return marketInfo;
    }

    @Override
    public PageBeanUtil findMarketAll(PageParam pageParam) {
        int currentPage = pageParam.getCurrentPage();
        int pageSize = pageParam.getPageSize();
        int totalPage = pageParam.getTotalPage();
        PageBeanUtil pageBeanUtil = new PageBeanUtil(currentPage,pageSize,totalPage);
        List<MarketInfo> marketInfos = marketInfoMapper.findAll(pageBeanUtil.getStart(),pageBeanUtil.getEnd());
        pageBeanUtil.setList(marketInfos);
        return pageBeanUtil;
    }

    @Override
    public int countMarket() {
        int num = marketInfoMapper.selectCount();
        return num;
    }

    private boolean isNull(Integer marketId){
        boolean flag = false;
        MarketInfo marketInfo = this.findById(marketId);
        if (null == marketInfo){
            flag = true;
        }
        return flag;
    }
}
