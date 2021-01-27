package com.qfedu.dao;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> goodsTypeSelect(int var1, int var2);

    int goodsTypeCount();
    public int add(String typename);

    GoodsType getGoodsTypeById(int var1);
    public int update(String typename,int id);
    public int delete (int id);
    public List<GoodsType> selectType();
}
