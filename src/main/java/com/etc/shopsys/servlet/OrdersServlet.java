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

    private void ordersPage(HttpServletRequest req, HttpServletResponse resp) {




    }

    private void allOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Orders> allOrders = ordersService.findAllOrders();
        req.setAttribute("allOrders",allOrders);
        req.getRequestDispatcher("myOrders.jsp").forward(req,resp);

    }
}
