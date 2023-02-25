package com.shipi.dao;

import com.github.pagehelper.Page;

import java.io.Serializable;
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

//    你也可以用 Long，  但是 Serializable（接口类型） 是所有的 Long ， int 的 祖父, 你不能 用Long， 太固定， 有可能需要 int
    void delete(Serializable id);

    /**
     * 通过一个标识ID 获取一个唯一实体
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     * @return
     */
    T getById(Serializable id);

    /**
     * 更新一个实体
     *
     * @param t
     */
    void update(T t);



    Page<T> findPage(Map<String, Object> filters);
}

