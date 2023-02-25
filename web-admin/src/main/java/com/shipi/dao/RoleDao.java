package com.shipi.dao;

import com.github.pagehelper.Page;
import com.shipi.dao.BaseDao;
import com.shipi.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


//@Repository("roleDao")
public interface RoleDao extends BaseDao<Role>{
    // define a method
    List<Role> findAll();

//
//     // 添加操作
//
//    Integer insert(Role role);
//
//
//    // 删除操作
//
//    // after this---> go to RoleDaoMapper.xml to define the SQL
//    void delete(Long roleID);
//
//
//    // 更新 操作
//    Role getById(Long roleID);
//
//    void update(Role role);
//
//
////   Page 继承了 ArrayList， 就是一个list
//    Page<Role> findPage(Map<String, Object> filters);
//
//    /*
//    * because I created the BaseDao unter connom-util, so I only need to inherite it and done
//    *
//    * */
//


}
