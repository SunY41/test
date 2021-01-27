package com.qfedu.service.impl;

import com.qfedu.dao.FuzzySelectGoodsDao;
import com.qfedu.dao.impl.FuzzySelectGoodsDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.service.FuzzySelectGoodsService;

import java.util.List;

public class FuzzySelectGoodsServiceImpl implements FuzzySelectGoodsService {
    @Override
    public List<Goods> selectGoods(int pageNo, int pageSzie,String condition) {
        FuzzySelectGoodsDao fuzzySelectGoodsDao = new FuzzySelectGoodsDaoImpl();
        List<Goods> list = fuzzySelectGoodsDao.selectGoods(pageNo, pageSzie,condition);
        return list;
    }

    @Override
    public int selectDataCount() {
        FuzzySelectGoodsDao fuzzySelectGoodsDao = new FuzzySelectGoodsDaoImpl();
        int count = fuzzySelectGoodsDao.selectDataCount();
        return count;
    }

    @Override
    public List<Goods> select1(int pageNo, int pageSize) {
        FuzzySelectGoodsDao fuzzySelectGoodsDao = new FuzzySelectGoodsDaoImpl();
        List<Goods> list = fuzzySelectGoodsDao.select1(pageNo, pageSize);
        return list;
    }
}
