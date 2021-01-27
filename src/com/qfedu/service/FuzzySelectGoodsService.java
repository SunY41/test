package com.qfedu.service;

import com.qfedu.entity.Goods;

import java.util.List;

public interface FuzzySelectGoodsService {
    public List<Goods> selectGoods(int pageNo,int pageSzie,String condition);
    public int selectDataCount();
    public List<Goods>select1(int pageNo,int pageSize);
}
