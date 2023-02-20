package com.yautumn.dao.shop;

import com.yautumn.common.entity.ShopCargoAgentInfo;

public interface ShopCargoAgentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCargoAgentInfo record);

    int insertSelective(ShopCargoAgentInfo record);

    ShopCargoAgentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCargoAgentInfo record);

    int updateByPrimaryKey(ShopCargoAgentInfo record);
}