package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.GoodsService;
import com.etc.shopsys.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet",urlPatterns = "/goods")
public class ShowAllGoodsServlet extends HttpServlet {
    private GoodsService service;

    public ShowAllGoodsServlet() {
        this.service =new GoodsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //处理编码方式，获取全局参数编码方式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取OP请求参数
        String op=req.getParameter("op");
        if ("findAll".equals(op)){
            this.findAll(req,resp);
        }
    }
    public void findAll(HttpServletRequest req,HttpServletResponse resp){
        String pageNum=req.getParameter("pageNum");
    }
}
