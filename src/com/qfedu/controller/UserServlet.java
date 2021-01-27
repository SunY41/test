package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserFuzzyServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sex = request.getParameter("sex");
        String username = request.getParameter("username");
        StringBuffer condition = new StringBuffer();
        if (username != null && !"".equals(username)&& sex != null && !"".equals(sex)) {
            condition.append("and username like '%" + username + "%'" + " and sex =\""+ sex+ "\"");
        } else if (username != null && !"".equals(username)) {
            condition.append("and username like '%" + username + "%'" );
        } else if (sex != null && !"".equals(sex)) {
            condition.append(" and sex =\""+ sex+ "\"");
        }
        UserService userService = new UserServiceImpl();
        int count = userService.selectDataCount();
        String pNo = request.getParameter("pageNo");//获取传过来的pageNo
        if (pNo==null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);//转换为int 数据类型
        //设置pageSize
        int pageSize=5;
        List<User> users = userService.selectUser(pageNo, pageSize,condition.toString());//转为string数据
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo);
        pageUtil.setDataCount(count);//获取数据个数
        int pageCount = pageUtil.getPageCount();//获取总页数
        request.setAttribute("list",users);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/user.jsp").forward(request, response);


    }
}
