package com.htf.service.impl;

import com.htf.controller.request.MenuRequest;
import com.htf.controller.response.MenuResponse;
import com.htf.entity.Menu;
import com.htf.exception.ExceptionResponse;
import com.htf.mapper.MenuMapper;
import com.htf.mapper.RoleMenuRelMapper;
import com.htf.service.MenuService;
import com.htf.util.UUIDGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PC-FENG on 2017/8/18.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuRelMapper roleMenuRelMapper;


    @Override
    public void addMenu(MenuRequest request) {
        request.setId(UUIDGenerator.creatUUID());
        Menu menu = this.toMenu(request);
        Integer max = this.toMaxOrder(request.getParentId());
        menu.setOrder(max.toString());
        menuMapper.insert(menu);

    }

    @Override
    public void updateMenu(MenuRequest request) {
        Menu menu = this.toMenu(request);
        menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public MenuResponse getMenu(String id) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        MenuResponse menuResponse = new MenuResponse();
        BeanUtils.copyProperties(menu,menuResponse);
        return menuResponse;
    }

    @Override
    public void delMenu(String id) {
        //检查是否有子菜单
        Integer count = this.checkIncludeChild(id);
        if(count > 0){
            throw new ExceptionResponse("当前菜单还有子菜单不予删除");
        }
        roleMenuRelMapper.delByMenuId(id);
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Set<String> getPermissions(String userId) {
        List<String> menuList = menuMapper.getPermissions(userId);
                //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for(String perm : menuList){
            if(StringUtils.isBlank(perm)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }
        return permsSet;
    }

    private Integer checkIncludeChild(String parentId) {
        return  menuMapper.checkIncludeChild(parentId);
    }

    private Menu toMenu(MenuRequest request) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(request,menu);
        return menu;
    }

    private Integer toMaxOrder(String parentId){
        Integer max = menuMapper.findMaxOrderByParentId(parentId);
        return  ++max;
    }
}
