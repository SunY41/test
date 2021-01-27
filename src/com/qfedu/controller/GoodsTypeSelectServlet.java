package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");
        if (pNo==null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize=4;
        GoodsTypeServiceImpl goodsTypeSelectServletService = new GoodsTypeServiceImpl();
        int count = goodsTypeSelectServletService.goodsTypeCount();

        List<GoodsType> list = goodsTypeSelectServletService.goodsTypeSelect(pageNo, pageSize);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setDataCount(count);
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("list",list);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageDataCount",count);
        request.setAttribute("pageNo",pageNo);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request, response);

    }
}
