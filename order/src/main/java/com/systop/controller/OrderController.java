package com.systop.controller;

import com.systop.entity.Order;
import com.systop.entity.OrderVo;
import com.systop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVo findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") int uid){
        OrderVo orderVo = new OrderVo();
        orderVo.setMsg("");
        orderVo.setCount(orderRepository.countByUid(uid));
        orderVo.setData(orderRepository.findAllByUid(index, limit, uid));
        return orderVo;
    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") int uid){
        return orderRepository.countByUid(uid);
    }
}
