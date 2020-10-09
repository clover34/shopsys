<%--
  Created by IntelliJ IDEA.
  User: 31773
  Date: 2020/10/6
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小米账号—注册</title>
    <style type="text/css">
        .container{
            background:#F9F9F9;
        }
        .row{
            margin-top:50px;
        }
        #head{
            width:800px;
            height:550px;
            background:#ffffff;
        }
        #foot{
            height:70px;
        }
        #foot ul{
            list-style:none;
        }
        #foot ul{

        }
        #foot ul li{
            float: left;
            margin-left:20px;
            color:#9D9D9D;
            font-size:15px;
        }
        #foot ul li:hover{
            color:black;
        }
        #foot p{
            font-size:15px;
            color:#9D9D9D;
        }
        .input-group{
            float: left;
            margin-left:50px;
            margin-top:20px;
        }
        #btu{
            width:300px;
            height:50px;
            background:#FF6B00;
            margin-left:200px;
            margin-top:20px;
        }
        #myForm h1{
            float: left;
            margin-left:250px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script src="<%=application.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script src="<%=application.getContextPath()%>/js/bootstrap.js"></script>
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
<div class="container">
    <div class="row head">
        <div id="head" class="col-lg-8 col-lg-offset-2">
            <form id="myForm"action="<%=application.getContextPath()%>/user?op=addUser" method="post">
                <img src="img/127.png"><br>
                <h1>注册小米账号</h1>
                <%--用户名--%>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <input type="text"name="username" id="username"onblur="testUsername()" placeholder="请输入用户名"class="form-control"aria-describedby="basic-addon1">
                    <span id="p2"style="color:red;">${info}</span>
                </div>
                <%--密码--%>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                    <input type="password"name="password"id="password"onblur="testUsername1()" placeholder="请输入密码"class="form-control"aria-describedby="basic-addon1">
                    <span id="p1"style="color:red;"></span>
                </div>
                <%--确认密码--%>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon3">
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                    <input type="password"name="password"id="passwordtwo"onblur="testUsername2()" placeholder="请确认密码"class="form-control"aria-describedby="basic-addon1">
                    <span id="p3"style="color:red;"></span>
                </div>
                <%--手机号--%>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon4">
                        <span class="glyphicon glyphicon-phone"></span>
                    </span>
                    <input type="text" name="phone"id="phone" onblur="testUsername3()"placeholder="请输入手机号"class="form-control"aria-describedby="basic-addon1">
                    <span id="p4"style="color:red;"></span>
                </div>
                <%--邮箱--%>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon5">
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                    <input type="email" name="email"id="email" onblur="testUsername4()" placeholder="请输入邮箱地址"class="form-control"aria-describedby="basic-addon1">
                    <span id="p5"style="color:red;"></span>
                </div>
                <button type="submit" id="btu" value="注册">注册</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div id="foot"class="col-lg-7 col-lg-offset-3">
            <ul>
                <li>简体</li>
                <li>|</li>
                <li>繁体</li>
                <li>|</li>
                <li>English</li>
                <li>|</li>
                <li>常见问题</li>
            </ul><br>
            <p>小米公司版权所有-京ICP备10046444-京公网安备11010802020134号-京ICP证110507号</p>
        </div>
    </div>
</div>
</body>
</html>
