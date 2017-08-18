package com.htf.controller;

import com.htf.controller.request.MenuRequest;
import com.htf.controller.response.MenuResponse;
import com.htf.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PC-FENG on 2017/8/18.
 */
@RestController
@RequestMapping("/menu")
@Api(value = "menu",description = "菜单相关Controller")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ApiOperation(value = "添加菜单",notes = "根据参数添加菜单")
    @ApiImplicitParam(value = "MenuRequest", required = true,dataType = "MenuRequest")
    public void addMenu(@RequestBody MenuRequest request){
        menuService.addMenu(request);
    }
    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "修改菜单",notes = "根据参数修改菜单")
    @ApiImplicitParam(value = "MenuRequest", required = true,dataType = "MenuRequest")
    public void updateMenu(@RequestBody MenuRequest request){
        menuService.updateMenu(request);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "修改菜单",notes = "根据参数修改菜单")
    @ApiImplicitParam(value = "MenuRequest", required = true,dataType = "MenuRequest")
    public MenuResponse getMenu(@PathVariable String id){
        return menuService.getMenu(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除菜单",notes = "根据ID删除菜单")
    @ApiImplicitParam(value = "id", required = true,dataType = "string")
    public void delMenu(@PathVariable String id){
        menuService.delMenu(id);
    }

}
