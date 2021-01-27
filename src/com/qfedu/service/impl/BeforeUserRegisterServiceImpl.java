package com.qfedu.service.impl;


import com.qfedu.dao.BeforeUserRegisterDao;
import com.qfedu.dao.impl.BeforeUserRegisterDaoImpl;
import com.qfedu.service.BeforeUserRegisterService;

public class BeforeUserRegisterServiceImpl implements BeforeUserRegisterService {
    @Override
    public int registerUser(String username, String password, String phone, String mail) {
        BeforeUserRegisterDao beforeUserRegisterDao = new BeforeUserRegisterDaoImpl();
        int i = beforeUserRegisterDao.registerUser(username, password, phone, mail);

        return i;
    }
}
