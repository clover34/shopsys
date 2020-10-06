<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/06
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小米账号 - 登录</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <!-- 引入 bootstrap 样式表 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <!-- 引入小米登录页面样式表 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css"/>
    <!-- 引入 bootstrap 脚本 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 jQuery 脚本 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function(){
            $(".login_body_techweb_left").click(function(){
                $(".qrcode").hide();
                $(".account_login").show();
                $(this).attr("style","color: #FF6700");
                $(".login_body_techweb_right").attr("style","color: #666")
            })
            $(".login_body_techweb_right").click(function(){
                $(".account_login").hide();
                $(".qrcode").show();
                $(this).attr("style","color: #FF6700");
                $(".login_body_techweb_left").attr("style","color: #666")
            })
        });
    </script>
</head>
<body>
<div class="container">
    <!-- 登录头部图片 -->
    <div class="row">
        <div class="col-md-12 login_head">
            <a href="javascript:"><img src="img/127.png" ></a>
        </div>
    </div>
</div>

<div class="container-fluid login_body">
    <!-- 登录主体信息 -->
    <div class="container">
        <div class="row">
            <div class="col-md-12 ">
                <div class="row">
                    <!-- 用户登录界面 占4移8 -->
                    <div class="col-md-4 col-md-offset-8 login_body_techweb">
                        <div class="row">
                            <!-- 点击：用户名密码登录 -->
                            <div class="col-md-5 login_body_techweb_left">
                                账号登录
                            </div>
                            <!-- 中间竖线 -->
                            <div class="col-md-2 login_body_techweb_middle">
                                |
                            </div>
                            <!-- 点击：扫码登录 -->
                            <div class="col-md-5 login_body_techweb_right">
                                扫码登录
                            </div>
                        </div>

                        <!-- 账号密码登录显示隐藏框 -->
                        <div class="row account_login">
                            <!-- 用户名 -->
                            <div class="col-md-12 account_login_div_username">
                                <input type="text" id="username" value="" placeholder="邮箱/手机号码/小米ID"/>
                                <span style="display: inline-block;" id="username_span"></span>
                            </div>
                            <!-- 密码 -->
                            <div class="col-md-12 account_login_div_password">
                                <input type="text" id="password" value="" placeholder="密码" />
                                <span style="display: inline-block;" id="password_span"></span>
                            </div>
                            <!-- 登录按钮 -->
                            <div class="col-md-12 account_login_div_button">
                                <button type="button" id="login_btn">登录</button>
                            </div>
                            <!-- 手机短信登录/注册 -->
                            <div class="col-md-12 account_login_div_phoneLogin text-center">
                                <a href="javascript:" id="phone_login">手机短信登录/注册</a>
                            </div>
                            <!-- 立即注册/忘记密码？ -->
                            <div class="col-md-12 account_login_div_register text-center">
                                <a href="javascript:">&emsp;立即注册</a>
                                <span>|</span>
                                <a href="javascript:">忘记密码？</a>
                            </div>
                            <div class="col-md-12 text-center" style="margin-top: 160px;">
                                <img src="img/130.png" style="height: 40px;cursor: pointer;">
                            </div>
                        </div>

                        <!-- 扫码登录显示隐藏块 -->
                        <div class="row qrcode">
                            <div class="col-md-12 text-center" style="margin-bottom: 15px;">
                                <img src="img/131.png" style="width: 150px;height: 150px;" >
                            </div>
                            <div class="col-lg-12 text-center" style="margin-bottom: 5px;">
                                使用<span style="padding: 0 3px;color: #FF6700;">小米商城APP</span>扫一扫
                            </div>
                            <div class="col-md-12 text-center">
                                小米手机可打开「设置」>「小米帐号」扫码登录
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row login_botton" style="height: 200px;">
        <div class="col-md-12 login_botton_top">
            <ul>
                <li style="color: #000000;">简体</li>
                <li>|</li>
                <li>繁体</li>
                <li>|</li>
                <li>English</li>
                <li>|</li>
                <li>常见问题</li>
                <li>|</li>
                <li>隐私政策</li>
            </ul>
        </div>
        <div class="col-md-12 text-center login_botton_top_botton">
            <span>小米公司版权所有-京ICP备10046444-</span>
            <img src="img/129.png" >
            <span>京公网安备11010802020134号-京ICP证110507号</span>
        </div>
    </div>
</div>
</body>
</html>
