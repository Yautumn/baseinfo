package com.yautumn.service.impl;


import com.yautumn.common.entity.MarketInfo;
import com.yautumn.common.utils.DateUtils;
import com.yautumn.common.utils.GenerateUtil;
import com.yautumn.common.utils.JedisUtils;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.dao.market.MarketInfoMapper;
import com.yautumn.param.request.MarketParam;
import com.yautumn.param.request.PageParam;
import com.yautumn.service.MarketInfoService;
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
        String id = GenerateUtil.getUUID();
        marketInfo.setId(id);
        Date createTime = new Date();
        marketInfo.setCreatetime(DateUtils.dateTimeToString(createTime));
        marketInfo.setUpdatetime(DateUtils.dateTimeToString(createTime));
        int i = marketInfoMapper.insert(marketInfo);
        if (i == 1){
            return "操作成功";
        }else {
            return "市场信息插入失败";
        }
    }

    @Override
    public String update(MarketParam marketParam) {
        if (this.isNull(marketParam)){
            return "市场信息不存在";
        }
        MarketInfo marketInfo = this.findById(marketParam);
        BeanUtils.copyProperties(marketParam, marketInfo);
        int i = marketInfoMapper.updateByPrimaryKey(marketInfo);
        if (i == 1){
            return "操作成功";
        }else {
            return "市场信息删除失败";
        }
    }

    @Override
    public String delete(MarketParam marketParam) {
        if (this.isNull(marketParam)){
            return "市场信息不存在";
        }
        int i = marketInfoMapper.deleteByPrimaryKey(marketParam.getId());
        if (i == 1) {
            return "操作成功";
        } else {
            return "市场信息删除失败";
        }
    }

    @Override
    public MarketInfo findById(MarketParam marketParam) {
        MarketInfo marketInfo = marketInfoMapper.selectByPrimaryKey(marketParam.getId());
        return marketInfo;
    }

    @Override
    public PageBeanUtil findMarketAll(MarketParam marketParam) {
        PageParam pageParam = marketParam.getPageParam();
        int currentPage = pageParam.getCurrentPage();
        int pageSize = pageParam.getPageSize();
        int totalPage = pageParam.getTotalPage();
        PageBeanUtil pageBeanUtil = new PageBeanUtil(currentPage,pageSize,totalPage);
        List<MarketInfo> marketInfos = marketInfoMapper.findAll(pageBeanUtil.getStartIndex(),pageSize);
        pageBeanUtil.setList(marketInfos);
        return pageBeanUtil;
    }

    @Override
    public int countMarket(MarketParam marketParam) {
        int num = marketInfoMapper.selectCount(marketParam);
        return num;
    }

    private boolean isNull(MarketParam marketParam){
        boolean flag = false;
        MarketInfo marketInfo = this.findById(marketParam);
        if (null == marketInfo){
            flag = true;
        }
        return flag;
    }
}
