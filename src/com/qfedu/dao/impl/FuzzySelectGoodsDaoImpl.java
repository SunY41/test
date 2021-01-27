package com.qfedu.dao.impl;

import com.qfedu.dao.FuzzySelectGoodsDao;
import com.qfedu.entity.Goods;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuzzySelectGoodsDaoImpl extends BaseDao implements FuzzySelectGoodsDao {
    @Override
    public List<Goods> selectGoods(int pageNo, int pageSzie,String condition) {

       String sql="select * from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id "+condition+" limit ?,?";
       Object[] obj={(pageNo-1)*pageSzie,pageSzie};
        ArrayList<Goods> list = new ArrayList<>();
        try {

            ResultSet select = super.select(sql, obj);
            while (select.next()){
                Goods goods = new Goods();
//                goods.setScore(select.getInt("score"));
                goods.setId(select.getInt("id"));
                goods.setGoodsName(select.getString("goodsName"));
                goods.setPrice(select.getDouble("price"));
                goods.setImgPath(select.getString("imgPath"));
                goods.setTypename(select.getString("typename"));
                goods.setComment(select.getString("comment"));
                goods.setDeployDate(select.getString("deployDate"));
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }



    @Override
    public List<Goods> select1(int pageNo, int pageSize) {
         String sql="select * from t_goods,t_goodstype where t_goods.typeid=t_goodstype limit ?,?";
        Object[] obj={(pageNo-1)*pageSize,pageSize};
        ArrayList<Goods> list = new ArrayList<>();
        try {

            ResultSet select = super.select(sql, obj);
            while (select.next()){
                Goods goods = new Goods();
//                goods.setScore(select.getInt("score"));
                goods.setId(select.getInt("id"));
                goods.setGoodsName(select.getString("goodsName"));
                goods.setPrice(select.getDouble("price"));
                goods.setImgPath(select.getString("imgPath"));
                goods.setTypename(select.getString("typename"));
                goods.setComment(select.getString("comment"));
                goods.setDeployDate(select.getString("deployDate"));
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public int selectDataCount() {
        String sql = "select count(1) from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id";//获取数据个数
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet select = super.select(sql, obj);
            while (select.next()) {
                count=select.getInt("count(1)");
            }

        } catch (Exception e) {
        }
        return count;
    }
    }




