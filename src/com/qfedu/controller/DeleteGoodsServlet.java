package com.qfedu.controller;

import com.qfedu.entity.Num;
import com.qfedu.service.impl.DeleteGoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i = request.getParameter("goodsid");//删除商品
        System.out.println(i);
        DeleteGoodsServiceImpl deleteGoodsService = new DeleteGoodsServiceImpl();
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
//        System.out.println(i.length());
        if (i.contains(",")){
            StringTokenizer stringTokenizer = new StringTokenizer(i, ",,");//切割字符串
            while (stringTokenizer.hasMoreTokens()){
                String s = stringTokenizer.nextToken();
                int i1 = Integer.parseInt(s);
                int delect = deleteGoodsService.delect(i1);
//                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

            }
        }else{
            int id = Integer.parseInt(i);
            int delect = deleteGoodsService.delect(id);
//            response.sendRedirect(servletContext.getContextPath()+"/FuzzySelectGoods");
//            System.out.println(555);
        } response.sendRedirect(servletContext.getContextPath()+"/FuzzySelectGoods");
    }
}

