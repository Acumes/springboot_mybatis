package com.htf.mapper;

import com.htf.entity.SkuBom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by PC-FENG on 2017/8/25.
 */
@Mapper
public interface SkuBomMapper {
    int batchInsert(@Param("items") List<SkuBom> items, @Param("uniformSkuCode") String uniformSkuCode,
                    @Param("uniformSkuVersion") int uniformSkuVersion, @Param("uniformCrtTime") Date uniformCrtTime,
                    @Param("uniformCreator") String uniformCreator);
}
