package cn.konngo.controller;


import cn.konngo.util.FileUploadUtil;
import cn.konngo.util.FtpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {


    @RequestMapping("goindex")
    public String goindex(){
        return "index";
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }


    @RequestMapping("profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("skills")
    public String skills(){
        return "skills";
    }

    @RequestMapping("/file-upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file) {
        Map map=new HashMap();
        map.put("code","1");
        if (file.isEmpty()) {
            map.put("msg","请选择上传文件");
        }
        FileUploadUtil fileUploadUtil=new FileUploadUtil();
        String filename=fileUploadUtil.uploadFile(file);
        map.put("code","0");
        map.put("msg","上传成功");
        map.put("data",filename);
        return map;
    }

    @RequestMapping("/ckeditor-upload")
    @ResponseBody
    // ckeditor文件上传
    public Map ckeditor(@RequestParam("file") MultipartFile file) {
        Map map=new HashMap();
        map.put("uploaded",false);
        if (file.isEmpty()) {
            map.put("msg", "没有发现文件！");
            return map;
        }
        FileUploadUtil fileUploadUtil=new FileUploadUtil();
        String filename=fileUploadUtil.uploadFile(file);
        map.put("uploaded",true);
        map.put("filename",filename);
        map.put("url", FtpUtil.server+filename);
        return map;
    }
}
