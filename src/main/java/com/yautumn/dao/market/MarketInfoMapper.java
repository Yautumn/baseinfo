package com.yautumn.dao.market;

import com.yautumn.common.entity.MarketInfo;
import com.yautumn.param.request.market.MarketParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(MarketInfo record);

    int insertSelective(MarketInfo record);

    MarketInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MarketInfo record);

    int updateByPrimaryKey(MarketInfo record);

    List<MarketInfo> findAll(int start, int end);

    int selectCount(MarketParam marketParam);
}