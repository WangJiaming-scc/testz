package com.systop.repository;

import com.systop.entity.Order;
import com.systop.entity.OrderVo;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public List<Order> findAllByUid(int index, int limit, long uid);
    public int countByUid(int uid);
}
