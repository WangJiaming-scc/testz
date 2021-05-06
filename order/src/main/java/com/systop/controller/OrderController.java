package com.systop.controller;

import com.systop.entity.Order;
import com.systop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "Order的当前端口是："+this.port;
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

}
