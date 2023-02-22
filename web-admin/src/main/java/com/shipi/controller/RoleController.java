package com.shipi.controller;

import com.shipi.entity.Role;
import com.shipi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/*
* 注意： controller 本身就是和 html 的 请求有关系的， 所以 所有的 路径请求 要写在这里。
*
* */



@Controller
@RequestMapping(value="/role")


public class RoleController {

    @Autowired
    private RoleService roleService;


    private final static String PAGE_INDEX = "role/index";
    private final static String SUCCESS_PAGE = "common/successPage";


    /**
     * 列表
     * @param model
     * @return
     * 这下面的 这个 RequestMapping 是 头儿， 是用来响应 “/role”  的
     */
    @RequestMapping
    public String index(ModelMap model) {
        List<Role> list = roleService.findAll();

        model.addAttribute("list", list);
        return PAGE_INDEX;
    }

//    添加角色的页面
    @RequestMapping("/create")
    public String goAddPage() {
        return "role/create";
    }

//    add a new Role in the table
    @RequestMapping("/save")
//    in SpringMVC there is  pojo, which means the data in HTML pages is encapsulated into the Role automaticly
    public String save(Role role) {
        // 一步一步， 先 调用 service，然后 在 service 里面 调用 dao，dao再添加 mapper 里面的 xml 文件， 总之 一层一层的
        roleService.insert(role);

        // now is time to redirect to 查询所有 角色的方法(你添加完之后， 再查询一遍)
//        return "redirect:/role";
         //  不重定向 了， 我们直接去 成功页面
        return SUCCESS_PAGE;

    }

//    实现 删除的 操作 delete
//    @GetMapping("/delete/{roleID}")
    @RequestMapping("delete/{roleID}")  // 不要写成  "role/delete/{roleID}"
    public String delete(@PathVariable("roleID") Long roleID) {
        // call service
        roleService.delete(roleID);

        // redirect 足够了
//        return "redirect:/
        return "redirect:/role";
    }


//    edit (2 steps:  query +_ update)
    @RequestMapping("/edit/{roleID}")
    public String goEditPage(@PathVariable("roleID") Long roleID, ModelMap modelMap) {
        Role role = roleService.getById(roleID);

        // 你要把 role 给传出去(放到request 域里面)， 人家才可能 去 修改， 所以 这里用 一个 Map， or ModelMap
        // so that you can use "role" in the html file
        modelMap.addAttribute("targetRole", role);

        // 然后 去 修改页面
        return "role/edit";
    }

    // 在 edit.html 里， 点下确定 -> "role/update"
//    form 在提交的时候， 封装成 Role, 也就是 update(Role role)   里卖的 role
    @RequestMapping("/update")
    public String update(Role role) {
        // go to service and create update method
        roleService.update(role);
        // go to the success page
        return SUCCESS_PAGE;
    }




}