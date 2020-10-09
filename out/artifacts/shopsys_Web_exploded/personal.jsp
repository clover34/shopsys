<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        个人中心
    </title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8">
    </script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8">
    </script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/personal.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/zzsc.css"/>
    <script type="text/javascript">
        $(function() {
            // 小米logo鼠标移入移出效果
            $("#logo_transform").hover(function () {
                $("#img_content").animate({
                    left: -55 + "px",
                }, 200);
            }, function () {
                $("#img_content").animate({
                    left: 0 + "px"
                }, 200);
            });
            // 小米搜索框鼠标移入移出
            $(".xm_head_right_search_div").hover(function () {
                $(".search_input").css("border-color", "#bebebe");
                $(".search_span").css("border-left", "none");
                $(".search_span").css("border-color", "#bebebe");
            }, function () {
                $(".search_input").css("border", "1px solid #e0e0e0");
                $(".search_span").css("border", "1px solid #e0e0e0");
            });
            // 小米搜索框点击事件
            $(".xm_head_right_search_div").click(function () {
                $(".search_input").css("border-color", "#FF6B00");
                $(".search_span").css("border-color", "#FF6B00");
            });

            //显示隐藏头部菜单栏商品信息
            $(".showMenu").hover(function () {
                $(".showGoodsList").stop(true, false).slideDown();
            }, function () {
                $(".showGoodsList").stop(true, false).slideUp();
            });
            $(".showGoodsList").hover(function () {
                $(this).stop(true, false).slideDown();
            }, function () {
                $(this).stop(true, false).slideUp();
            });
            // 头部菜单显示隐藏更换商品信息
            var type;
            $(".showMenu").mouseover(function () {
                type = $(this).attr("value");
                $(".showGoodsList").children("ul").html("");//先清空菜单div
                showGoods(type);
            });
            function showGoods(type) {
                //读取JSON文件内容 索引0开始
                $.getJSON("JSONFile/showGoodsList.json", function (data) {
                    $.each(data, function (i, goods) {
                        // console.log(goods.type === type);
                        if (goods.type === type) {
                            var li = "<li><a href='javascript'><img class='showGoodsList_img' src='" +
                                goods.img + "' ><div class='showGoodsList_title'>" + goods.name +
                                "</div><p class='showGoodsList_price'>" + goods.price + "</p></a></li>"
                            var li_wire = "<li style='padding: 35px 0 0 0;width: 1px;'>" +
                                "<div class='showGoodsList_wire'></div></li>";
                            $(".showGoodsList").children("ul").append(li);
                            $(".showGoodsList").children("ul").append(li_wire);
                        }
                    })
                });
            }
        });
    </script>
</head>
<body>
<div class="fixed_div">
    <ul>
        <li>
            <a class="fixed_div_a" href="javascript:">
                <img class="fixed_div_img" src="img/121.png" ></a>手机APP</li>
        <li>
            <a class="fixed_div_a" href="javascript:">
                <img class="fixed_div_img" src="img/122.png" ></a>个人中心</li>
        <li>
            <a class="fixed_div_a" href="javascript:">
                <img class="fixed_div_img" src="img/123.png" ></a>售后</li>
        <li>
            <a class="fixed_div_a" href="javascript:">
                <img class="fixed_div_img" src="img/124.png" ></a>人工客服</li>
        <li>
            <a class="fixed_div_a" href="javascript:">
                <img class="fixed_div_img" src="img/125.png" ></a>购物车</li>
    </ul>
</div>
<!-- 小米页面头部背景 -->
<div class="container-fluid">
    <div class="row">
        <a href="javascript:" class="link_block" style="background-image: url(img/小米头部背景.jpg);"></a>
    </div>
</div>
<div style="height: 120px;"></div>
<div class="xm_nav">
    <!-- 小米头部导航栏 -->
    <div class="container">
        <div class="xm_nav_content">
            <!-- 导航栏左边内容 -->
            <div class="xm_nav_left row col-md-9 hidden-sm hidden-xs">
                <ul>
                    <li><a href="javascript:">小米商城</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">MIUI</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">IoT</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">云服务</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">金融</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">有品</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">小爱开放平台</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">企业团购</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">资质证照</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">协议规则</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">下载app</a><span class="xm_nav_span">|</span></li>
                    <li><a href="javascript:">智能生活</a>
                        <!-- <span class="xm_nav_span">|</span></li> -->
                        <!-- <li><a href="javascript:">Select&nbsp;Location</a></li> -->
                </ul>
            </div>
            <!-- 导航栏右边内容 -->
            <div class="xm_nav_right col-lg-3 col-md-3 hidden-sm hidden-xs">
                <div class="row">
                    <div class="col-md-9 col-md-offset-3 colminwidth">
                        <ul>
                            <li><a href="javascript:">${user.username}</a><span class="xm_nav_span">|</span></li>
<%--                            <li><a href="javascript:">注册</a><span class="xm_nav_span">|</span></li>--%>
                            <li><a href="javascript:">消息通知</a></li>
                            <li class="xm_nav_right_li_cart">
                                <a href="javascript:">
                                    <span class="glyphicon glyphicon-shopping-cart cart"></span>购物车(0)
                                </a>
                                <ul>
                                    <li class="hide_cart">购物车中还没有商品，赶紧选购吧！</li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 响应式不去logo菜单 -->
            <div class="show_menulogo row hidden-lg hidden-md col-sm-12 col-xs-12">
                <div class="col-sm-12 col-xs-12 dropdown_menu">
                    <ul>
                        <li><a href="javascript:">
                            <span class="glyphicon glyphicon-menu-hamburger" style="color: white;font-size: 20px;line-height: 40px;">
                            </span></a>
                            <ul>
                                <li class="dropdown_menu_li"><a href="javascript:">小米商城</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">MIUI</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">IoT</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">云服务</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">金融</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">有品</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">小爱开放平台</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">企业团购</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">资质证照</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">协议规则</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">下载app</a></li>
                                <li class="dropdown_menu_li"><a href="javascript:">智能生活</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- 中间部分 -->
<div class="container">
    <!-- 小米头部 -->
    <div class="row xm_head hidden-sm hidden-xs">
        <!-- 小米头部左边 -->
        <div class="xm_head_left col-md-9 ">
            <!-- 小米头部左边内容的logo -->
            <div class="row xm_head_left_logo col-md-3 ">
                <div id="logo_transform" class="col-lg-4">
                    <div id="img_content">
                        <ul>
                            <li style="float: left;">
                                <a href="javascript:"><img src="<%=request.getContextPath()%>/img/6.png">
                                </a>
                            </li>
                            <li><a href="javascript:"><img src="img/7mi-home.png"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 小米头部左边内容的菜单 -->
            <div class="row xm_head_left_menu col-md-9">
                <ul>
                    <li><a href="javascript" id="xmsj" class="showMenu" value="xmsj">小米手机</a>
                    </li>
                    <li><a href="javascript" class="showMenu" value="hm">Redmi红米</a></li>
                    <li><a href="javascript" class="showMenu" value="ds">电视</a></li>
                    <li><a href="javascript" class="showMenu" value="bjb">笔记本</a></li>
                    <li><a href="javascript" class="showMenu" value="jd">家电</a></li>
                    <li><a href="javascript" class="showMenu" value="lyq">路由器</a></li>
                    <li><a href="javascript" class="showMenu" value="znyj">智能硬件</a></li>
                    <li><a href="javascript">服务</a></li>
                    <li><a href="javascript">社区</a></li>
                    <div class="showGoodsList">
                        <ul>

                        </ul>
                    </div>
                </ul>
            </div>
        </div>
        <!-- 小米右边搜索框 -->
        <div class="xm_head_right_search col-md-3 ">
            <div class="row">
                <div class="col-lg-12 xm_head_right_search_div" style="padding-top:25px ">
                    <input type="text" class="search_input" placeholder="小米10" />
                    <span class="glyphicon glyphicon-search search_span"></span>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="div"class="row">
    <div class="col-md-10 col-md-offset-1"><h4>首页/个人中心</h4></div>
    <div class="col-md-10 col-md-offset-1 row div1">
        <div class="col-md-2 div12">
            <ul>
                <li><strong>订单中心</strong></li>
                <li><a href="<%=application.getContextPath()%>/orders?op=allOrders"  target="myiframe">我的订单</a></li>
                <li><strong>账户管理</strong></li>
                <li><a href="<%=application.getContextPath()%>/address?op=allAddressInfo"  target="myiframe">收货地址</a></li>
                <li><a href="<%=application.getContextPath()%>/personal?op=findUser"    target="myiframe">个人信息</a></li>
                <li><a href="<%=application.getContextPath()%>/personal?op=User"    target="myiframe">修改个人信息</a></li>
            </ul>
        </div>
        <div class="col-md-10 div13">
            <iframe id="myiframe" name="myiframe" width="100%" height="100%">

            </iframe>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12 bottom_1">
            <ul>
                <li><a href="javascript:" class="bottom_1_a">预约服务</a></li>
                <li><a href="javascript:" class="bottom_1_a">七天无理由退货</a></li>
                <li></span><a href="javascript:" class="bottom_1_a">15天免费换货</a></li>
                <li></span><a href="javascript:" class="bottom_1_a">满99包邮</a></li>
                <li></span><a href="javascript:" class="bottom_1_a">520余家售后网点</a></li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-9 bottom_2">
            <div class="bottom_2_1" style="margin-left: 0;">
                <ul>
                    <li>帮助中心</li>
                    <li>服务售后</li>
                    <li>自助服务</li>
                    <li>相关下载</li>
                </ul>
            </div>
            <div class="bottom_2_1">
                <ul>
                    <li>服务支持</li>
                    <li>自助服务</li>
                    <li>相关下载</li>
                    <li>售后服务</li>
                </ul>
            </div>
            <div class="bottom_2_1">
                <ul>
                    <li>线下门店</li>
                    <li>小米之家</li>
                    <li>服务网点</li>
                    <li>授权体验店</li>
                </ul>
            </div>
            <div class="bottom_2_1">
                <ul>
                    <li>关于小米</li>
                    <li>加入小米</li>
                    <li>了解小米</li>
                    <li>投资者关系</li>
                    <li>企业社会责任</li>
                    <li>廉洁举报</li>
                </ul>
            </div>
            <div class="bottom_2_1">
                <ul>
                    <li>关注我们</li>
                    <li>新浪微博</li>
                    <li>官网微信</li>
                    <li>联系我们</li>
                    <li>公益基金会</li>
                </ul>
            </div>
        </div>
        <div class="col-md-3 bottom_3">
            <div class="ctrl">

            </div>
            <div class="">
                <img src="<%=request.getContextPath()%>/img/120.png" >
            </div>
        </div>
    </div>
</div>
<div class="" style="height: 100px;">

</div>
</body>
</html>
