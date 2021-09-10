package com.zhiliao.app.controller;

import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户模块API")
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名",required = true,defaultValue = "刘备"),
            @ApiImplicitParam(name = "password", value = "密码",required = true,defaultValue = "123456")
    })
    @RequestMapping("/login")
    public String login(String username,String password){
        UsernamePasswordToken token=
                new UsernamePasswordToken(username,password);
        try {
            Subject subject= SecurityUtils.getSubject();
            if(!subject.isAuthenticated()){
                subject.login(token);
            }
        }catch (UnknownAccountException ue){
            return "0";
        }catch (IncorrectCredentialsException ice){
            return "-1";
        }
        return "1";
    }

    //注册
    @ApiOperation(value = "用户注册")
    @GetMapping("/register")
    public boolean register(User user){
        return userService.register(user);
    }

    //修改用户个人信息
    @ApiOperation(value = "修改用户信息")
    @GetMapping("/update")
    public boolean update(User user){
        return userService.updateUserMessage(user);
    }

    //注销用户
    @ApiOperation(value = "注销用户")
    @GetMapping("/destroy")
    public boolean destory(Integer id){
        return userService.destory(id);
    }

}
