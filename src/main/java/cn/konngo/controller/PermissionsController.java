package cn.konngo.controller;

import cn.konngo.common.Permissions;
import cn.konngo.entity.PermissionsEntity;
import cn.konngo.entity.RolesEntity;
import cn.konngo.entity.UsersEntity;
import cn.konngo.service.PermissionsService;
import cn.konngo.service.RolesService;
import cn.konngo.service.UsersService;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permissions")
// 权限 控制层
public class PermissionsController {

    @Autowired
    UsersService usersService;
    @Autowired
    PermissionsService permissionsService;
    @Autowired
    RolesService rolesService;


    @RequestMapping("changePermission")
    @ResponseBody
    // 返回所有权限
    public Map changePermission(String permissions){
        List<Permissions> list= JSONObject.parseArray(permissions,Permissions.class);
        System.out.println(list);
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        for (Permissions p: list) {
            // 拼接permission对象
            PermissionsEntity per=new PermissionsEntity();
            per.setId(p.getId());
            per.setName(per.getName());
            int add = p.isAdd() == true ? 0 : 1 ;
            int update = p.isUpdate() == true ? 0 : 1 ;
            int delete = p.isDelete() == true ? 0 : 1 ;
            per.setOthers(add+","+update+","+delete);
            permissionsService.update(per);
        }
        return map;
    }


    @RequestMapping("list")
    @ResponseBody
    // 返回所有权限
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=permissionsService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("listByRoles")
    @ResponseBody
    // 返回对应角色权限
    public Map listByRoles(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=permissionsService.listByRoles(id);
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }


    @RequestMapping("nowuser")
    @ResponseBody
    // 返回当前用户对应角色权限
    public Map nowuser(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UsersEntity usersEntity=usersService.login(username);
        RolesEntity roles=rolesService.selectByUser(usersEntity.getId());
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=permissionsService.listByRoles(roles.getId());
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定权限
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        PermissionsEntity permissionsEntity=permissionsService.select(id);
        map.put("entity",permissionsEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除权限
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=permissionsService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改权限
    public HashMap saveOrUpdate(PermissionsEntity permissionsEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+permissionsEntity.getId()).equals("")||permissionsEntity.getId()==0){
            count=permissionsService.insert(permissionsEntity);
        }else {
            count=permissionsService.update(permissionsEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "permissions";
    }
}
