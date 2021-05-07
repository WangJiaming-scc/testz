package com.systop.controller;

import com.systop.entity.Menu;
import com.systop.entity.Order;
import com.systop.entity.OrderVo;
import com.systop.entity.User;
import com.systop.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVo findAllByUid(@RequestParam("page") int page,@RequestParam("limit") int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findAllByUid(index,limit,user.getId());
    }
}
