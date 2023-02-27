package com.yautumn.dao.shop;

import com.yautumn.common.entity.shop.ShopCommodityInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCommodityInformationMapper {
    int deleteByPrimaryKey(int id);

    int insert(ShopCommodityInformation record);

    int insertSelective(ShopCommodityInformation record);

    ShopCommodityInformation selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(ShopCommodityInformation record);

    int updateByPrimaryKey(ShopCommodityInformation record);

    int selectCount();

    List<ShopCommodityInformation> findCommodityAll(Integer startIndex, int pageSize);

    int batchInsert(List<ShopCommodityInformation> commodityInformationList);
}