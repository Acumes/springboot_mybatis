package com.htf.controller;

import com.htf.controller.request.SkuTypeRequest;
import com.htf.entity.SkuType;
import com.htf.service.CacheService;
import com.htf.service.SkuTypeService;
import com.htf.util.UUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PC-FENG on 2017/8/24.
 */
@RestController
@Api(value = "skuType",description = "物料类型的Controller")
@RequestMapping("/skuType")
public class SkuTypeController {
    @Autowired
    private SkuTypeService skuTypeService;

    @ApiOperation(value = "添加SKU",notes = "根据请求参数添加SKU")
    @ApiImplicitParam(value = "Sku",required = true,dataType = "Sku")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void addSkuType(@RequestBody SkuTypeRequest request){
        skuTypeService.addSkuType(request);
    }
    @ApiOperation(value = "查询SKUType",notes = "根据id查询相应的skuType")
    @ApiImplicitParam(value = "id",required = true,dataType = "string")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SkuType getSkuTypeInfo(@PathVariable String id){
        return skuTypeService.findById(id);
    }
    @ApiOperation(value = "修改SKU",notes = "根据请求参数修改SKU")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void updateSkuType(@RequestBody SkuTypeRequest request){
        skuTypeService.updateSkuType(request);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据ID删除SKU类型 ",notes = "传递SKU类型ID")
    @ApiImplicitParam(value = "id",required = true,dataType = "string")
    public void delSkuType(@PathVariable String id){
        skuTypeService.delSkuType(id);
    }
}
