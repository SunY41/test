package com.qfedu.service.impl;

import com.qfedu.dao.impl.DeleteGoodsDaoImpl;
import com.qfedu.service.DeleteGoodsService;

public class DeleteGoodsServiceImpl implements DeleteGoodsService {
    @Override
    public int delect(int id) {
        DeleteGoodsDaoImpl deleteGoodsDao = new DeleteGoodsDaoImpl();
        int i = deleteGoodsDao.delete(id);
        return i;
    }
}
