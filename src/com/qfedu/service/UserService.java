package com.qfedu.service;

import com.qfedu.entity.User;

import java.util.List;

public interface UserService {
    public List<User> selectUser(int pageNo, int pageSize, String condition);
    public int selectDataCount();
    public int UserReset(int a);
    public int deleteUser(int a);
    public int insertUser(String username,String password,String phone,String mail);
}
