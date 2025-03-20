package com.nlt.zhilian.contrtoller;

import com.nlt.zhilian.pojo.Result;
import com.nlt.zhilian.pojo.User;
import com.nlt.zhilian.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletResponse response) {
        /*
        保存cookie
         */
        User user1 = null;
        try {
            user1 = userService.login(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("请稍后重试。");
        }
        if (user1 != null) {
            // 设置username cookie
            Cookie usernameCookie = new Cookie("username", user1.getUsername());
            usernameCookie.setPath("/");
            usernameCookie.setMaxAge(3600); // 1小时有效期
            
            // 设置userType cookie
            Cookie userTypeCookie = new Cookie("userType", user1.getUserType());
            userTypeCookie.setPath("/");
            userTypeCookie.setMaxAge(3600);
            
            response.addCookie(usernameCookie);
            response.addCookie(userTypeCookie);
            
            return Result.success();
        }
        return Result.error("用户名或密码输入错误。");
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        System.out.println(user);
        int n;
        try {
            n = userService.register(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("用户名已存在。");
        }
        return (n > 0) ? Result.success() : Result.error("注册失败，请稍后重试。");
    }

    /**
     * 从请求中获取指定名称的 Cookie 值
     *
     * @param request
     * @param cookieName
     * @return
     */
    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
