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
        }else if ("updateUser".equals(op)){
            updateUser(req,resp);
        }
    }
    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = (User) req.getSession().getAttribute("user");
        User user=this.userService.findUserByName(user1.getUsername());
        System.out.println(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("personal.jsp").forward(req,resp);
    }
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String uid=req.getParameter("uid");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        User user = new User();
        user.setUid(uid);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        String s=this.userService.updateUserByUUID(user);
        req.setAttribute("user",user);
        req.setAttribute("s",s);
        req.getRequestDispatcher("updateUser.jsp").forward(req,resp);
    }
}
