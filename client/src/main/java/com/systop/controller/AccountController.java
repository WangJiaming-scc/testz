package com.systop.controller;

import com.systop.entity.Admin;
import com.systop.entity.User;
import com.systop.feign.AccountFeign;
import javafx.print.PageLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username, password,type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap<String, Object>) object;
        String result = null;
        if(object == null){
            result = "login";
        }else {
            switch (type){
                case "user":
                    User user = new User();
                    String idStr = hashMap.get("id")+"";
                    long id = Long.parseLong(idStr);
                    String nickname = (String)hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    String idStr1 = hashMap.get("id")+"";
                    long id1 = Long.parseLong(idStr1);
                    String username1 = (String)hashMap.get("username");
                    admin.setId(id1);
                    admin.setUsername(username1);
                    session.setAttribute("admin",admin);
                    result = "menu_manage";
                    break;
            }
        }
        return result;
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }


}
