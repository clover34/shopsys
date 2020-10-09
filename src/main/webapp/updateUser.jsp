<%--
  Created by IntelliJ IDEA.
  User: 31773
  Date: 2020/10/8
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
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
        #btu{
            width:300px;
            height:50px;
            background:#FF6B00;
            margin-left:200px;
            margin-top:20px;
        }
    </style>
    <script>
        function testUsername() {
            var a = document.getElementById("username").value;
            if(a == "") {
                document.getElementById("p2").innerHTML = "用户名不能为空！";
            } else {
                document.getElementById("p2").innerHTML = "";
            }
        }

        function testUsername1() {
            var b = document.getElementById("password").value;
            if(b == "") {
                document.getElementById("p1").innerHTML = "密码不能为空";
            } else {
                if(b.length >= 8 && b.length <= 16) {
                    document.getElementById("p1").innerHTML = "";
                } else {
                    document.getElementById("p1").innerHTML = "密码错误";
                }
            }
        }

        function testUsername2() {
            var c = document.getElementById("password").value;
            var d = document.getElementById("passwordtwo").value;
            if(d == "") {
                document.getElementById("p3").innerHTML = "密码不能为空！";
            } else {
                if(c == d) {
                    document.getElementById("p3").innerHTML = "";
                } else {
                    document.getElementById("p3").innerHTML = "密码错误";
                }
            }
        }
        function testUsername3() {
            var e = document.getElementById("phone").value;
            if(e == "") {
                document.getElementById("p4").innerHTML = "手机号不能为空！";
            } else {
                if(e.length == 11) {
                    document.getElementById("p4").innerHTML = "";
                } else {
                    document.getElementById("p4").innerHTML = "格式错误";
                }
            }
        }
        function testUsername4() {
            var e = document.getElementById("email").value;
            if(e == "") {
                document.getElementById("p5").innerHTML = "邮箱不能为空！";
            } else {
                document.getElementById("p5").innerHTML = "";
            }
        }
        phone.onchange=function () {
            var ph=this.value;
            var reg=/^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;
            if (reg.test(ph)){
                document.getElementById("p4").innerHTML = "";
            } else {
                document.getElementById("p4").innerHTML = "手机号格式错误！";
            }
        }
        email.onchange=function () {
            var em=this.value;
            var reg=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
            if (reg.test(em)){
                document.getElementById("p5").innerHTML = "";
            } else {
                document.getElementById("p5").innerHTML = "邮箱格式错误！";
            }
        }
    </script>
</head>
<body>
<div class="row head">
    <div id="head" class="col-lg-8 col-lg-offset-2">
        <form id="myForm"action="<%=application.getContextPath()%>/personal?op=updateUser"method="post">
            <%--用户编号--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon">
                        用户编号
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                <input type="text "readonly="readonly"name="uid"id="uid" value="${user.uid}"class="form-control"aria-describedby="basic-addon1">
            </div>
            <%--用户名--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">用户名
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                <input type="text"name="username" id="username"value="${user.username}"class="form-control"aria-describedby="basic-addon1">
                <span id="p2"style="color:red;"></span>
            </div>
            <%--密码--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">密码
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                <input type="password"name="password"id="password"value="${user.password}" class="form-control"aria-describedby="basic-addon1">
                <span id="p1"style="color:red;"></span>
            </div>
            <%--手机号--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon4">手机号
                        <span class="glyphicon glyphicon-phone"></span>
                    </span>
                <input type="text"name="phone"id="phone"value="${user.phone}"class="form-control"aria-describedby="basic-addon1">
                <span id="p4"style="color:red;"></span>
            </div>
            <%--邮箱--%>
            <div class="input-group">
                    <span class="input-group-addon" id="basic-addon5">邮箱地址
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                <input type="email"name="email"id="email"value="${user.email}"class="form-control"aria-describedby="basic-addon1">
                <span id="p5"style="color:red;"></span>
            </div>
            <button type="submit"id="btu"  value="修改">修改</button>
        </form>
        ${s}
    </div>
</div>
</body>
</html>
