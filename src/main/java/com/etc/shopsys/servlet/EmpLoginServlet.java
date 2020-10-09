package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.service.EmpService;
import com.etc.shopsys.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EmpLoginServlet
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/07 9:31
 * @Version 1.0
 **/
@WebServlet(name = "EmpLoginServlet", urlPatterns = "/emplogin")
public class EmpLoginServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数3
        String empname = req.getParameter("empname");
        String password = req.getParameter("password");
        System.out.println("empname = " + empname);
        System.out.println("password = " + password);
        // 检查员工是否存在
        Emp emp = empService.findEmpByAccountAndPwd(empname, password);
        System.out.println("emp = " + emp);
        if(emp != null){
            // 员工存在,存储到会话当中
            req.getSession().setAttribute("emp", emp);
            req.getRequestDispatcher("/backstage/shopBackstage.jsp").forward(req, resp);
//            if(emp.getEtid().getEtname().equals("administrator")){
//                // 超级管理员跳转后台页面
//            } else {
//                // 管理员
//            }
        } else {
            // 员工不存在
            req.setAttribute("info", "用户名密码错误");
            // 跳转员工登录界面
            req.getRequestDispatcher("/backstage/empLogin.jsp").forward(req, resp);
        }
    }
}
