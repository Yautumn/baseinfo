package com.yautumn.dao.shop;

import com.yautumn.common.entity.shop.ShopCargoGoodsInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopCargoGoodsInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCargoGoodsInfo record);

    int insertSelective(ShopCargoGoodsInfo record);

    ShopCargoGoodsInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCargoGoodsInfo record);

    int updateByPrimaryKey(ShopCargoGoodsInfo record);
}