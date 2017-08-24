package com.htf.service;

import com.htf.controller.request.SkuTypeRequest;
import com.htf.entity.SkuType;

/**
 * Created by PC-FENG on 2017/8/24.
 */
public interface SkuTypeService {
    void addSkuType(SkuTypeRequest request);

    SkuType findById(String id);

    void updateSkuType(SkuTypeRequest request);

    void delSkuType(String id);
}
