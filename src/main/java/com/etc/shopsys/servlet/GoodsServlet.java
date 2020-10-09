package com.etc.shopsys.servlet;

import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.GoodsTyple;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.GoodsService;
import com.etc.shopsys.service.GoodsTypeService;
import com.etc.shopsys.service.impl.GoodsServiceImpl;
import com.etc.shopsys.service.impl.GoodsTypeServiceImpl;
import com.etc.shopsys.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName GoodsService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/08 16:17
 * @Version 1.0
 **/
@WebServlet(name = "GoodsService",urlPatterns = "/backstageGoods")
@MultipartConfig
public class GoodsServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求数据
        String op = request.getParameter("op");
        if("findAllGoods".equals(op)){
            // 查询全部商品信息
            findAllGoods(request, response);
        } else if("updateGoods".equals(op)){
            // 修改商品信息
            updateGoods(request, response);
        } else if("findGoodsById".equals(op)){
            // 根据商品编号查询商品信息
            findGoodsById(request, response);
        } else if("insertGoods".equals(op)){
            // 新增商品信息
            insertGoods(request, response);
        }
    }

    /**
     * 增：新增商品信息
     * @param request
     * @param response
     */
    private void insertGoods(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GoodsTypeService gtService = new GoodsTypeServiceImpl();
        // 获取请求参数
        String gname = request.getParameter("gname");// 商品名称
        int gcount = Integer.parseInt(request.getParameter("gcount"));// 商品库存
        double gprice = Double.parseDouble(request.getParameter("gprice"));// 商品价格
        GoodsTyple gtid = gtService.findGoodsTypeById(request.getParameter("gtid"));// 类型
        int isdelete = 1;// 是否存在
        String gdepict = request.getParameter("gdepict");// 商品描述
        // 获取图片对象
        Part part = request.getPart("gimg");// 图片
        // 获取提交图片的名称
        String gimgName = part.getSubmittedFileName();
        // 给图片起一个新名字
        String newGimpName = "/" + DBUtil.getUUID().replaceAll("-","").toUpperCase() +
                gimgName.substring(gimgName.lastIndexOf("."));
        // 找到文件存储位置 获取项目运行的本地路径
        String path = this.getServletContext().getRealPath("/upload");
        // 创建一个文件路径
        File file = new File(path);
        if(!file.exists()){
            // 当文件夹不存在的时候创建文件夹
            file.mkdir();
        }
        // 利用 part 接口进行文件上传
        part.write(path + newGimpName);
        // 创建一个商品对象，用于存储商品信息
        Goods goods = new Goods();
        goods.setGname(gname);
        goods.setGcount(gcount);
        goods.setGprice(gprice);
        goods.setGtid(gtid);
        goods.setIsdelete(isdelete);
        goods.setGdepict(gdepict);
        goods.setGimg("/upload"+newGimpName);
        String result = goodsService.insertGoods(goods);
        // 重定向页面
        response.sendRedirect(request.getContextPath()+"/backstageGoods?op=findAllGoods");
    }

    /**
     * 查询：根据商品编号查询商品信息
     * @param request
     * @param response
     */
    private void findGoodsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求数据
        String gid = request.getParameter("gid");
        // 查询商品信息
        Goods goods = goodsService.findGoodsById(gid);
        // 将查询到的结果存储到请求属性中
        request.setAttribute("goods",goods);
        // 请求转发
        request.getRequestDispatcher("/backstage/goods/goodsUpdate.jsp").forward(request, response);
    }

    /**
     * 修改：修改商品信息
     * @param request
     * @param response
     */
    private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GoodsTypeService gtService = new GoodsTypeServiceImpl();
        // 获取请求参数
        String UUID = request.getParameter("UUID");// UUID
        String gid = request.getParameter("gid");// 商品编号
        String gname = request.getParameter("gname");// 商品名称
        int gcount = Integer.parseInt(request.getParameter("gcount"));// 商品库存
        double gprice = Double.parseDouble(request.getParameter("gprice"));// 商品价格
        GoodsTyple gtid = gtService.findGoodsTypeById(request.getParameter("gtid"));
        int isdelete = Integer.parseInt(request.getParameter("isdelete"));
        String gdepict = request.getParameter("gdepict");
        // 获取图片对象
        Part part = request.getPart("gimg");
        // 获取提交图片的名称
        String gimgName = part.getSubmittedFileName();
        // 给图片起一个新名字
        String newGimpName = "/" + DBUtil.getUUID().replaceAll("-","").toUpperCase() +
                gimgName.substring(gimgName.lastIndexOf("."));
        // 找到文件存储位置 获取项目运行的本地路径
        String path = this.getServletContext().getRealPath("/upload");
        // 创建一个文件路径
        File file = new File(path);
        if(!file.exists()){
            // 当文件夹不存在的时候创建文件夹
            file.mkdir();
        }
        // 利用 part 接口进行文件上传
        part.write(path + newGimpName);
        // 创建一个商品对象，用于存储商品信息
        Goods goods = new Goods();
        goods.setUUID(UUID);
        goods.setGid(gid);
        goods.setGname(gname);
        goods.setGcount(gcount);
        goods.setGprice(gprice);
        goods.setGtid(gtid);
        goods.setIsdelete(isdelete);
        goods.setGdepict(gdepict);
        goods.setGimg("/upload"+newGimpName);
        String result = goodsService.updateGoodsById(goods);
        // 重定向页面
        response.sendRedirect(request.getContextPath()+"/backstageGoods?op=findAllGoods");
    }

    /**
     * 查询：查询全部商品信息
     * @param request
     * @param response
     */
    private void findAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String gname = request.getParameter("gname");
        String pageCount = request.getParameter("pageCount");
        // 将 gname 存储到会话当中
        request.getSession().setAttribute("findInfo",gname);
        String findInfo =(String) request.getSession().getAttribute("findInfo");
        if(pageCount == null){
            pageCount = "1";
        }
        if(findInfo == null){
            findInfo = "";
        }
        // 分页查询商品信息
        Page<Goods> goods = goodsService.findGoodsLikeByGname(findInfo, Integer.parseInt(pageCount), 5);
        // 将查询到的数据存储到请求属性中
        request.setAttribute("goods",goods);
        // 请求转发
        request.getRequestDispatcher("/backstage/goods/goodsInfoShow.jsp").forward(request, response);
    }
}
