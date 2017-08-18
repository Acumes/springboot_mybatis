package com.htf.service;

import com.htf.controller.request.MenuRequest;
import com.htf.controller.response.MenuResponse;

import java.util.Set;

/**
 * Created by PC-FENG on 2017/8/18.
 */
public interface MenuService {


    void addMenu(MenuRequest request);

    void updateMenu(MenuRequest request);

    MenuResponse getMenu(String id);

    void delMenu(String id);

    Set<String> getPermissions(String userId);
}
