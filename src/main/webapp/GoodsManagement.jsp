<%--
  Created by IntelliJ IDEA.
  User: 31773
  Date: 2020/10/6
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.etc.shopsys.domain.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.etc.shopsys" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>商品管理系统</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <style>
        table{
            margin:auto;
            text-align:center;
            border-collapse:collapse;
        }
        table,th,td{
            border:1px solid black;
        }
    </style>
    <script>
        $(function () {
            $(".delClass").click(function (event) {
                event.preventDefault();
                if (confirm("是否确认删除？")){
                    window.location.href=$(this).attr("href");
                } else {
                    alert("删除操作取消！");
                }
            });
        })
    </script>
</head>
<body>
<div>
    <%--<div>
        <div>
            <input type="search"class="form-control"placeholder="">
        </div>
        <button type="submit"class="btn btn-default">搜索</button>
    </div>--%>
    <table>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品图片</th>
            <th>商品类型</th>
            <th>商品描述</th>
            <th>商品价格</th>
            <th>商品库存</th>
            <th>商品是否删除</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${goodsPage.data}" var="g">
            <tr>
                <td>${g.gid}</td>
                <td>${g.gname}</td>
                <td>${g.gimg}</td>
                <td>${g.gtid}</td>
                <td>${g.gdepict}</td>
                <td>${g.gprice}</td>
                <td>${g.gcount}</td>
                <td>${g.isdelete}</td>
                <td>
                    <a href="<%=application.getContextPath()%>/goods?op=findById&gid=${g.gid}"><button>编辑</button></a>
                    <a class="delClass" href="<%=application.getContextPath()%>/goods?op=remove&gid=${g.gid}"><button>删除</button></a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="9" style="...">
                <a href="<%=application.getContextPath()%>/goods?op=findAll&pageNum=1">首页</a>
                <a href="<%=application.getContextPath()%>/goods?op=findAll&pageNum=${goodsPage.prevPage}">上一页</a>
                当前页${goodsPage.currentPage}/${goodsPage.totalPage}
                <a href="<%=application.getContextPath()%>/goods?op=findAll&pageNum=${goodsPage.nextPgge}">下一页</a>
                <a href="<%=application.getContextPath()%>/goods?op=findAll&pageNum=${goodsPage.totalPage}">尾页</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
