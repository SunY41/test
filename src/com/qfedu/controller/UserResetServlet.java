package com.qfedu.controller;

import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserResetServlet")
public class UserResetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        UserService userService = new UserServiceImpl();
        int i = Integer.parseInt(id);
        int i1 = userService.UserReset(i);
        if (i!=0){
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }
    }
}
