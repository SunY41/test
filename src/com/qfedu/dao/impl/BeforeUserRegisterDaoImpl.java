package com.qfedu.dao.impl;

import com.qfedu.dao.BeforeUserRegisterDao;
import com.qfedu.util.BaseDao;

public class BeforeUserRegisterDaoImpl extends BaseDao implements BeforeUserRegisterDao {
    @Override
    public int registerUser(String username, String password, String phone, String mail) {
        String sql="insert into t_user (username,password,phone,mail) values (?,?,?,?)";
        Object [] obj={username,password,phone,mail};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}
