package com.htf.controller;

import com.htf.controller.request.UserRequest;
import com.htf.controller.response.UserResponse;
import com.htf.entity.Sku;
import com.htf.service.SkuService;
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
@Api(value = "sku" , description = "SkuController")
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @ApiOperation(value = "添加SKU",notes = "根据请求参数添加SKU")
    @ApiImplicitParam(value = "Sku",required = true,dataType = "Sku")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void addSku(@RequestBody Sku request){
        request.setSkuCode(UUIDGenerator.creatUUID());
        skuService.addSku(request);
    }
    @ApiOperation(value = "查询SKU",notes = "根据skucode查询相应的sku")
    @ApiImplicitParam(value = "skuCode",required = true,dataType = "string")
    @RequestMapping(value = "/{skuCode}",method = RequestMethod.GET)
    public Sku getSkuInfo(@PathVariable String skuCode){
        return skuService.findByCode(skuCode);
    }
    @ApiOperation(value = "修改SKU",notes = "根据请求参数修改SKU")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void updateUser(@RequestBody Sku request){
        skuService.updateSku(request);
    }
    @RequestMapping(value = "/{code}",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据ID删除用户",notes = "传递用户ID")
    @ApiImplicitParam(value = "code",required = true,dataType = "string")
    public void delSku(@PathVariable String code){
        skuService.delSku(code);
    }

}
