package com.shipi.service;

import com.github.pagehelper.PageInfo;
import com.shipi.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<Role> findAll();
    // when you add a new role, the request "role/save" will be send.
    Integer insert(Role role);

    // after this  ---> do to RoleServiceImpl
    void delete(Long roleID);

    Role getById(Long roleID);

    void update(Role role);

    PageInfo<Role> findPage(Map<String, Object> filters);
}
