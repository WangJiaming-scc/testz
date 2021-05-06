package com.systop.repository;

import com.systop.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public List<Order> findAll(int index,int limit);
}
