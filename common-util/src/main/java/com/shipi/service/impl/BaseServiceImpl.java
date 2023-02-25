package com.shipi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shipi.dao.BaseDao;
import com.shipi.service.BaseService;
import com.shipi.utils.CastUtil;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Map;

/*
* BaseServiceImpl 是 以后被继承的 东西。
*
*
* */
// @Transactional 注解相信大家并不陌生，平时开发中很常用的一个注解，它能保证方法内多个数据库操作要么同时成功、要么同时失败
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    /*
    *
    * 因为需要的 dao 对象不一样， 有时候是 RoleDao， 有的时候是 AdminDao
    *  getEntityDao（） 里面的 implementation 是不一样的， 所以 就写一个 abstract 方法， 跟 interface 类似。
    *
    *
    *
    * */
    protected abstract BaseDao<T> getEntityDao();

    public Integer insert(T t) {
//        假如 getEntityDao() 的返回对象是 RoleDao， 那么这里是
        return getEntityDao().insert(t);
    }

    public void delete(Serializable id) {
        getEntityDao().delete(id);
    }

    public void update(T t) {
        getEntityDao().update(t);
    }

    public T getById(Serializable id) {
        return getEntityDao().getById(id);
    }

    public PageInfo<T> findPage(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
        //每页显示的记录条数
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 10);

        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(getEntityDao().findPage(filters), 5);
    }

}
