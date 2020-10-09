package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.OrderDetails;
import com.etc.shopsys.domain.Orders;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.domain.User;
import com.etc.shopsys.service.OrderDetailsService;
import com.etc.shopsys.service.OrdersService;
import com.etc.shopsys.service.impl.OrderDetailsServiceImpl;
import com.etc.shopsys.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ordersServlet",urlPatterns = "/orders")
public class OrdersServlet extends HttpServlet {

    private OrdersService ordersService = new OrdersServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String op = req.getParameter("op");
        if("allOrders".equals(op)){
            allOrders(req,resp);
        }else if("ordersPage".equals(op)){
            ordersPage(req,resp);
        }
    }

    public void ordersPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        User user = (User) req.getSession().getAttribute("user");
        //                                                               用户编号         当前页       页面显示记录数
        Page<Orders> ordersInfoByUid = ordersService.findOrdersInfoByUid(user.getUid(), Integer.parseInt(pageNum), 5);
        req.setAttribute("ordersInfoByUid",ordersInfoByUid);
        // 更改页面显示数据条后，要跳转到我的订单
        req.getRequestDispatcher("myOrders.jsp").forward(req,resp);


    }

    public void allOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Orders> allOrders = ordersService.findAllOrders();
        req.setAttribute("allOrders",allOrders);
        // 跳转到我的订单
        req.getRequestDispatcher("myOrders.jsp").forward(req,resp);

    }
}
