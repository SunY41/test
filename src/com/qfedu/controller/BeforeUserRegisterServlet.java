package com.qfedu.controller;

import com.qfedu.service.BeforeUserRegisterService;
import com.qfedu.service.impl.BeforeUserRegisterServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BeforeUserRegisterServlet")
public class BeforeUserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();//servlet上下文对象
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        BeforeUserRegisterService beforeUserRegisterService = new BeforeUserRegisterServiceImpl();
        int i = beforeUserRegisterService.registerUser(username, password, phone, mail);
        if (i==1){
            response.sendRedirect(servletContext.getContextPath()+"/before/success.html");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/before/index.html");
        }

    }
}
