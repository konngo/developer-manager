package cn.konngo.controller;

import cn.konngo.entity.UsersEntity;
import cn.konngo.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
// 用户 控制层
public class UsersController {
    @Autowired
    UsersService usersService;


    @RequestMapping("list")
    @ResponseBody
    // 返回所有用户
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=usersService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定用户
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        UsersEntity usersEntity=usersService.select(id);
        map.put("entity",usersEntity);
        return map;
    }


    @RequestMapping("nowuser")
    @ResponseBody
    // 返回当前用户
    public Map nowuser(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UsersEntity usersEntity=usersService.login(username);
        map.put("entity",usersEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除用户
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=usersService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改用户
    public HashMap saveOrUpdate(UsersEntity usersEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+usersEntity.getId()).equals("")||usersEntity.getId()==0){
            count=usersService.insert(usersEntity);
        }else {
            count=usersService.update(usersEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "userslist";
    }
}
