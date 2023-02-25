package com.shipi.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Map;

public interface BaseService<T> {
    Integer insert(T t);

    // after this  ---> do to RoleServiceImpl
    void delete(Serializable id);

    T getById(Serializable id);

    void update(T t);

    PageInfo<T> findPage(Map<String, Object> filters);

}
