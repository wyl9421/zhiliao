package com.zhiliao.app.utils;

import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm  extends AuthorizingRealm {
    @Resource
    private UserService usersService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection princal) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info=null;
        User user = usersService.login((String) token.getPrincipal());
        if(user!=null){
            //在此存储用户登录信息
            SecurityUtils.getSubject().getSession().setAttribute("user",user);
            info=new SimpleAuthenticationInfo(user.getName(),user.getPassword(),super.getName());
        }
        return info;
    }
}
