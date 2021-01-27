package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> selectUser(int pageNo, int pageSize ,String condition) {
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.selectUser(pageNo, pageSize ,condition);
        return users;

    }

    @Override
    public int selectDataCount() {
        UserDao userDao = new UserDaoImpl();
        int count = userDao.selectDataCount();
        return count;
    }

    @Override
    public int UserReset(int a) {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.UserReset(a);
        return i;
    }

    @Override
    public int deleteUser(int a) {
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.deleteUser(a);
        return i;
    }

    @Override
    public int insertUser(String username, String password, String phone, String mail) {
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.insertUser(username, password, phone, mail);
        return i;
    }
}
