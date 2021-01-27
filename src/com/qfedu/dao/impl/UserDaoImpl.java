package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> selectUser(int pageNo, int pageSize,String condition) {
        String sql = "select * from t_user where 1=1 " +condition+ " limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List<User> list = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setSex(resultSet.getString("sex"));
//                user.setMail(resultSet.getString("mail"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int selectDataCount() {
        String sql = "select count(1) from t_user";//获取数据个数
        Object[] obj = {};
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
    public int UserReset(int a) {
        String sql = "update t_user set password=? where id=? ";
        Object[] obj = {123456, a};
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int deleteUser(int a) {
        String sql = "delete from t_user where id=?";
        Object[] obj = {a};
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int insertUser(String username,String password,String phone,String mail) {
        String sql ="insert into t_user (username ,password,phone,mail) values (?,?,?,?)";
        Object[] obj={username,password,phone,mail};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}