<%--
  Created by IntelliJ IDEA.
  User: 31773
  Date: 2020/10/8
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script src="<%=application.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script src="<%=application.getContextPath()%>/js/bootstrap.js"></script>
    <style type="text/css">
        .row{
            margin-top:50px;
        }
        #head{
            width:800px;
            height:550px;
            background:#ffffff;
        }
        .input-group{
            float: left;
            margin-left:50px;
            margin-top:30px;
        }
    </style>
</head>
<body>
<div class="row head">
    <div id="head" class="col-lg-8 col-lg-offset-2">
        <form id="myForm">
            <%--用户编号--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon">
                        用户编号
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                <input type="text "readonly="readonly" name="uid"id="uid"placeholder="${user.uid}"class="form-control"aria-describedby="basic-addon1">
            </div>
            <%--用户名--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">用户名
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                <input type="text"readonly="readonly"name="username" id="username"placeholder="${user.username}"class="form-control"aria-describedby="basic-addon1">
                <span id="p2"style="color:red;"></span>
            </div>
            <%--密码--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">密码
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                <input type="password"readonly="readonly"name="password"id="password"placeholder="${user.password}" class="form-control"aria-describedby="basic-addon1">
                <span id="p1"style="color:red;"></span>
            </div>
            <%--手机号--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon4">手机号
                        <span class="glyphicon glyphicon-phone"></span>
                    </span>
                <input type="text"readonly="readonly"name="phone"id="phone"placeholder="${user.phone}"class="form-control"aria-describedby="basic-addon1">
                <span id="p4"style="color:red;"></span>
            </div>
            <%--邮箱--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon5">邮箱地址
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                <input type="email"readonly="readonly"name="email"id="email"placeholder="${user.email}"class="form-control"aria-describedby="basic-addon1">
                <span id="p5"style="color:red;"></span>
            </div>
        </form>
    </div>
</div>
</body>
</html>
