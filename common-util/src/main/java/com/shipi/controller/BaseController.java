package com.shipi.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class BaseController {

//    这个 函数不能是 private 必须是 public， 因为 BaseController 会被别人 继承

    public Map<String, Object> getFilters(HttpServletRequest request) {
        // Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素。
        Enumeration<String> paramNames = request.getParameterNames(); // 一般情况下只有一个 parameter,比如 "jier"
        // TreeMap集合默认会对键进行排序，所以键必须实现自然排序和定制排序中的一种
        Map<String, Object> filters = new TreeMap();
        while(paramNames != null && paramNames.hasMoreElements()) {
            // eg. paramName = "jier"
            String paramName = (String)paramNames.nextElement();
            // 得到 参数名 对应的 值, 有可能一个参数对应多个值， 所以 返回一个数组, hobbies: ["basketball", "swim"];
            String[] values = request.getParameterValues(paramName);
            if (values != null && values.length != 0) {
                if (values.length > 1) {
//                  一个 key 对应 多个 values 的情况  比如 ： hobbies: ["basketball", "swim"];
                    filters.put(paramName, values);
                } else {
//                   ony key one value
                    filters.put(paramName, values[0]);
                }
            }
        }
//      在这个 treeMap 里面 添加 一个key“pageNum”， 初始值 为 1
        if(!filters.containsKey("pageNum")) {
            filters.put("pageNum", 1);
        }
        // 在这个 treeMap 里面 添加 一个key“pageSize”， 初始值 为 10
        if(!filters.containsKey("pageSize")) {
            filters.put("pageSize", 10);
        }

        return filters;
    }

}
