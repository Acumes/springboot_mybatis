package com.htf.service;

import com.htf.entity.Sku;

/**
 * Created by PC-FENG on 2017/8/24.
 */
public interface SkuService {
    void addSku(Sku request);

    Sku findByCode(String skuCode);

    void delSku(String code);

    void updateSku(Sku request);
}
