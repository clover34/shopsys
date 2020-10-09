<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/10/7
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>订单编号</th>
            <th>商品名称</th>
            <th>购买数量</th>
            <th>商品单价</th>
            <th>商品总价</th>
            <th>订单创建时间</th>
        </tr>
        <c:forEach items="${allOrders.data}" var="ord">
            <td>${ord.oid}</td>
            <td>${ord.gname}</td>
            <td>${ord.odnum}</td>
            <td>${ord.gprice}</td>
            <td>${ord.odtotal}</td>
            <td>${ord.createdate}</td>
        </c:forEach>
        <%--页面操作--%>
        <tr class="text-center">
            <td colspan="6">

                <a href="<%=request.getContextPath()%>/orders?op=orderPage&pageNum=1" class="btn btn-default">首页</a>
                <a href="<%=request.getContextPath()%>/orders?op=orderPage&pageNum=${orderPage.prevPage}"
                   class="btn btn-default">上一页</a>
                当前页${orderPage.currentPage}/${orderPage.totalPage}
                <a href="<%=request.getContextPath()%>/orders?op=orderPage&pageNum=${orderPage.nextPage}"
                   class="btn btn-default">下一页</a>
                <a href="<%=request.getContextPath()%>/orders?op=orderPage&pageNum=${orderPage.totalPage}"
                   class="btn btn-default">尾页</a>

            </td>
        </tr>
    </table>
</div>
</body>
</html>
