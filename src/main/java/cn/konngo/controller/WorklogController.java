package cn.konngo.controller;

import cn.konngo.entity.UsersEntity;
import cn.konngo.entity.WorklogEntity;
import cn.konngo.service.UsersService;
import cn.konngo.service.WorklogService;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/worklog")
// 工作日志 控制层
public class WorklogController {
    @Autowired
    WorklogService worklogService;

    @Autowired
    UsersService usersService;

    @RequestMapping("list")
    @ResponseBody
    // 返回所有工作日志
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=worklogService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定工作日志
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        WorklogEntity worklogEntity=worklogService.select(id);
        map.put("entity",worklogEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除工作日志
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=worklogService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改工作日志
    public HashMap saveOrUpdate(WorklogEntity worklogEntity){
        HashMap map=new HashMap();

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UsersEntity usersEntity=usersService.login(username);
        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+worklogEntity.getId()).equals("")||worklogEntity.getId()==0){
            worklogEntity.setUserid(usersEntity.getId());
            count=worklogService.insert(worklogEntity);
        }else {
            count=worklogService.update(worklogEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "workloglist";
    }
}
