package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.service.FuzzySelectGoodsService;
import com.qfedu.service.impl.FuzzySelectGoodsServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/FuzzySelectGoods")
public class FuzzySelectGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");
        String goodsname = request.getParameter("goodsname");
        String deployDate = request.getParameter("deployDate");


        StringBuffer condition = new StringBuffer();
        if (goodsname != null && !"".equals(goodsname) && deployDate != null && !"".equals(deployDate)) {
            condition.append("and goodsname like'%" + goodsname + "%'" + "and deployDate like'%" + deployDate + "%'");
        } else if (goodsname != null && !"".equals(goodsname)) {
            condition.append("and goodsname like'%" + goodsname + "%'");
        } else if (deployDate != null && !"".equals(deployDate)) {
            condition.append("and deployDate like'%" + deployDate + "%'");
        }
        FuzzySelectGoodsServiceImpl fuzzySelectGoodsService = new FuzzySelectGoodsServiceImpl();
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        //111111111111
                //11111111
                int pageSize = 5;

                List<Goods> list = fuzzySelectGoodsService.selectGoods(pageNo, pageSize, condition.toString());

                int count = fuzzySelectGoodsService.selectDataCount();
                PageUtil pageUtil = new PageUtil();
                pageUtil.setPageSize(pageSize);
                pageUtil.setPageNo(pageNo);
                pageUtil.setDataCount(count);
                int pageCount = pageUtil.getPageCount();
                request.setAttribute("list", list);
                request.setAttribute("pageNo", pageNo);
                request.setAttribute("pageCount", pageCount);
                request.getRequestDispatcher("/after/goods_list.jsp").forward(request, response);



    }
}
