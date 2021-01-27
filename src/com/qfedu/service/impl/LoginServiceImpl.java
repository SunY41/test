package com.qfedu.service.impl;

import com.qfedu.dao.LoginDao;
import com.qfedu.dao.impl.LoginDaoImpl;
import com.qfedu.entity.Admin;
import com.qfedu.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean LoginSelect(Admin ad) {
        LoginDao loginDao = new LoginDaoImpl();
        boolean b = loginDao.LoginSelect(ad);
        return b;
    }
}
