package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.service.GoodsService;
import com.etc.shopsys.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="goodsDetialServlet" ,urlPatterns = "/goods")
public class GoodsDetialServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String op = req.getParameter("op");
        if("findGByGid".equals(op)){
            findGByGid(req,resp);
        }else if("insertIntoCart".equals(op)){
            insertIntoCart(req,resp);
        }
    }

    private void insertIntoCart(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void findGByGid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gid = req.getParameter("gid");
        Goods goods = goodsService.findGoodsById(gid);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("description.jsp").forward(req,resp);
    }
}
