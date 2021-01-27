package com.qfedu.controller;

import com.qfedu.service.AddGoodsService;
import com.qfedu.service.impl.AddGoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddGoodsServlet")//添加修改商品
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        AddGoodsService addGoodsService = new AddGoodsServiceImpl();
        String goodsName = request.getParameter("goodsName");
        if (goodsName.length()==0){
            goodsName="8848炸弹";
        }
        String price = request.getParameter("price");
        if (price.length()==0){
            price="9999";
        }
        String imgPath = request.getParameter("imgPath");
        String comment = request.getParameter("comment");
        String typeId = request.getParameter("typeId");
        if (typeId.length()==0){
            typeId="9";
        }
        String id = request.getParameter("id");
        //System.out.println(id+"--------");
        System.out.println(goodsName.length());
        int id2 = Integer.parseInt(typeId);
        int id1 = Integer.parseInt(price);

        if (id!=null&&!"".equals(id)){
            int id3 = Integer.parseInt(id);
            System.out.println();
            int update = addGoodsService.update(id3, goodsName, id1, comment, id2, imgPath);
            System.out.println(update+"--------");
        }else {
            int i2 = addGoodsService.addGoods(goodsName, id1, comment, id2, imgPath);
        }
        response.sendRedirect(servletContext.getContextPath()+"/FuzzySelectGoods");
    }
}
