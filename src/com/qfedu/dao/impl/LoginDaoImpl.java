package com.qfedu.dao.impl;

import com.qfedu.dao.LoginDao;
import com.qfedu.entity.Admin;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;

public class LoginDaoImpl extends BaseDao implements LoginDao {
    @Override
    public boolean LoginSelect(Admin ad) {
        boolean flag=false;
        String sql="select *from admin where username=? and password=?";
        Object [] obj={ad.getUsername(),ad.getPassword()};
        try {
            ResultSet select = super.select(sql, obj);
            if (select.next()){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
