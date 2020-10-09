package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Page;
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
 * @ClassName UserServlet
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/08 13:50
 * @Version 1.0
 **/
@WebServlet(name = "UserServlet",urlPatterns = "/backstageUser")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String op = request.getParameter("op");
        if("findAlluser".equals(op)){
            // 查询所有用户信息
            findAllUser(request, response);
        }
    }

    /**
     * 查询：查询所有用户信息
     * @param request
     * @param response
     */
    private void findAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");
        String currentPage = request.getParameter("pageCount");
        request.getSession().setAttribute("findInfo", username);
        String findInfo = (String) request.getSession().getAttribute("findInfo");
        if(findInfo == null){
            findInfo = "";
        }
        if(currentPage == null){
            currentPage = "1";
        }
        // 查询用户信息
        Page<User> users = userService.findUserByName(findInfo, Integer.parseInt(currentPage), 10);
        // 存储到请求属性中
        request.setAttribute("users", users);
        // 请求转发
        request.getRequestDispatcher("/backstage/user/userInfoShow.jsp").forward(request, response);
    }
}
