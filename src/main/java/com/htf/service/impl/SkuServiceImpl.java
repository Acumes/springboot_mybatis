package com.htf.service.impl;

import com.htf.entity.Sku;
import com.htf.entity.Version;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.SkuBomMapper;
import com.htf.mapper.SkuMapper;
import com.htf.service.SkuService;
import com.htf.service.VersionCenterService;
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
    @Autowired
    private SkuBomMapper skuBomMapper;

    @Autowired
    private VersionCenterService vcService;

    @Override
    public void addSku(Sku request) {
        checkSku4Create(request);
        request.setCreatorId(ShiroUtils.getUserId());
        Date now = new Date();
        skuMapper.insert(request);
        if(NullUtil.hasItem(request.getBoms())){
            int curVersion = vcService.increaseAndGetMasterVersion(Version.Type.sku);
            if (NullUtil.hasItem(request.getBoms())) {
//                try {
                    skuBomMapper.batchInsert(request.getBoms(), request.getSkuCode(), curVersion, now, request.getCreatorId());
//                } catch (Exception e) {
//                    throw new RuntimeException("服务器响应中, 请勿重复提交");
//                }
            }
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
