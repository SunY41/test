package com.qfedu.controller;

import com.qfedu.entity.Order;
import com.qfedu.service.OrderFuzzyService;
import com.qfedu.service.impl.OrderFuzzyServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        String pageNo = request.getParameter("pageNo");
        String username = request.getParameter("username");
        String status = request.getParameter("status");
        StringBuffer condition = new StringBuffer();
        if (username!=null&&!"".equals(username)&&status!=null&&!"".equals(status)){
            int i1 = Integer.parseInt(status);
            condition.append("and username like '%"+username+"%'" +"and t_status.id like '%"+i1+"%'");
        }else if (username!=null&&!"".equals(username)){
            condition.append("and username like '%"+username+"%'");
        }else if (status!=null&&!"".equals(status)){
            int i = Integer.parseInt(status);
            condition.append("and t_status.id like '%"+i+"%'");
        }
        if (pageNo==null){
            pageNo="1";
        }
        int i = Integer.parseInt(pageNo);
        int pageSize=5;
        OrderFuzzyService orderFuzzyService = new OrderFuzzyServiceImpl();
        List<Order> select = orderFuzzyService.select(i, pageSize,condition.toString());
        int count = orderFuzzyService.selectCount();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setDataCount(count);
        pageUtil.setPageNo(i);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("list",select);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request, response);
    }
}

