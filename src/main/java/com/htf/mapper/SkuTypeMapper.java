package com.htf.mapper;

import com.htf.entity.SkuType;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@Mapper
public interface SkuTypeMapper extends BaseMapper<SkuType , String >{
    SkuType findByName(String name);
}
