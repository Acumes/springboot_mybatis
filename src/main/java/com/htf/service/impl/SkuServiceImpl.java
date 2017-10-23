package com.htf.service.impl;

import com.htf.entity.Sku;
import com.htf.entity.SkuBom;
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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
        checkSku4Create(request,false);
        request.setCreatorId(ShiroUtils.getUserId());
        Date now = new Date();
        skuMapper.insert(request);
        if(NullUtil.hasItem(request.getBoms())){
            insertSkuBom(request.getBoms(),request.getSkuCode());
        }
    }

    @Override
    public Sku findByCode(String skuCode) {
        Sku result = skuMapper.selectByPrimaryKey(skuCode);
        List<SkuBom> skuBoms = skuBomMapper.selectByPrimaryKey(skuCode);
        result.setBoms(skuBoms);
        return result;
    }

    @Override
    public void delSku(String code) {
        skuMapper.deleteByPrimaryKey(code);
    }

    @Override
    public void updateSku(Sku request) {
        checkSku4Create(request,true);
        updateSkuBom(request);
        skuMapper.updateByPrimaryKey(request);
    }


    @Transactional
    public void updateSkuBom(Sku request) {

        String modify = request.getModifierId();
        Date now = new Date();
        skuBomMapper.delBomBySkuCode(request.getSkuCode());
        insertSkuBom(request.getBoms(),request.getSkuCode());

    }

    private void insertSkuBom(List<SkuBom> skuBoms,String skuCode){
        int curVersion = vcService.increaseAndGetMasterVersion(Version.Type.sku);
        if (NullUtil.hasItem(skuBoms)) {
            skuBomMapper.batchInsert(skuBoms, skuCode, curVersion, new Date(), ShiroUtils.getUserId());
        }
    }

    private void checkSku4Create(Sku sku,boolean update) {
        if (!update && null != skuMapper.selectByName(sku.getName())) {
            throw new ExceptionResponse("物料名称已存在");
        }
    }
}
