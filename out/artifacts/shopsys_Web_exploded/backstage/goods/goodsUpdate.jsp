<%@ page import="com.etc.shopsys.service.EmpTypeService" %>
<%@ page import="com.etc.shopsys.domain.EmpType" %>
<%@ page import="java.util.List" %>
<%@ page import="com.etc.shopsys.service.impl.EmpTypeServiceImpl" %>
<%@ page import="com.etc.shopsys.service.GoodsTypeService" %>
<%@ page import="com.etc.shopsys.service.impl.GoodsTypeServiceImpl" %>
<%@ page import="com.etc.shopsys.domain.GoodsTyple" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/08
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $("#gcount").blur(function(){
            var gcount = $(this);
            console.log(typeof(gcount.val()));
            if(gcount.val() < 1){
                gcount.val(1);
            }
        })
    </script>
    <%
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsTyple> gts = goodsTypeService.findAllGoodsType();
        request.setAttribute("gts", gts);
    %>
</head>
<body>
<div class="container" style="margin-top: 50px">
    <div class="row clearfix">
        <div class="col-md-4 column col-md-offset-4">
            <form role="form" action="<%=request.getContextPath()%>/backstageGoods?op=updateGoods" method="post" enctype="multipart/form-data">
                <%--                UUID--%>
                <input type="hidden" value="${requestScope.goods.UUID}" class="form-control" id="UUID" name="UUID" />
                <%--                商品编号--%>
                <input type="hidden" value="${requestScope.goods.gid}" class="form-control" id="gid" name="gid" />
                <%--商品名称--%>
                <div class="form-group">
                    <label for="gname">名称</label>
                    <input type="text" value="${requestScope.goods.gname}" class="form-control" id="gname" name="gname" />
                </div>
                <%--图片--%>
                <div class="form-group">
                    <img src="<%=request.getContextPath()%>${requestScope.goods.gimg}" alt="..." class="img-rounded" style="height: 25px;">
                    <label for="gimg">图片</label>
                    <input type="file" src="<%=request.getContextPath()%>${requestScope.goods.gimg}" class="form-control" id="gimg" name="gimg" multiple/>
                </div>
                <%--    商品库存--%>
                <div class="form-group">
                    <label for="gcount">库存</label>
                    <input type="number" value="${requestScope.goods.gcount}" class="form-control" id="gcount" name="gcount" />
                </div>
                <%--    价格--%>
                <div class="form-group">
                    <label for="gprice">价格</label>
                    <input type="number" value="${requestScope.goods.gprice}" class="form-control" id="gprice" name="gprice" />
                </div>
                <%--商品是否删除 ${requestScope.goods.isdelete}--%>
                <div class="form-group">
                    <label for="isdelete">0下架/1在售</label>
                    <select class="form-control" id="isdelete" name="isdelete">
                        <c:if test="${requestScope.goods.isdelete == 1}">
                            <option value="1" selected="selected">在售</option>
                            <option value="0">已下架</option>
                        </c:if>
                        <c:if test="${requestScope.goods.isdelete == 0}">
                            <option value="1">在售</option>
                            <option value="0" selected="selected">已下架</option>
                        </c:if>
                    </select>
                </div>
                <%--    商品类型--%>
                <div class="form-group">
                    <label for="gtid">类型</label>
                    <select class="form-control" id="gtid" name="gtid">
                        <c:forEach var="goodstype" items="${gts}">
                            <c:if test="${requestScope.goods.gtid.gtid == goodstype.gtid}">
                                <option value="${goodstype.gtid}" selected="selected">${goodstype.gtname}</option>
                            </c:if>
                            <c:if test="${requestScope.goods.gtid.gtid != goodstype.gtid}">
                                <option value="${goodstype.gtid}">${goodstype.gtname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <%--    商品描述--%>
                <div class="form-group">
                    <label for="gdepict">商品描述</label>
                    <textarea class="form-control" rows="2" id="gdepict" name="gdepict">${requestScope.goods.gdepict}</textarea>
                </div>
                <%--    提交按钮--%>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary col-md-12" style="margin-top: 10px">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
