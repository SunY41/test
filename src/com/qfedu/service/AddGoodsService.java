package com.qfedu.service;

public interface AddGoodsService {
    public int addGoods(String goodsName,double price,String comment,int typeId,String imgPath);
    public int update(int id,String goodsName,double price,String comment,int typeId,String imgPath);

}
