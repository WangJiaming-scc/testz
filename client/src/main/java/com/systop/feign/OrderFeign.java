package com.systop.feign;

import com.systop.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);
}
