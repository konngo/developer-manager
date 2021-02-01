package cn.konngo.controller;

import cn.konngo.entity.RolesEntity;
import cn.konngo.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        }else {
            count=rolesService.update(rolesEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "roleslist";
    }
}
