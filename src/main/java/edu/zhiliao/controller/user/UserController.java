package edu.zhiliao.controller.user;

import edu.zhiliao.entity.User;
import edu.zhiliao.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/zhifou/user")
public class UserController {

    @Autowired
    private UserService userService;

    //登陆处理
    @RequestMapping("/login")
    public String userLogin(String username, String password, Model model, HttpSession session,
                            HttpServletRequest request, HttpServletResponse response) {
        User user = userService.searchUserByName(username);
        if(user==null){
            System.out.println("null");
            model.addAttribute("message","用户不存在");
            return "/zhifou/error/error.html";
        }
        String page = "/zhifou/user/login.html";
        if(user.getPassword().equals(password)){
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
//            page = "redirect:/zhifou/people/" + user.getUid();
            page = "redirect:/zhifou/know/know.html";
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            Cookie cookie = new Cookie("user", user.toString());
        }
        else
            model.addAttribute("message", "密码错误");
        return page;
    }
    //注册处理
    @RequestMapping("/register")
    public String userRegister(String name, String password, Model model) {
        User user = userService.searchUserByName(name);
        if(user != null) {
            model.addAttribute("message", "用户名已存在");
            return "/zhifou/error/error.html";
        } else {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setRegisterDate(date);
            userService.insertUser(user);
            model.addAttribute("message", "注册成功");
            return "/zhifou/user/login.html";
        }
    }
}
