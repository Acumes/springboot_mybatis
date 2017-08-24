package com.htf.mapper;

import com.htf.entity.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@Mapper
public interface SkuMapper extends BaseMapper<Sku,String> {
    Sku selectByName(String name);
}
