package com.qfedu.test;

import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.impl.AddGoodsServiceImpl;
import com.qfedu.service.impl.FuzzySelectGoodsServiceImpl;
import com.qfedu.service.impl.GoodsTypeServiceImpl;

import java.util.List;
import java.util.StringTokenizer;

public class Demo  {
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
//        List<User> users = userService.selectUser(2, 3);
//        for (User user : users) {
//            System.out.println(user);
//        UserDaoImpl userDao = new UserDaoImpl();
//        int count = userDao.selectDataCount();
//        System.out.println(count);
//        List<User> users = userDao.selectUser(1, 3);
//        for (User user : users) {
//            System.out.println(user);
//        UserDeleteDaoImpl userDeleteDao = new UserDeleteDaoImpl();
//        int i = userDeleteDao.deleteUser(1);
//        System.out.println(i);
//        UserResetDaoImpl userResetDao = new UserResetDaoImpl();
//        int i1 = userResetDao.UserReset(4);
//        System.out.println(i1);
//        UserServiceImpl userService = new UserServiceImpl();
//        int i = userService.insertUser("123", "123", "158974898", "22277488997@qq.com");
//        System.out.println(i);
//        BeforeUserLoginDaoImpl beforeUserLoginDao = new BeforeUserLoginDaoImpl();
//        boolean b = beforeUserLoginDao.UserLogin("laoba","123456");
//        System.out.println(b);
//        GoodsTypeSelectServletServiceImpl goodsTypeSelectServletService = new GoodsTypeSelectServletServiceImpl();
//        List<Type> list = goodsTypeSelectServletService.selectType(1, 3);
//        for (Type type : list) {
//            System.out.println(type);
//        }
//        FuzzySelectGoodsServiceImpl fuzzySelectGoodsService = new FuzzySelectGoodsServiceImpl();
//        List<Goods> list = fuzzySelectGoodsService.selectGoods(1, 3);
//        for (Goods goods : list) {
//            System.out.println(goods);

//
//        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
//        List<GoodsType> goodsTypes = goodsTypeDao.TypeSelect();
//        for (GoodsType goodsType : goodsTypes) {
//            System.out.println(goodsType);
//            String id = goodsType.getTypename();
//            System.out.println(id);
//        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
////        String typename = request.getParameter("typename");
//        int i = goodsTypeService.add("老铁");
//        System.out.println(i);
//        FuzzySelectGoodsServiceImpl fuzzySelectGoodsService = new FuzzySelectGoodsServiceImpl();
//        int count = fuzzySelectGoodsService.selectDataCount();
//        System.out.println( count);
//        List<Goods> list = fuzzySelectGoodsService.selectGoods(1, 6);
//        for (Goods goods : list) {
//            System.out.println(goods);
        String i="11,,11,,11,,1122,,33,,66,,99";
//        StringTokenizer stringTokenizer = new StringTokenizer(i, ",,");
//        System.out.println(stringTokenizer);
//        while (stringTokenizer.hasMoreTokens()){
//            System.out.println(stringTokenizer.nextToken());
//        }
//        AddGoodsServiceImpl addGoodsService = new AddGoodsServiceImpl();
////        int i1 = addGoodsService.addGoods("laox", 444, "meimaobing", 1, "33");
////        System.out.println(i1);
//        String sql="11,,22";
//        System.out.println(sql.length());
        String sql="select * from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id %特价%  limit ?,?";
    }
    }




