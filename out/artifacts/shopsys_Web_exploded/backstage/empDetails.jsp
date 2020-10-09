<%@ page import="com.etc.shopsys.domain.EmpType" %>
<%@ page import="com.etc.shopsys.service.EmpTypeService" %>
<%@ page import="com.etc.shopsys.service.impl.EmpTypeServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/07
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工详情信息</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <%
        EmpTypeService etService = new EmpTypeServiceImpl();
        List<EmpType> ets = etService.findAllEmpType();
        request.setAttribute("ets", ets);
    %>
</head>
<body>
<div class="container" style="margin-top: 100px">
    <div class="row clearfix">
        <div class="col-md-4 column col-md-offset-4">
            <form role="form" action="<%=request.getContextPath()%>/emp?op=updateEmpByempid" method="post">
<%--                员工编号--%>
                <div class="form-group">
                    <input type="hidden" value="${requestScope.emp.empid}" class="form-control" id="empid" name="empid" />
                </div>
<%--                员工密码--%>
                <div class="form-group">
                    <input type="hidden" value="${requestScope.emp.password}" class="form-control" name="password" />
                </div>
<%--    员工姓名--%>
                <div class="form-group">
                    <label for="empname">姓名</label>
                    <input type="text" value="${requestScope.emp.empname}" class="form-control" id="empname" name="empname" />
                </div>
<%--    员工账号--%>
                <div class="form-group">
                    <label for="empaccount">账号</label>
                    <input type="text" value="${requestScope.emp.empaccount}" class="form-control" id="empaccount" name="empaccount" />
                </div>
<%--    员工是否离职--%>
                <div class="form-group">
                    <label for="dimission">是否离职</label>
                    <select class="form-control" id="dimission" name="dimission">
                        <c:if test="${requestScope.emp.dimission == 1}">
                            <option value="1" selected="selected">在职</option>
                            <option value="0">离职</option>
                        </c:if>
                        <c:if test="${requestScope.emp.dimission == 0}">
                            <option value="1">在职</option>
                            <option value="0" selected="selected">离职</option>
                        </c:if>
                    </select>
                </div>
<%--    员工职位信息--%>
                <div class="form-group">
                    <label for="etid">职位</label>
                    <select class="form-control" id="etid" name="etid">
                        <c:forEach var="et" items="${ets}">
                            <c:if test="${et.etid == requestScope.emp.etid.etid}">
                                <option value="${et.etid}" selected="selected">${et.etname}</option>
                            </c:if>
                            <c:if test="${et.etid != requestScope.emp.etid.etid}">
                                <option value="${et.etid}">${et.etname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
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
