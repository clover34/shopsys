package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.User;
import com.etc.shopsys.domain.UserAddress;
import com.etc.shopsys.service.OrdersService;
import com.etc.shopsys.service.UserAddressService;
import com.etc.shopsys.service.UserService;
import com.etc.shopsys.service.impl.OrdersServiceImpl;
import com.etc.shopsys.service.impl.UserAddressServiceImpl;
import com.etc.shopsys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="personalServlet" ,urlPatterns = "/personal")
public class PersonalServlet extends HttpServlet {
    private OrdersService ordersService;
    private UserService userService;
    private UserAddressService userAddressService;

    public PersonalServlet() {
        this.ordersService = new OrdersServiceImpl();
        this.userService =new UserServiceImpl();
        this.userAddressService=new UserAddressServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String op = req.getParameter("op");
        if ("findUser".equals(op)){
            findUser(req,resp);
        }else if("User".equals(op)){
            user(req,resp);
        }else if ("updateUser".equals(op)){
                updateUser(req,resp);
        }
    }
    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = (User) req.getSession().getAttribute("user");
        User user=this.userService.findUserByName(user1.getUsername());
        System.out.println(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("information.jsp").forward(req,resp);
    }
    private void user(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = (User) req.getSession().getAttribute("user");
        User user=this.userService.findUserByName(user1.getUsername());
        System.out.println(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("updateUser.jsp").forward(req,resp);
    }
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        User user = (User) req.getSession().getAttribute("user");
        System.out.println("未修改" + user);
        user.setEmail(req.getParameter("email"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setPhone(req.getParameter("phone"));
//        User user=this.userService.findUserByName(user1.getUsername());
        String info=this.userService.updateUserByUUID(user);
        user = this.userService.findUserByName(user.getUsername());
        System.out.println("修改 = " + user);
        System.out.println("修改结果" + info);
        req.getSession().setAttribute("user", user);
        req.setAttribute("user",user);
        req.setAttribute("s",info);
        req.getRequestDispatcher("updateUser.jsp").forward(req,resp);
    }
}
