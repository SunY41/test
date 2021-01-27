package com.qfedu.service.impl;

import com.qfedu.dao.impl.OrderFuzzyDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.OrderFuzzyService;

import java.util.List;

public class OrderFuzzyServiceImpl implements OrderFuzzyService {
    @Override
    public List<Order> select(int pageNo, int pageSize,String st) {
        OrderFuzzyDaoImpl orderFuzzyDao = new OrderFuzzyDaoImpl();
        List<Order> select = orderFuzzyDao.select(pageNo, pageSize,st);
        return select;
    }

    @Override
    public int selectCount() {
        OrderFuzzyDaoImpl orderFuzzyDao = new OrderFuzzyDaoImpl();
        int count = orderFuzzyDao.selectCount();
        return count;
    }

    @Override
    public int delete(int ordersid) {
        OrderFuzzyDaoImpl orderFuzzyDao = new OrderFuzzyDaoImpl();
        int delete = orderFuzzyDao.delete(ordersid);
        return delete;

    }
}
