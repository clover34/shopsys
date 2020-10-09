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
    <title>用户信息</title>
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
                var username = $("#username").val();
                window.location.href = "backstageUser?op=findAlluser&username="+username;
            })
        })
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row" style="padding: 25px 0;">
                <div class="col-md-3 col-md-offset-8">
                    <input type="text" value="${sessionScope.findInfo}" class="form-control" id="username" name="username" placeholder="请输入姓名" style="width: 275px">
                </div>
                <div class="col-md-1">
                    <button type="button" id="open_servlet" class="btn btn-primary btn-md" style="margin-left: -50px;width: 130px">搜索</button>
                </div>
            </div>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>联系方式</th>
                    <th>邮箱</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${requestScope.users.data}">
                    <tr>
                        <td>${user.uid}</td>
                        <td>${user.username}</td>
                        <td>${user.phone}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="width:100%;position: fixed;bottom: 130px" class="row text-center" >
                <ul class="pagination" style="margin: 0 auto">
                    <c:if test="${users.currentPage == 1}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=1&username=${sessionScope.findInfo}">首页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${users.prevPage}&username=${sessionScope.findInfo}">上一页</a></li>
                    </c:if>
                    <c:if test="${users.currentPage != 1}">
                        <li><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=1&username=${sessionScope.findInfo}">首页</a></li>
                        <li><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${users.prevPage}&username=${sessionScope.findInfo}">上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${users.totalPage}" varStatus="i" >
                        <c:if test="${users.currentPage == i.index}">
                            <li class="active"><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${i.index}&username=${sessionScope.findInfo}">${i.index}</a></li>
                        </c:if>
                        <c:if test="${users.currentPage != i.index}">
                            <li><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${i.index}&username=${sessionScope.findInfo}">${i.index}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${users.currentPage == users.totalPage}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${users.nextPage}&username=${sessionScope.findInfo}">下一页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${users.totalPage}&username=${sessionScope.findInfo}">尾页</a></li>
                    </c:if>
                    <c:if test="${users.currentPage != users.totalPage}">
                        <li><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${users.nextPage}&username=${sessionScope.findInfo}">下一页</a></li>
                        <li><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser&pageCount=${users.totalPage}&username=${sessionScope.findInfo}">尾页</a></li>
                    </c:if>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">页数：${users.currentPage}/${users.totalPage}</li>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">记录数：${users.totalCount}条</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
