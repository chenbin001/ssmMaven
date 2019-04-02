package org.ssmmaven.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ssmmaven.bean.User;
import org.ssmmaven.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录页面
     */
    @RequestMapping("/test.html")
    public ModelAndView frontLogin() {
        ModelAndView mv = new ModelAndView();
        // 显示登录页面
        mv.setViewName("test");
        return mv;
    }
    @RequestMapping("/login.ajax")
    @ResponseBody
    public JSONObject login(HttpServletRequest request, String userName, String password) {

        HttpSession session = request.getSession();
        JSONObject data = new JSONObject();
            User user = userService.checkLogin(userName, password);
            if (user != null) {
                data.put("login", "true");
                    // 保存用户ID
                    session.setAttribute("id", user.getId());
                    // 保存用户名
                    session.setAttribute("userName", userName);
            } else {
                data.put("login", "false");
            }

        return data;
    }

}
