package com.yautumn.dao.shop;

import com.yautumn.common.entity.ShopCargoGoodsInfo;

public interface ShopCargoGoodsInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCargoGoodsInfo record);

    int insertSelective(ShopCargoGoodsInfo record);

    ShopCargoGoodsInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCargoGoodsInfo record);

    int updateByPrimaryKey(ShopCargoGoodsInfo record);
}