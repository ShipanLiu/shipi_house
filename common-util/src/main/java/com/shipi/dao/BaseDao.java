package com.shipi.dao;
/*
*
* 这里是 封装一下 常用的
*
*
*
*
*
* */

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

// 指定一下 泛型
public interface BaseDao<T> {

    /**
     * 保存一个实体
     *
     * @param t
     */
    Integer insert(T t);


    /**
     * 删除
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     */

//    你也可以用 Long，  但是 Serializable（接口类型） 是所有的 Long ， int 的 祖父
    void delete(Serializable id);

    /**
     * 更新一个实体
     *
     * @param t
     */
    Integer update(T t);

    /**
     * 通过一个标识ID 获取一个唯一实体
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     * @return
     */
    T getById(Serializable id);

    Page<T> findPage(Map<String, Object> filters);
}
