package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Orders;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.OrdersService;
import com.etc.shopsys.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName OrdersServlet
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/09 11:03
 * @Version 1.0
 **/
@WebServlet(name = "OrdersServlet",urlPatterns = "/backstageOrders")
public class OrderServlet extends HttpServlet {
    private OrdersService ordersService = new OrdersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if("findAllOrder".equals(op)){
            // 查询所有订单信息
            findAllOrder(request, response);
        } else if("updateOrderState".equals(op)){
            // 修改订单状态
            updateOrderState(request, response);
        }
    }

    /**
     * 修改：根据订单编号修改订单状态
     * @param request
     * @param response
     */
    private void updateOrderState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取请求数据
        String oid = request.getParameter("oid");
        String osid = request.getParameter("osid");
        // 执行修改
        String result = ordersService.updataOsidByOid(oid, Integer.parseInt(osid));
        // 打印输出
        PrintWriter out = response.getWriter();
        // 响应
        out.print(result);
        out.flush();
    }

    /**
     * 查询：查询所有订单信息
     * @param request
     * @param response
     */
    private void findAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String pageCount = request.getParameter("pageCount");
        String osid = request.getParameter("osid");
        // 获取订单记录：分页查询
        Page<Orders> orders = null;
        if(pageCount == null){
            pageCount = "1";
        }
        if(osid == null || osid == ""){
            orders = ordersService.findAllOrder(Integer.parseInt(pageCount), 5);
        } else {
            orders = ordersService.findOrdersInfoByOsid(Integer.parseInt(osid),Integer.parseInt(pageCount), 5);
        }
        // 将数据存储到请求属性中
        request.setAttribute("orders", orders);
        request.setAttribute("osid", osid);
        // 请求转发
        request.getRequestDispatcher("/backstage/orders/orderInfoShow.jsp").forward(request, response);
    }
}
