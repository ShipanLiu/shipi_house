package com.shipi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shipi.dao.BaseDao;
import com.shipi.dao.RoleDao;
import com.shipi.entity.Role;
import com.shipi.service.RoleService;
import com.shipi.utils.CastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service  // 表明是 Service 类型的
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired // 下面 roleDao报红 没有关系
//    @Qualifier("roleDao")
    private RoleDao roleDao;


//    因为这个时候 RoleService 里面就只剩下了 findAll 方法， 所以 只需要 override 这一个
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }


//    这里是 因为 BaseServiceImpl 里面有 一个 abstract 方法。
    @Override
    protected BaseDao<Role> getEntityDao() {
//        getEntityDao() 的作用 就是 返回 RoleDao 还是 AdminDao 。。。。
        return this.roleDao;
    }

//    @Override
//    public Integer insert(Role role) {
//        return roleDao.insert(role);
//        // 写完 上面的 方法之后， 就 开始 写mapper映射文件了。
//    }
//
//    @Override
//    public void delete(Long roleID) {
//        roleDao.delete(roleID);
//    }
//
//    @Override
//    public Role getById(Long roleID) {
//        return roleDao.getById(roleID);
//    }
//
//    @Override
//    public void update(Role role) {
//        roleDao.update(role);
//    }
//
//    @Override
//    public PageInfo<Role> findPage(Map<String, Object> filters) {
////        获取 当前的 页码
//        int pageNum = CastUtil.castInt(filters.get("pageNum"),1);
////        获取 每页显示的 条数
//        int pageSize = CastUtil.castInt(filters.get("pageSize"),10);
//
//        PageHelper.startPage(pageNum, pageSize); // pageNum = 1, pageSize = 3
////        这个 page 对象就是 一个 list
//        Page<Role> page = roleDao.findPage(filters);
////        5 是 对多显示 5 个 页码
//        return new PageInfo<>(page, 5);  // 2,3,4,5,6  / 3,4,5,6,7   每一行 5 个数字
//    }
}
