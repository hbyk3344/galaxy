package com.hope.galaxy.support.sso.control;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserControl {
    @GetMapping("index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        UsernamePasswordToken up = new UsernamePasswordToken("john","123456");
        SecurityUtils.getSubject().login(up);
        return "login";
    }

    @GetMapping("toLogin")
    public Map<String,String> toLogin(){
        Map<String,String> result = new HashMap<>();
        result.put("code","-100");
        result.put("msg","未登录");
        return result;
    }
    @GetMapping("unauth")
    public String unauth(){
        return "unauth";
    }
    @GetMapping("sucess")
    public String sucess(){
        return "sucess";
    }
}
