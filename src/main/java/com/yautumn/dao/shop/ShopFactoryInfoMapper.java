package com.yautumn.dao.shop;

import com.yautumn.common.entity.shop.ShopFactoryInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopFactoryInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopFactoryInfo record);

    int insertSelective(ShopFactoryInfo record);

    ShopFactoryInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopFactoryInfo record);

    int updateByPrimaryKey(ShopFactoryInfo record);
}