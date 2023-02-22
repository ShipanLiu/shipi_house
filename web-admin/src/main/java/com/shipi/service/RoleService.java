package com.shipi.service;

import com.shipi.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    // when you add a new role, the request "role/save" will be send.
    Integer insert(Role role);

    // after this  ---> do to RoleServiceImpl
    void delete(Long roleID);

    Role getById(Long roleID);

    void update(Role role);
}
