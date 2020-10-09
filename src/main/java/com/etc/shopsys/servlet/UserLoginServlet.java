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

/**
 * @ClassName UserLoginServlet 用户登录 校验
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/06 11:13
 * @Version 1.0
 **/
@WebServlet(name = "UserLoginServlet",
            urlPatterns = "/userlogin"
)
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        // 验证用户信息
        User user = userService.findUserByNameAndPwd(username, password);
        System.out.println("user = " + user);
        if(user != null){
            // 用户存在，将用户信息存入到会话当中
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            // 用户不存在
            req.setAttribute("info", "用户名密码错误");
            req.getRequestDispatcher("/userLogin.jsp").forward(req, resp);
        }
    }
}
