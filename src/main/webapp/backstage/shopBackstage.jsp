<%@ page import="java.net.Authenticator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/06
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>
        后台管理
    </title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
<%--    导入 jq js文件--%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
<%--    导入 layui 样式表 --%>
    <link type="text/css" href="<%=request.getContextPath()%>/layui/css/layui.css" rel="stylesheet">
<%--    导入 layui js样式表--%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">商城系统后台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
<%--        <ul class="layui-nav layui-layout-left">--%>
<%--            <li class="layui-nav-item"><a href="">控制台</a></li>--%>
<%--            <li class="layui-nav-item"><a href="">商品管理</a></li>--%>
<%--            <li class="layui-nav-item"><a href="">用户</a></li>--%>
<%--            <li class="layui-nav-item">--%>
<%--                <a href="javascript:;">其它系统</a>--%>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">邮件管理</a></dd>--%>
<%--                    <dd><a href="">消息管理</a></dd>--%>
<%--                    <dd><a href="">授权管理</a></dd>--%>
<%--                </dl>--%>
<%--            </li>--%>
<%--        </ul>--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${sessionScope.emp.empname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/emp?op=logOut">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">员工管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/emp?op=findAllEmp" target="myiframe">员工信息</a></dd>
                        <dd><a href="<%=request.getContextPath()%>/backstage/empInsert.jsp" target="myiframe">新增员工</a></dd>
<%--                        <dd><a href="javascript:;">列表三</a></dd>--%>
<%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/backstageUser?op=findAlluser" target="myiframe">用户信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/backstageGoods?op=findAllGoods" target="myiframe">商品信息</a></dd>
                        <dd><a href="<%=request.getContextPath()%>/backstage/goods/goodsInsert.jsp" target="myiframe">新增商品</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder" target="myiframe">查看订单</a></dd>
                    </dl>
                </li>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:void(0)">解决方案</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">列表一</a></dd>--%>
<%--                        <dd><a href="javascript:;">列表二</a></dd>--%>
<%--                        <dd><a href="">超链接</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item"><a href="">云市场</a></li>--%>
<%--                <li class="layui-nav-item"><a href="">发布商品</a></li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="height: 100%;width: 88%;">
        <!-- 内容主体区域 -->
        <iframe name="myiframe" width="100%" height="100%" scrolling="no"></iframe>
    </div>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;
        });
    </script>
</div>
</body>
</html>
