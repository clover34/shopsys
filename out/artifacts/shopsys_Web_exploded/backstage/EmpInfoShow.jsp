<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/07
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工信息</title>
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
                var empname = $("#empname").val();
                window.location.href = "emp?op=findAllEmp&empname="+empname;
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
                    <input type="text" value="${sessionScope.findInfo}" class="form-control" id="empname" name="empname" placeholder="请输入姓名" style="width: 275px">
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
                    <th>账号</th>
                    <th>1在职/0离职</th>
                    <th>职位</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="emp" items="${requestScope.emps.data}">
                    <tr>
                        <td>${emp.empid}</td>
                        <td>${emp.empname}</td>
                        <td>${emp.empaccount}</td>
                        <td>${emp.dimission}</td>
                        <td>${emp.etid.etname}</td>
                        <td><a href="<%=request.getContextPath()%>/emp?op=empDetails&empid=${emp.empid}">详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="width:100%;position: fixed;bottom: 300px" class="row text-center" >
                <ul class="pagination" style="margin: 0 auto">
                    <c:if test="${emps.currentPage == 1}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=1&empname=${sessionScope.findInfo}">首页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${emps.prevPage}&empname=${sessionScope.findInfo}">上一页</a></li>
                    </c:if>
                    <c:if test="${emps.currentPage != 1}">
                        <li><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=1&empname=${sessionScope.findInfo}">首页</a></li>
                        <li><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${emps.prevPage}&empname=${sessionScope.findInfo}">上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${emps.totalPage}" varStatus="i" >
                        <c:if test="${emps.currentPage == i.index}">
                            <li class="active"><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${i.index}&empname=${sessionScope.findInfo}">${i.index}</a></li>
                        </c:if>
                        <c:if test="${emps.currentPage != i.index}">
                            <li><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${i.index}&empname=${sessionScope.findInfo}">${i.index}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${emps.currentPage == emps.totalPage}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${emps.nextPage}&empname=${sessionScope.findInfo}">下一页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${emps.totalPage}&empname=${sessionScope.findInfo}">尾页</a></li>
                    </c:if>
                    <c:if test="${emps.currentPage != emps.totalPage}">
                        <li><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${emps.nextPage}&empname=${sessionScope.findInfo}">下一页</a></li>
                        <li><a href="<%=request.getContextPath()%>/emp?op=findAllEmp&pageCount=${emps.totalPage}&empname=${sessionScope.findInfo}">尾页</a></li>
                    </c:if>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">页数：${emps.currentPage}/${emps.totalPage}</li>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">记录数：${emps.totalCount}条</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
