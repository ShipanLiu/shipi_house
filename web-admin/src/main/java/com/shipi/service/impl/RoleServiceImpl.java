package com.shipi.service.impl;

import com.shipi.dao.RoleDao;
import com.shipi.entity.Role;
import com.shipi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 表明是 Service 类型的
public class RoleServiceImpl implements RoleService {

    @Autowired // 下面 roleDao报红 没有关系
//    @Qualifier("roleDao")
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
