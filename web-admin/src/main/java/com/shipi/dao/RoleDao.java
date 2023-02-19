package com.shipi.dao;

import com.shipi.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("roleDao")
public interface RoleDao {
    // define a method
    List<Role> findAll();
}
