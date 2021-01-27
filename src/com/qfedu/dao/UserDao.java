package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> selectUser(int pageNo,int pageSize ,String condition);//分页
    public int selectDataCount();//数据个数
    public int UserReset(int a);//重置密码
    public int deleteUser(int a);//删除用户
    public int insertUser(String username,String password,String phone,String mail);//增加用户
}
