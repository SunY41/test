package com.qfedu.service;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> goodsTypeSelect(int var1, int var2);
    int goodsTypeCount();
    GoodsType getGoodsTypeById(int var1);
    public int add(String typename);
    public int update(String typename);
    public int delete (int id);
    public List<GoodsType> selectType();

}
