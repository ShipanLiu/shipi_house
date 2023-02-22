package com.shipi.dao;

import com.shipi.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("roleDao")
public interface RoleDao {
    // define a method
    List<Role> findAll();


     // 添加操作

    Integer insert(Role role);


    // 删除操作

    // after this---> go to RoleDaoMapper.xml to define the SQL
    void delete(Long roleID);


    // 更新 操作
    Role getById(Long roleID);

    void update(Role role);


}
