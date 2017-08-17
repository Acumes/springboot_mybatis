package com.htf.service;


import com.htf.controller.request.RoleRequest;
import com.htf.controller.response.RoleCascadeResponse;
import com.htf.controller.response.RoleResponse;
import com.htf.controller.response.RoleSubResponse;
import com.htf.controller.response.RoleToUserResponse;
import com.htf.entity.Role;

import java.util.List;

/**
 * Created by PC-FENG on 2017/8/17.
 */
public interface RoleService {
    Role findById(String id);
    void addRole(RoleRequest request);
    RoleResponse getRole(String id);

    void updateRole(RoleRequest request);

    void delRole(String id);

    List<RoleSubResponse> getSubRoles();

    List<RoleSubResponse> getChildRoles(String id);

    List<RoleToUserResponse> findAllRole();

    List<RoleCascadeResponse> findAdllRoleBeltCascade();
}
