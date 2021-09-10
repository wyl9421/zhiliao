package edu.zhiliao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@MapperScan("edu.zhiliao.mapper")
@ServletComponentScan//启动类上使用@ServletComponentScan，自动扫描带有(@WebServlet, @WebFilter, and @WebListener)注解的类，完成注册
public class ZhiliaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhiliaoApplication.class, args);
    }
    @RequestMapping
    public String defaultMapping() {
        return "/zhifou/user/login.html";
    }
}
