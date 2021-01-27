package com.qfedu.controller;

import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        String id = request.getParameter("id");
        int i= Integer.parseInt(id);
        UserServiceImpl userService = new UserServiceImpl();
        int i1 = userService.deleteUser(i);
        if (i1 != 0){
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }
    }
}
