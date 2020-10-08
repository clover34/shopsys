package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.User;
import com.etc.shopsys.service.UserService;
import com.etc.shopsys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "registerServlet",urlPatterns = "/user")
public class RegisterServlet extends HttpServlet {
    private UserService service;

    public RegisterServlet() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //处理编码方式，获取全局参数编码方式
        //String encoding=this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取OP请求参数
        String op=req.getParameter("op");
        if ("addUser".equals(op)){
            this.addUser(req,resp);
        }
    }
    private void addUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");

        //调用业务层
       User u=service.findUserByName(username);
        if (u ==null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setEmail(email);
            String info=service.insertUser(user);
            req.setAttribute("info",info);
        }else {
            req.getRequestDispatcher("register.jsp").forward(req,resp);

        }
        req.getRequestDispatcher("userLogin.jsp").forward(req,resp);
    }
}
