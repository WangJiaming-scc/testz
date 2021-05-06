package com.systop.controller;

import com.systop.entity.Menu;
import com.systop.entity.Order;
import com.systop.entity.User;
import com.systop.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid, HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.save(order);
        return "index";
    }
}
