package com.htf.service.impl;

import com.htf.entity.Sku;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.SkuBomMapper;
import com.htf.mapper.SkuMapper;
import com.htf.service.SkuService;
import com.htf.util.NullUtil;
import com.htf.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@Service("skuService")
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;
    @Resource
    private SkuBomMapper skuBomMapper;

    @Override
    public void addSku(Sku request) {
        checkSku4Create(request);
        request.setCreatorId(ShiroUtils.getUserId());
        skuMapper.insert(request);
        if(NullUtil.hasItem(request.getBoms())){

        }
    }

    @Override
    public Sku findByCode(String skuCode) {
        return skuMapper.selectByPrimaryKey(skuCode);
    }

    @Override
    public void delSku(String code) {
        skuMapper.deleteByPrimaryKey(code);
    }

    @Override
    public void updateSku(Sku request) {
        checkSku4Create(request);
        skuMapper.updateByPrimaryKey(request);
    }

    private void checkSku4Create(Sku sku) {
        if (null != skuMapper.selectByName(sku.getName())) {
            throw new ExceptionResponse("物料名称已存在");
        }
//        if (NullUtil.hasItem(getBoms())) {
//            for (SkuBomPojo bom : getBoms()) {
//                BigDecimal wasteRate = bom.getWasteRate();
//                if (null != wasteRate && wasteRate.intValue() >= 1) {
//                    throw new ExceptionResponse("单位损耗率不能大于1");
//                }
//            }
//        }
    }
}
