<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/07
  Time: 13:37
  To change this tuserlate use File | Settings | File Tuserlates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品信息</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function(){
            $("#open_servlet").click(function(){
                var gname = $("#gname").val();
                window.location.href = "backstageGoods?op=findAllGoods&gname="+gname;
            })
        })
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row" style="padding: 25px 0;">
                <div class="col-md-3 col-md-offset-8" style="padding-left:100px;">
                    <input type="text" value="${sessionScope.findInfo}" class="form-control" id="gname" name="gname" placeholder="商品名称" style="width: 240px;">
                </div>
                <div class="col-md-1">
                    <button type="button" id="open_servlet" class="btn btn-primary btn-md" style="width: 80px">搜索</button>
                </div>
            </div>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>图片</th>
                    <th>库存</th>
                    <th>价格</th>
                    <th>类型</th>
                    <th>0下架/1未下架</th>
                    <th>商品描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="g" items="${requestScope.goods.data}">
                    <tr>
                        <td>${g.gid}</td>
                        <td>${g.gname}</td>
                        <td><img src="<%=request.getContextPath()%>/${g.gimg}" style="width: 120px;height: 34px"></td>
                        <td>${g.gcount}</td>
                        <td>${g.gprice}</td>
                        <td>${g.gtid.gtname}</td>
                        <td>${g.isdelete}</td>
                        <td>${g.gdepict}</td>
                        <td><a href="<%=request.getContextPath()%>/backstageGoods?op=findGoodsById&gid=${g.gid}">修改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="width:100%;position: fixed;bottom: 130px" class="row text-center" >
                <ul class="pagination" style="margin: 0 auto">
                    <c:if test="${goods.currentPage == 1}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=1&gname=${sessionScope.findInfo}">首页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${goods.prevPage}&gname=${sessionScope.findInfo}">上一页</a></li>
                    </c:if>
                    <c:if test="${goods.currentPage != 1}">
                        <li><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=1&gname=${sessionScope.findInfo}">首页</a></li>
                        <li><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${goods.prevPage}&gname=${sessionScope.findInfo}">上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${goods.totalPage}" varStatus="i" >
                        <c:if test="${goods.currentPage == i.index}">
                            <li class="active"><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${i.index}&gname=${sessionScope.findInfo}">${i.index}</a></li>
                        </c:if>
                        <c:if test="${goods.currentPage != i.index}">
                            <li><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${i.index}&gname=${sessionScope.findInfo}">${i.index}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${goods.currentPage == goods.totalPage}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${goods.nextPage}&gname=${sessionScope.findInfo}">下一页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${goods.totalPage}&gname=${sessionScope.findInfo}">尾页</a></li>
                    </c:if>
                    <c:if test="${goods.currentPage != goods.totalPage}">
                        <li><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${goods.nextPage}&gname=${sessionScope.findInfo}">下一页</a></li>
                        <li><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods&pageCount=${goods.totalPage}&gname=${sessionScope.findInfo}">尾页</a></li>
                    </c:if>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">页数：${goods.currentPage}/${goods.totalPage}</li>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">记录数：${goods.totalCount}条</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
