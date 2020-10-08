package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.Trolley;
import com.etc.shopsys.domain.User;
import com.etc.shopsys.service.GoodsService;
import com.etc.shopsys.service.TrolleyService;
import com.etc.shopsys.service.impl.GoodsServiceImpl;
import com.etc.shopsys.service.impl.TrolleyServiceImpl;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="goodsDetialServlet" ,urlPatterns = "/good")
public class GoodsDetialServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();
    private TrolleyService trolleyService = new TrolleyServiceImpl();

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

    private void insertIntoCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gid = req.getParameter("gid");
        User user = (User) req.getSession().getAttribute("user");
        Trolley trolley = new Trolley();
        trolley.setGid(gid);
        trolley.setUid(user.getUid());
        String s = trolleyService.insertTrolley(trolley);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    private void findGByGid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gid = req.getParameter("gid");
        Goods goods = goodsService.findGoodsById(gid);
        //System.out.println(goods);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("description.jsp").forward(req,resp);
    }
}
