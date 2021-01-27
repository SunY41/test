package com.qfedu.service.impl;

import com.qfedu.dao.impl.BeforeUserLoginDaoImpl;
import com.qfedu.service.BeforeUserLoginService;

public class BeforeUserLoginServiceImpl implements BeforeUserLoginService {
    @Override
    public boolean UserLogin(String username, String password) {
        BeforeUserLoginDaoImpl beforeUserLoginDao = new BeforeUserLoginDaoImpl();
        boolean b = beforeUserLoginDao.UserLogin(username, password);
        return b;
    }
}
