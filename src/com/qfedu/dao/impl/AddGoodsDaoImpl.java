package com.qfedu.dao.impl;

import com.qfedu.dao.AddGoodsDao;
import com.qfedu.util.BaseDao;

public class AddGoodsDaoImpl extends BaseDao implements AddGoodsDao {
    @Override
    public int addGoods(String goodsName, double price, String comment, int typeId, String imgPath) {
        String sql="insert into t_goods (goodsName,Price,comment,typeId,imgPath) values (?,?,?,?,?)";
        Object[] obj={goodsName,price,comment,typeId,imgPath};
        int i = super.setUpdate(sql, obj);

        return i;
    }

    @Override
    public int update( int id,String goodsName,double price,String comment,int typeId,String imgPath) {
        String sql="update t_goods set goodsName=?, price=?, comment=? ,typeId=?, imgPath=? where id=?";
        Object[] obj={goodsName ,price,comment,typeId,imgPath,id};
        int i = super.setUpdate(sql, obj);
        return i;
    }


}
