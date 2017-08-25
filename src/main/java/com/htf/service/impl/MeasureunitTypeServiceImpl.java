package com.htf.service.impl;

import com.htf.entity.MeasureunitType;
import com.htf.mapper.MeasureunitTypeMapper;
import com.htf.service.MeasureunitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/25.
 */
@Service("measureunitTypeService")
public class MeasureunitTypeServiceImpl implements MeasureunitTypeService {
    @Autowired
    private MeasureunitTypeMapper measureunitTypeMapper;
    @Override
    public List<MeasureunitType> selectMeasureunitList() {
        return measureunitTypeMapper.selectMeasureunitList();
    }
}
