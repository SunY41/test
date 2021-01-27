package com.qfedu.dao.impl;

import com.qfedu.dao.DeleteGoodsDao;
import com.qfedu.entity.Order;
import com.qfedu.util.BaseDao;

public class DeleteGoodsDaoImpl extends BaseDao implements DeleteGoodsDao {
    @Override
    public int delete(int id) {
        String sql="delete from t_goods where id=?";
        Object[] obj={id};
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int daletes(Object[] id) {
        String sql="delete from t_goods where id in(?)";
        Object obj[]={id};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}
