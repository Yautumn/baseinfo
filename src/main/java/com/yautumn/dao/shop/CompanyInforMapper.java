package com.yautumn.dao.shop;

import com.yautumn.common.entity.CompanyInfo;

public interface CompanyInforMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}