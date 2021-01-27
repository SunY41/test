package com.qfedu.controller;

import com.qfedu.service.BeforeUserLoginService;
import com.qfedu.service.impl.BeforeUserLoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BeforeUserLoginServlet")
public class BeforeUserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        BeforeUserLoginService beforeUserLoginService = new BeforeUserLoginServiceImpl();
        boolean b = beforeUserLoginService.UserLogin(username,password);
        if (b==true){
            response.sendRedirect(servletContext.getContextPath()+"/before/index.html");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/before/login.html");
        }
//        System.out.println(username);
    }
}
