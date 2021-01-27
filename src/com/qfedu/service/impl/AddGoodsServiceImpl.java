package com.qfedu.service.impl;

import com.qfedu.controller.AddGoodsServlet;
import com.qfedu.dao.impl.AddGoodsDaoImpl;
import com.qfedu.service.AddGoodsService;

public class AddGoodsServiceImpl implements AddGoodsService {
    @Override
    public int addGoods(String goodsName, double price, String comment, int typeId, String imgPath) {
        AddGoodsDaoImpl addGoodsDao = new AddGoodsDaoImpl();
        int i = addGoodsDao.addGoods(goodsName, price, comment, typeId, imgPath);
        return i;
    }

    @Override
    public int update(int id, String goodsName, double price, String comment, int typeId, String imgPath) {
        AddGoodsDaoImpl addGoodsDao = new AddGoodsDaoImpl();
        int update = addGoodsDao.update(id, goodsName, price, comment, typeId, imgPath);

        return update;
    }
}
