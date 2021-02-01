package cn.konngo.controller;

import cn.konngo.common.R;
import cn.konngo.entity.UsersEntity;
import cn.konngo.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UsersService usersService;

    @RequestMapping("login")
    public String login(UsersEntity users){
        System.out.println("users"+users);
        Map map=new HashMap<>();

        if (StringUtils.isEmpty(users.getUsername()) || StringUtils.isEmpty(users.getPassword())) {
            return "login";
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                users.getUsername(),
                users.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            //return "用户名不存在！";
            return "login";
        } catch (AuthenticationException e) {
            //return "账号或密码错误！";
            return "login";
        } catch (AuthorizationException e) {
            //return "没有权限！";
            return "login";
        }
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        //return R.ok("users",usersService.login(username));
        return "index";
    }
}
