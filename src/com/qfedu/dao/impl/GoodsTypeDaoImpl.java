package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.entity.GoodsType;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
        public GoodsTypeDaoImpl() {
        }

        public List<GoodsType> goodsTypeSelect(int pageNo, int pageSize) {
            String sql = "select * from t_goodstype where 1 = 1 limit ?, ?";
            Object[] obj = new Object[]{(pageNo - 1) * pageSize, pageSize};
            ArrayList list = new ArrayList();

            try {
                ResultSet resultSet = this.select(sql, obj);

                while(resultSet.next()) {
                    GoodsType goodsType = new GoodsType();
                    goodsType.setId(resultSet.getInt(1));
                    goodsType.setTypename(resultSet.getString(2));
                    goodsType.setLevel(resultSet.getInt(3));
                    goodsType.setPid(resultSet.getInt(4));
                    list.add(goodsType);
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return list;
        }

        public int goodsTypeCount() {
            String sql = "select count(1) from t_goodstype";
            Object[] obj = new Object[0];
            int count = 0;

            try {
                for(ResultSet resultSet = this.select(sql, obj); resultSet.next(); count = resultSet.getInt(1)) {
                }
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return count;
        }

    @Override
    public int add(String typename) {
        String sql="insert into t_goodstype(typename) values(?)";
        Object [] obj={typename};
        int i = super.setUpdate(sql, obj);
        return i;
    }



        public GoodsType getGoodsTypeById(int id) {
            String sql = "select * from t_goodstype where id = ?";
            Object[] obj = new Object[]{id};
            GoodsType goodsType = new GoodsType();

            try {
                ResultSet resultSet = this.select(sql, obj);

                while(resultSet.next()) {
                    goodsType.setId(resultSet.getInt(1));
                    goodsType.setTypename(resultSet.getString(2));
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            return goodsType;
        }

    @Override
    public int update(String typename ,int id) {
            String sql="update t_goodstype set typename=? where id=?";
            Object[] obj={typename,id};
            int i = super.setUpdate(sql, obj);
            return i;
    }

    @Override
    public int delete(int id) {
            String sql ="delete from t_goodstype where id=?";
            Object [] obj={id};
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public List<GoodsType> selectType() {
            String sql="select *from t_goodstype ";
            Object [] obj={};
        List<GoodsType> list = new ArrayList<>();

        try {
            ResultSet select = super.select(sql, obj);
            while (select.next()){
                GoodsType goodsType = new GoodsType();
                goodsType.setId(select.getInt("id"));
                goodsType.setTypename(select.getString("typename"));
                goodsType.setLevel(select.getInt("level"));
                goodsType.setPid(select.getInt("pid"));
                list.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
