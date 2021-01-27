package com.qfedu.dao;

import com.qfedu.entity.Goods;

import java.util.List;

public interface FuzzySelectGoodsDao {
    public List<Goods> selectGoods(int pageNo,int pageSzie,String condition);
    public int selectDataCount();
    public List<Goods>select1(int pageNo,int pageSize);

}
