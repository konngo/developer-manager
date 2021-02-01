package cn.konngo.config;

import cn.konngo.common.R;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Map ErrorHandler(AuthorizationException e) {
        return R.error("没有通过权限验证！");
    }
}
