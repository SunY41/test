package com.qfedu.dao.impl;

import com.qfedu.dao.BeforeUserLoginDao;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;

public class BeforeUserLoginDaoImpl extends BaseDao implements BeforeUserLoginDao {
    @Override
    public boolean UserLogin(String username,String password) {
        String sql="select *from t_user where username=? and password=?";
        Object[] obj={username,password};
        boolean log=false;
        try {
            ResultSet select = super.select(sql, obj);
            if (select.next()){
                log=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }
}
