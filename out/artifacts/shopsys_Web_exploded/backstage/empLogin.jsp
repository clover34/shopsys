<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/09/17
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小米账号 - 登录</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
<%--    引入 JQuery --%>
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript"></script>
<%--    引入 bootstrap 样式表--%>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<%--引入bootstrap的js文件--%>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>

    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        #bgvideo{
            position: fixed;
            right: 0;
            bottom: 0;
            min-width: 100%;
            min-height: 100%;
            width: auto;
            height: auto;
            z-index: -100;
            /*z-index 属性设置元素的堆叠顺序。拥有更高堆叠顺序的元素总是会处于堆叠顺序较低的元素的前面。*/
            background-size: cover;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            // 用户名文本框失去焦点事件
            $("#empname").blur(function(){
                replace($(this).attr("id"));
            })
            // 密码文本框失去焦点事件
            $("#password").blur(function(){
                replace($(this).attr("id"));
            })

            // 简单封装 当文本框失去焦点的时候调用该方法；局限顶，父类的div类名要和子id名称一致
            function replace(name){
                var target = $("#"+name).val();// 被检查是否为空的目标元素
                var tagFather = $("."+name);// 父类标签
                var str1 = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputError2Status\" class=\"sr-only\">(error)</span>";
                var str2 = "<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>";
                if(target == null || target.trim().length == 0){
                    // 用户名为空
                    tagFather.removeClass("has-success has-feedback");// 删除样式
                    tagFather.children("span").remove();// 移除子标签 span
                    tagFather.addClass("has-error has-feedback");// 添加新样式 红色
                    tagFather.append(str1);// 添加 span 标签 √
                } else {
                    // 用户名不为空
                    tagFather.removeClass("has-error has-feedback");// 删除样式
                    tagFather.children("span").remove();// 移除子标签 span
                    tagFather.addClass("has-success has-feedback");// 添加新样式 绿色
                    tagFather.append(str2);// 添加 span 标签 ×
                }
            }
        })
    </script>
    <style>
        #hint{
            color: red;
            display: inline-block;
            padding: 10px 0;
        }
    </style>
</head>
<body>
<!--定义背景视频-->
<video autoplay="autoplay" muted="muted" loop="loop" id="bgvideo">
    <source src="<%=request.getContextPath()%>/videos/c.mp4" type="video/mp4">
</video>

<div class="container">
    <div class="row" style="margin-top: 100px">

    </div>
    <div class="row">
        <div class="col-lg-6 col-md-offset-3">
            <h1 class="text-center">员工登录</h1>
            <div class="row">
                <div class="col-md-12">
                    <form action="<%=request.getContextPath()%>/emplogin" method="post">
                        <div class="form-group empname">
                            <label for="empname">用户名：</label>
                            <input type="text" class="form-control" name="empname" id="empname" placeholder="请输入用户名">
                        </div>
                        <div class="form-group password">
                            <label for="password">密码：</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
                            <span id="hint">${requestScope.info}</span>
                        </div>

                        <button type="submit" id="submit" class="btn btn-primary col-md-12">登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
