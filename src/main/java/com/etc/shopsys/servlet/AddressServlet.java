package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.User;
import com.etc.shopsys.domain.UserAddress;
import com.etc.shopsys.service.UserAddressService;
import com.etc.shopsys.service.impl.UserAddressServiceImpl;
import com.etc.shopsys.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.UID;
import java.util.List;

@WebServlet(name="addressServlet" ,urlPatterns = "/address")
public class AddressServlet extends HttpServlet {

    private UserAddressService userAddressService = new UserAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String op = req.getParameter("op");
        if("allAddressInfo".equals(op)){
            allAddressInfo(req,resp);
        }else if("delete".equals(op)){
            delete(req,resp);
        }else if("update".equals(op)){
            update(req,resp);
        }else if("updateSuccess".equals(op)){
            updateSuccess(req,resp);
        }else if("insertAddress".equals(op)){
            insertAddress(req,resp);
        }


    }

    private void insertAddress(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uname = req.getParameter("uname");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");

        User user = (User) req.getSession().getAttribute("user");
        UserAddress userAddress = new UserAddress();
        userAddress.setUid(user.getUid());
        userAddress.setContactname(uname);
        userAddress.setPhone(tel);
        userAddress.setUaddress(address);
        String s = userAddressService.insertAddress(userAddress);
        req.setAttribute("s",s);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();

    }

    private void updateSuccess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String UUID = req.getParameter("UUID");
        String contactname = req.getParameter("contactname");
        String phone = req.getParameter("phone");
        String uaddress = req.getParameter("uaddress");
        User user = (User) req.getSession().getAttribute("user");

        String s = userAddressService.updateAddress(new UserAddress(UUID, user.getUid(), contactname, phone, uaddress));
        req.setAttribute("s",s);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UUID = req.getParameter("UUID");
        UserAddress addressByUUID = userAddressService.findAddressByUUID(UUID);
        req.setAttribute("addressByUUID",addressByUUID);
        req.getRequestDispatcher("updateAddress.jsp").forward(req,resp);

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String UUID = req.getParameter("UUID");
        String s = userAddressService.deleteAddress(UUID);
        req.setAttribute("s",s);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    private void allAddressInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        List<UserAddress> allAddress = userAddressService.findAllAddress(user.getUid());
        req.setAttribute("allAddress",allAddress);
        req.getRequestDispatcher("address.jsp").forward(req,resp);
    }
}
