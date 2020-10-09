package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Emp;
import com.etc.shopsys.domain.EmpType;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.EmpService;
import com.etc.shopsys.service.EmpTypeService;
import com.etc.shopsys.service.impl.EmpServiceImpl;
import com.etc.shopsys.service.impl.EmpTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName EmpServlet
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/07 14:52
 * @Version 1.0
 **/
@WebServlet(name = "EmpServlet",urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String op = request.getParameter("op");
        if("findAllEmp".equals(op)){
            // 分页查询所有员工信息
            findAllEmp(request, response);
        } else if("empDetails".equals(op)){
            // 员工详情信息
            empDetails(request, response);
        } else if("logOut".equals(op)){
            // 员工退出登录页面
            empLogOut(request, response);
        } else if("updateEmpByempid".equals(op)){
            // 根据编号修改员工信息
            updateEmpByempid(request, response);
        } else if("insertEmp".equals(op)){
            // 新增员工信息
            insertEmp(request, response);
        }
    }

    /**
     * 新增：新增员工信息
     * @param request
     * @param response
     */
    private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmpTypeService etService = new EmpTypeServiceImpl();
        // 获取请求数据
        String empname = request.getParameter("empname");
        String empaccount = request.getParameter("empaccount");
        String etid = request.getParameter("etid");
        EmpType et = etService.findEmpTypeById(etid);
        // 声明一个员工对象
        Emp emp = new Emp();
        emp.setEmpname(empname);
        emp.setEmpaccount(empaccount);
        emp.setPassword("123");
        emp.setDimission(1);
        emp.setEtid(et);
        // 新增员工
        String info = empService.insertEmp(emp);
        // 声明输出对象,输出修改结果
        PrintWriter out = response.getWriter();
        out.print("<script>alert('"+ info +"');window.location.href ='/shopsys/emp?op=findAllEmp';</script>");
        out.flush();
    }

    /**
     * 修改：根据员工编号修改员工信息
     * @param request
     * @param response
     */
    private void updateEmpByempid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EmpTypeService etService = new EmpTypeServiceImpl();
        // 获取请求数据
        String empid = request.getParameter("empid");
        String empname = request.getParameter("empname");
        String empaccount = request.getParameter("empaccount");
        String password = request.getParameter("password");
        int dimission = Integer.parseInt(request.getParameter("dimission"));
        EmpType etid = etService.findEmpTypeById(request.getParameter("etid"));
        Emp emp = new Emp();
        emp.setEmpid(empid);
        emp.setEmpname(empname);
        emp.setEmpaccount(empaccount);
        emp.setPassword(password);
        emp.setDimission(dimission);
        emp.setEtid(etid);
        // 声明输出对象,输出修改结果
        PrintWriter out = response.getWriter();
        out.print("<script>alert('"+ empService.updateEmpById(emp) +"');window.location.href ='/shopsys/emp?op=findAllEmp';</script>");
        out.flush();
    }

    /**
     * 员工退出登录
     * @param request
     * @param response
     */
    private void empLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 移除 session 会话当中的员工信息
        request.getSession().removeAttribute("emp");
        // 重定向登录界面
        response.sendRedirect(request.getContextPath() + "/backstage/empLogin.jsp");
    }

    /**
     * 员工详情：根据 员工编号 查询员工信息
     * @param request
     * @param response
     */
    private void empDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的数据
        String empid = request.getParameter("empid");
        // 根据 员工编号 查询员工信息
        Emp emp = empService.findEmpById(empid);
        // 查询到的数据存储到请求属性中
        request.setAttribute("emp", emp);
        // 转发请求
        request.getRequestDispatcher("/backstage/empDetails.jsp").forward(request, response);
    }

    /**
     * 查询：分页查询所有员工信息
     * @param request
     * @param response
     */
    private void findAllEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String empname = request.getParameter("empname");// 需要模糊查询的员工名
        request.getSession().setAttribute("findInfo", empname);
        String pageCount = request.getParameter("pageCount");// 需要显示的页数
        String findInfo = (String)request.getSession().getAttribute("findInfo");
        // 当员工姓名为空时
        if(findInfo == null){
            findInfo = "";
        }
        // 当页数为空时，例如第一次加载页面
        if (pageCount == null){
            pageCount = "1";
        }
        // 根据条件查询员工数据
        Page<Emp> emps = empService.findEmpLikeByName(findInfo, Integer.parseInt(pageCount), 5);
        System.out.println(emps.getData());
        // 存储查询的数据到请求属性中
        request.setAttribute("emps", emps);
        // 请求转发员工信息
        request.getRequestDispatcher("/backstage/EmpInfoShow.jsp").forward(request,response);
    }
}
