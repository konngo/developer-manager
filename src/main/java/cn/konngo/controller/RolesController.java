package cn.konngo.controller;

import cn.konngo.entity.PermissionsEntity;
import cn.konngo.entity.RolepermissionsEntity;
import cn.konngo.entity.RolesEntity;
import cn.konngo.service.PermissionsService;
import cn.konngo.service.RolepermissionsService;
import cn.konngo.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.PolicyParser;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roles")
// 角色 控制层
public class RolesController {
    @Autowired
    RolesService rolesService;
    @Autowired
    PermissionsService permissionsService;
    @Autowired
    RolepermissionsService rolepermissionsService;


    @RequestMapping("list")
    @ResponseBody
    // 返回所有角色
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=rolesService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定角色
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        RolesEntity rolesEntity=rolesService.select(id);
        map.put("entity",rolesEntity);
        return map;
    }

    @RequestMapping("selectByUser")
    @ResponseBody
    // 根据用户查询指定角色
    public Map selectByUser(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        RolesEntity rolesEntity=rolesService.selectByUser(id);
        map.put("entity",rolesEntity);
        return map;
    }




    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除角色
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=rolesService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改角色
    public HashMap saveOrUpdate(RolesEntity rolesEntity){
        HashMap map=new HashMap();
        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+rolesEntity.getId()).equals("")||rolesEntity.getId()==0){
            count=rolesService.insert(rolesEntity);
            initPermission(rolesEntity.getId());
        }else {
            count=rolesService.update(rolesEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    // 初始化角色权限
    public void initPermission(int id){
        PermissionsEntity per1 = new PermissionsEntity("员工管理","1,1,1");
        PermissionsEntity per2 = new PermissionsEntity("岗位管理","1,1,1");
        PermissionsEntity per3 = new PermissionsEntity("标签管理","1,1,1");
        PermissionsEntity per4 = new PermissionsEntity("技能分类管理","1,1,1");
        PermissionsEntity per5 = new PermissionsEntity("技能管理","1,1,1");
        PermissionsEntity per6 = new PermissionsEntity("bug解决方案","1,1,1");
        PermissionsEntity per7 = new PermissionsEntity("工作日志","1,1,1");
        permissionsService.insert(per1);
        permissionsService.insert(per2);
        permissionsService.insert(per3);
        permissionsService.insert(per4);
        permissionsService.insert(per5);
        permissionsService.insert(per6);
        permissionsService.insert(per7);
        rolepermissionsService.insert(new RolepermissionsEntity(id,per1.getId()));
        rolepermissionsService.insert(new RolepermissionsEntity(id,per2.getId()));
        rolepermissionsService.insert(new RolepermissionsEntity(id,per3.getId()));
        rolepermissionsService.insert(new RolepermissionsEntity(id,per4.getId()));
        rolepermissionsService.insert(new RolepermissionsEntity(id,per5.getId()));
        rolepermissionsService.insert(new RolepermissionsEntity(id,per6.getId()));
        rolepermissionsService.insert(new RolepermissionsEntity(id,per7.getId()));
    }

    @RequestMapping("page")
    public String page(){
         return "roleslist";
    }
}
