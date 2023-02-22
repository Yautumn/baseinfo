package com.yautumn.dao.shop;

import com.yautumn.common.entity.shop.ShopCargoAgentInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopCargoAgentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCargoAgentInfo record);

    int insertSelective(ShopCargoAgentInfo record);

    ShopCargoAgentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCargoAgentInfo record);

    int updateByPrimaryKey(ShopCargoAgentInfo record);
}