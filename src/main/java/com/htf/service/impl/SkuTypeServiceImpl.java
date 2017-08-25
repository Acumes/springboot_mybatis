package com.htf.service.impl;

import com.htf.controller.request.SkuTypeRequest;
import com.htf.entity.SkuType;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.SkuTypeMapper;
import com.htf.service.SkuTypeService;
import com.htf.util.ShiroUtils;
import com.htf.util.UUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@Service("skuTypeService")
public class SkuTypeServiceImpl implements SkuTypeService {
    @Resource
    private SkuTypeMapper skuTypeMapper;
    @Override
    public void addSkuType(SkuTypeRequest request) {
        request.setId(UUIDGenerator.creatUUID());
        checkSkuType4Create(request);
        SkuType skuType = toSkuType(request);
        skuType.setCreator(ShiroUtils.getUserId());
        skuTypeMapper.insert(skuType);
    }

    private void checkSkuType4Create(SkuTypeRequest request) {
        SkuType parent = null;
        if (null != skuTypeMapper.findByName(request.getName())) {
            throw new ExceptionResponse("物料类型名称已存在");
        }
        if ("".equals(request.getParentId())){
            request.setParentId(null);
        }
        if(request.getParentId() != null){
            parent = this.findById(request.getParentId());
            if(parent == null){
                throw new ExceptionResponse("沒有找到上级");
            }
        }
    }

    private SkuType toSkuType(SkuTypeRequest request) {
        SkuType skuType = new SkuType();
        BeanUtils.copyProperties(request,skuType);
        return skuType;
    }

    @Override
    public SkuType findById(String id) {
        return skuTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSkuType(SkuTypeRequest request) {
        if(null == this.findById(request.getId()))
            throw new ExceptionResponse("传递了错误的id");
        this.checkSkuType4Create(request);
        SkuType skuType = toSkuType(request);
        skuType.setModifier(ShiroUtils.getUserId());
        skuTypeMapper.updateByPrimaryKey(skuType);
    }

    @Override
    public void delSkuType(String id) {
        skuTypeMapper.deleteByPrimaryKey(id);
    }
}
