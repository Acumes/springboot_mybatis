package com.htf.mapper;

import com.htf.entity.MeasureunitType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/25.
 */
@Mapper
public interface MeasureunitTypeMapper {
    List<MeasureunitType> selectMeasureunitList();
}
