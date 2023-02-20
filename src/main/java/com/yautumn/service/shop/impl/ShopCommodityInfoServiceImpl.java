package com.yautumn.service.shop.impl;

import com.yautumn.common.entity.ShopCommodityInformation;
import com.yautumn.common.utils.GenerateUtil;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.dao.shop.ShopCommodityInformationMapper;
import com.yautumn.param.request.PageParam;
import com.yautumn.param.request.ShopCommodityParam;
import com.yautumn.service.shop.ShopCommodityInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCommodityInfoServiceImpl implements ShopCommodityInfoService {

    @Autowired
    private ShopCommodityInformationMapper shopCommodityInformationMapper;

    /**
     * 插入商品信息
     * @param shopCommodityParam
     * @return
     */
    @Override
    public String insert(ShopCommodityParam shopCommodityParam) {
        ShopCommodityInformation shopCommodityInformation = new ShopCommodityInformation();
        String id = GenerateUtil.getUUID();
        BeanUtils.copyProperties(shopCommodityParam,shopCommodityInformation);
        shopCommodityInformation.setId(id);
        int i = shopCommodityInformationMapper.insert(shopCommodityInformation);
        if (i == 1){
            return "操作成功";
        }else {
            return "商户信息插入失败";
        }
    }

    /**
     * 根据id删除商品信息
     * @param shopCommodityParam
     * @return
     */
    @Override
    public String delShopCommodityByID(ShopCommodityParam shopCommodityParam) {
        if(this.isNull(shopCommodityParam)){
            return "商品信息不存在";
        }
        int i = shopCommodityInformationMapper.deleteByPrimaryKey(shopCommodityParam.getId());
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
        if(this.isNull(shopCommodityParam)){
            return "商品信息不存在";
        }
        ShopCommodityInformation shopCommodityInformation = new ShopCommodityInformation();
        BeanUtils.copyProperties(shopCommodityParam,shopCommodityInformation);
        int i = shopCommodityInformationMapper.updateByPrimaryKey(shopCommodityInformation);
        if (i == 1){
            return "操作成功";
        }else {
            return "商品信息更新失败";
        }
    }

    /**
     * 分页查询商品信息
     * @param shopCommodityParam
     * @return
     */
    @Override
    public PageBeanUtil findCommdityAll(ShopCommodityParam shopCommodityParam) {
        PageParam pageParam = shopCommodityParam.getPageParam();
        int currentPage = pageParam.getCurrentPage();
        int pageSize = pageParam.getPageSize();
        int totalPage = pageParam.getTotalPage();
        PageBeanUtil pageBeanUtil = new PageBeanUtil(currentPage,pageSize,totalPage);
        List<ShopCommodityInformation> shopCommodityInformations = shopCommodityInformationMapper.findCommodityAll(pageBeanUtil.getStartIndex(),pageSize);
        pageBeanUtil.setList(shopCommodityInformations);
        return pageBeanUtil;
    }


    /**
     * 根据id查询商品信息
     * @param shopCommodityParam
     * @return
     */
    @Override
    public ShopCommodityInformation findShopCommodityByID(ShopCommodityParam shopCommodityParam) {
        ShopCommodityInformation shopCommodityInformation = shopCommodityInformationMapper.selectByPrimaryKey(shopCommodityParam.getId());
        return shopCommodityInformation;
    }

    @Override
    public int countCommoditys() {
        int num = shopCommodityInformationMapper.selectCount();
        return num;
    }


    private boolean isNull(ShopCommodityParam shopCommodityParam){
        boolean flag = false;
        ShopCommodityInformation shopCommodityInformation = this.findShopCommodityByID(shopCommodityParam);
        if (null != shopCommodityInformation){
            flag = true;
        }
        return flag;
    }

}
