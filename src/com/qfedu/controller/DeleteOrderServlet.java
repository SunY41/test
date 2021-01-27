package com.qfedu.controller;

import com.qfedu.service.impl.DeleteGoodsServiceImpl;
import com.qfedu.service.impl.OrderFuzzyServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeleteGoodsServiceImpl deleteGoodsService = new DeleteGoodsServiceImpl();
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        String ordersid = request.getParameter("ordersid");
        int id = Integer.parseInt(ordersid);
        OrderFuzzyServiceImpl orderFuzzyService = new OrderFuzzyServiceImpl();
        int delete = orderFuzzyService.delete(id);
//        System.out.println(delete);
        response.sendRedirect(servletContext.getContextPath()+"/OrderFuzzySelectServlet");
    }
}
