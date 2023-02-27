package com.yautumn.service.shop.impl;

import com.yautumn.common.entity.shop.ShopCommodityInformation;
import com.yautumn.common.utils.BatchUtils;
import com.yautumn.common.utils.DateUtils;
import com.yautumn.common.utils.GenerateUtil;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.dao.shop.ShopCommodityInformationMapper;
import com.yautumn.param.request.common.PageParam;
import com.yautumn.param.request.shop.ShopCommodityParam;
import com.yautumn.service.shop.ShopCommodityInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShopCommodityInfoServiceImpl implements ShopCommodityInfoService {

    @Autowired
    private ShopCommodityInformationMapper shopCommodityInformationMapper;

    @Autowired
    private BatchUtils batchUtils;

    /**
     * 插入商品信息
     * @param shopCommodityParam
     * @return
     */
    @Override
    public String insert(ShopCommodityParam shopCommodityParam) {
        ShopCommodityInformation shopCommodityInformation = new ShopCommodityInformation();
        BeanUtils.copyProperties(shopCommodityParam,shopCommodityInformation);
        shopCommodityInformation.setCreatetime(DateUtils.dateTimeToString(new Date()));
        int i = shopCommodityInformationMapper.insert(shopCommodityInformation);
        if (i == 1){
            return "操作成功";
        }else {
            return "商户信息插入失败";
        }
    }

    /**
     * 根据id删除商品信息
     * @param shopCommodityId
     * @return
     */
    @Override
    public String delShopCommodityByID(int shopCommodityId) {
        if (isNull(shopCommodityId)) {
            return "商品信息不存在";
        }
        int i = shopCommodityInformationMapper.deleteByPrimaryKey(shopCommodityId);
        if (i == 1) {
            return "操作成功";
        } else {
            return "商品信息删除失败";
        }
    }

    /**
     * 更新商品信息
     * @param shopCommodityParam
     * @return
     */
    @Override
    public String updateCommdityByID(ShopCommodityParam shopCommodityParam) {
        if(this.isNull(shopCommodityParam.getId())){
            return "商品信息不存在";
        }
        ShopCommodityInformation shopCommodityInformation = this.findShopCommodityByID(shopCommodityParam.getId());
        BeanUtils.copyProperties(shopCommodityParam,shopCommodityInformation);
        shopCommodityInformation.setUpdatetime(DateUtils.dateTimeToString(new Date()));
        int i = shopCommodityInformationMapper.updateByPrimaryKey(shopCommodityInformation);
        if (i == 1){
            return "操作成功";
        }else {
            return "商品信息更新失败";
        }
    }

    /**
     * 分页查询商品信息
     * @param pageParam
     * @return
     */
    @Override
    public PageBeanUtil findCommdityAll(PageParam pageParam) {
        int currentPage = pageParam.getCurrentPage();
        int pageSize = pageParam.getPageSize();
        int totalPage = pageParam.getTotalPage();
        PageBeanUtil pageBeanUtil = new PageBeanUtil(currentPage,pageSize,totalPage);
        List<ShopCommodityInformation> shopCommodityInformations = shopCommodityInformationMapper.findCommodityAll(pageBeanUtil.getStart(),pageBeanUtil.getEnd());
        pageBeanUtil.setList(shopCommodityInformations);
        return pageBeanUtil;
    }


    /**
     * 根据id查询商品信息
     * @param shopCommodityId
     * @return
     */
    @Override
    public ShopCommodityInformation findShopCommodityByID(int shopCommodityId) {
        ShopCommodityInformation shopCommodityInformation = shopCommodityInformationMapper.selectByPrimaryKey(shopCommodityId);
        return shopCommodityInformation;
    }

    @Override
    public int countCommoditys() {
        int num = shopCommodityInformationMapper.selectCount();
        return num;
    }

    @Override
    @Transactional
    public String batchInsert(List<ShopCommodityParam> shopCommodityParams) {
        List<ShopCommodityInformation> shopCommodityInformations = new ArrayList<ShopCommodityInformation>();
        shopCommodityParams.forEach(shopCommodityParam -> {
            ShopCommodityInformation shopCommodityInformation = new ShopCommodityInformation();
            BeanUtils.copyProperties(shopCommodityParam,shopCommodityInformation);
            shopCommodityInformation.setCreatetime(DateUtils.dateTimeToString(new Date()));
            shopCommodityInformations.add(shopCommodityInformation);
        });
        int i = batchUtils.batchUpdateOrInsert(shopCommodityInformations,ShopCommodityInformationMapper.class,(item,hopCommodityInformationMapper)->shopCommodityInformationMapper.insert(item));
        if (i == 1){
            return "操作成功";
        }else {
            return "商户信息插入失败";
        }
    }


    private boolean isNull(int shopCommodityId){
        boolean flag = false;
        ShopCommodityInformation shopCommodityInformation = this.findShopCommodityByID(shopCommodityId);
        if (null != shopCommodityInformation){
            flag = true;
        }
        return flag;
    }

}
