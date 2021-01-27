package com.qfedu.controller;

import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        int delete = goodsTypeService.delete(i);
        response.sendRedirect(servletContext.getContextPath()+"/GoodsTypeSelectServlet");
    }
}
