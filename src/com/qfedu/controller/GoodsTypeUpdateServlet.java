package com.qfedu.controller;

import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        String typename = request.getParameter("typename");
//        System.out.println(typename);
        String id = request.getParameter("id");
        if ( id!=null  && !"".equals(id)){
            int i = Integer.parseInt(id);
            GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
            int update = goodsTypeService.update(typename, i);
            response.sendRedirect(servletContext.getContextPath()+"/GoodsTypeSelectServlet");
        }else {
            GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
            int add = goodsTypeService.add(typename);
//            System.out.println(add);
            response.sendRedirect(servletContext.getContextPath()+"/GoodsTypeSelectServlet");
        }
    }
}
