package com.qfedu.dao.impl;

import com.qfedu.dao.OrderFuzzyDao;
import com.qfedu.entity.Order;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderFuzzyDaoImpl extends BaseDao implements OrderFuzzyDao {
    @Override
    public List<Order> select(int pageNo, int pageSize,String st) {
        String sql = " SELECT * FROM t_order,t_user,t_status WHERE t_order.STATUS=t_status.id AND t_order.uid = t_user.id "+st+" limit ?,?";
        Object[] obj={(pageNo-1)*pageSize,pageSize};
        ArrayList<Order> orders = new ArrayList<>();
        try {
            ResultSet select = super.select(sql, obj);

            while (select.next()){
                Order order = new Order();
                order.setUsername(select.getString("username"));
                order.setOrder_status(select.getString("order_status"));
                order.setCreateDate(select.getString("createDate"));
                order.setId(select.getInt("id"));
                order.setTotalPrice(select.getInt("totalPrice"));
                order.setOrderCode(select.getString("orderCode"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return orders;
    }

    @Override
    public int selectCount() {
        String sql="SELECT count(1) FROM t_order,t_user,t_status WHERE t_order.STATUS=t_status.id AND t_order.uid = t_user.id";
        Object[] obj={};
        int count = 0;
        try {
            ResultSet select = super.select(sql, obj);
            while (select.next()) {
                count = select.getInt("count(1)");
            }
        } catch (Exception e) {
        }
        return count;
    }

    @Override
    public int delete(int ordersid) {
        String sql="delete from t_order where id=?";
        Object[] obj={ordersid};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}
