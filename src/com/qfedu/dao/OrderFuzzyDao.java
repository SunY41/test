package com.qfedu.dao;

import com.qfedu.entity.Order;

import java.util.List;

public interface OrderFuzzyDao {
    public List<Order> select(int pageNo, int pageSize,String st);
    public int selectCount();
    public int delete(int ordersid);
//    public List<>
}
