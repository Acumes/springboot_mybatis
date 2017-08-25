package com.htf.controller;

import com.htf.entity.MeasureunitType;
import com.htf.service.MeasureunitTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/25.
 */
@Api(value = "获取计量单位",description = "获取计量单位类型")
@RestController
@RequestMapping("/measure")
public class MeasureunitTypeController {

    @Autowired
    private MeasureunitTypeService measureunitTypeService;

    @ApiOperation(value = "获取计量单位List",notes = "获取计量单位List")
    @RequestMapping("/list")
    public List<MeasureunitType> getMeasureunitList(){
        return measureunitTypeService.selectMeasureunitList();
    }

}
