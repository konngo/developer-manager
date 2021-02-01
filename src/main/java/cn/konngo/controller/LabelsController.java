package cn.konngo.controller;

import cn.konngo.entity.LabelsEntity;
import cn.konngo.service.LabelsService;
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
@RequestMapping("/labels")
// 标签 控制层
public class LabelsController {
    @Autowired
    LabelsService labelsService;


    @RequestMapping("list")
    @ResponseBody
    // 返回所有标签
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=labelsService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定标签
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        LabelsEntity labelsEntity=labelsService.select(id);
        map.put("entity",labelsEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除标签
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=labelsService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改标签
    public HashMap saveOrUpdate(LabelsEntity labelsEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+labelsEntity.getId()).equals("")||labelsEntity.getId()==0){
            count=labelsService.insert(labelsEntity);
        }else {
            count=labelsService.update(labelsEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "labelslist";
    }
}
