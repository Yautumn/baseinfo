package com.yautumn.service.shop.impl;

import com.yautumn.common.entity.ShopInfo;
import com.yautumn.common.utils.GenerateUtil;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.dao.shop.ShopInfoMapper;
import com.yautumn.param.request.PageParam;
import com.yautumn.param.request.ShopParam;
import com.yautumn.service.shop.ShopInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopInfoServiceImpl implements ShopInfoService {

    private final Logger logger = LoggerFactory.getLogger(ShopInfoServiceImpl.class);

    @Autowired
    private ShopInfoMapper shopInfoMapper;

    /**
     * 新增商户信息
     * @param shopParam
     * @return
     */
    @Override
    public String insert(ShopParam shopParam) {
        ShopInfo shopInfo = new ShopInfo();
        String id = GenerateUtil.getUUID();
        BeanUtils.copyProperties(shopParam,shopInfo);
        shopInfo.setId(id);
        int i = shopInfoMapper.insert(shopInfo);
        if (i == 1){
            return "操作成功";
        }else {
            return "商户信息插入失败";
        }
    }

    /**
     * 根据id删除商户信息
     * @param shopParam
     * @return
     */
    @Override
    public String delShopByID(ShopParam shopParam) {
        if (this.isNull(shopParam)) {
            return "商户信息不存在";
        }
        int i = shopInfoMapper.deleteByPrimaryKey(shopParam.getId());
        if (i == 1) {
            return "操作成功";
        } else {
            return "商户信息删除失败";
        }
    }

    /**
     * 更新商户信息
     * @param shopParam
     * @return
     */
    @Override
    public String updateShop(ShopParam shopParam) {
        if (this.isNull(shopParam)){
            return "商户信息不存在";
        }
        ShopInfo shopInfoNew = new ShopInfo();
        BeanUtils.copyProperties(shopParam,shopInfoNew);
        int i = shopInfoMapper.updateByPrimaryKey(shopInfoNew);
        if (i == 1){
            return "操作成功";
        }else {
            return "商户信息更新失败";
        }
    }

    /**
     * 根据id查询商户信息
     * @param shopParam
     * @return
     */
    @Override
    public ShopInfo findShopById(ShopParam shopParam) {
        ShopInfo shopInfo = shopInfoMapper.selectByPrimaryKey(shopParam.getId());
        return shopInfo;
    }

    /**
     * 分页查询数据
     * @param shopParam
     * @return
     */
    @Override
    public PageBeanUtil findShopAll(ShopParam shopParam) {
        PageParam pageParam = shopParam.getPageParam();
        int currentPage = pageParam.getCurrentPage();
        int pageSize = pageParam.getPageSize();
        int totalPage = pageParam.getTotalPage();
        PageBeanUtil pageBeanUtil = new PageBeanUtil(currentPage,pageSize,totalPage);
        List<ShopInfo> shopInfos = shopInfoMapper.findShopAll(pageBeanUtil.getStartIndex(),pageSize);
        pageBeanUtil.setList(shopInfos);
        return pageBeanUtil;
    }


    /**
     * 查询商户总数
     * @return
     */
    public int countShop(){
        int num = shopInfoMapper.selectCount();
        return num;
    }

    private boolean isNull(ShopParam shopParam){
        boolean flag = false;
        ShopInfo shopInfo = this.findShopById(shopParam);
        if (null == shopInfo){
            flag = true;
        }
        return flag;
    }

}
