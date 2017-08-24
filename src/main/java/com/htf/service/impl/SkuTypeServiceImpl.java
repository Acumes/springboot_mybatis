package com.htf.service.impl;

import com.htf.controller.request.SkuTypeRequest;
import com.htf.entity.SkuType;
import com.htf.service.SkuTypeService;
import org.springframework.stereotype.Service;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@Service("skuTypeService")
public class SkuTypeServiceImpl implements SkuTypeService {
    @Override
    public void addSkuType(SkuTypeRequest request) {

    }

    @Override
    public SkuType findById(String id) {
        return null;
    }

    @Override
    public void updateSkuType(SkuTypeRequest request) {

    }

    @Override
    public void delSkuType(String id) {

    }
}
