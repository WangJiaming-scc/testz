package com.systop.feign;

import com.systop.entity.Order;
import com.systop.entity.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVo findAllByUid(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("uid") long uid);
}
