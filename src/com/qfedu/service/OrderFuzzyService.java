package com.qfedu.service;

import com.qfedu.entity.Order;

import java.util.List;

public interface OrderFuzzyService {
    public List<Order> select(int pageNo, int pageSize,String st);
    public int selectCount();
    public int delete(int ordersid);
}
