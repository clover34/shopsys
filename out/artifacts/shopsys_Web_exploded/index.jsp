<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/06
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        小米商城 - 小米10 Pro、Redmi K30 Pro、小米MIX Alpha，小米电视官方网站
    </title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 css层叠样式表  -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/xm.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lunbo.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/zzsc.css"/>
    <script type="text/javascript">
        // 倒计时
        $(document).ready(function() {
            var oDate = new Date();
            var nowTime = oDate.getTime(); //现在的毫秒数
            oDate.setDate(oDate.getDate() + 1); // 设定截止时间为第二天
            var targetDate = new Date(oDate.toLocaleDateString());
            run(targetDate);
        });

        function run(enddate) {
            getDate(enddate);
            setInterval("getDate('" + enddate + "')", 500);
        }

        function getDate(enddate) {
            var oDate = new Date(); //获取日期对象

            var nowTime = oDate.getTime(); //现在的毫秒数
            var enddate = new Date(enddate);
            var targetTime = enddate.getTime(); // 截止时间的毫秒数
            var second = Math.floor((targetTime - nowTime) / 1000); //截止时间距离现在的秒数

            var day = Math.floor(second / 24 * 60 * 60); //整数部分代表的是天；一天有24*60*60=86400秒 ；
            second = second % 86400; //余数代表剩下的秒数；
            var hour = Math.floor(second / 3600); //整数部分代表小时；
            second %= 3600; //余数代表 剩下的秒数；
            var minute = Math.floor(second / 60);
            second %= 60;
            var spanH = $('.se-txt')[0];
            var spanM = $('.se-txt')[1];
            var spanS = $('.se-txt')[2];

            spanH.innerHTML = tow(hour);
            spanM.innerHTML = tow(minute);
            spanS.innerHTML = tow(second);
        }

        function tow(n) {
            return n >= 0 && n < 10 ? '0' + n : '' + n;
        }
        // 倒计时结束



        $(function() {
            // 小米logo鼠标移入移出效果
            $("#logo_transform").hover(function() {
                $("#img_content").animate({
                    left: -55 + "px",
                }, 200);
            }, function() {
                $("#img_content").animate({
                    left: 0 + "px"
                }, 200);
            });
            // 小米搜索框鼠标移入移出
            $(".xm_head_right_search_div").hover(function() {
                $(".search_input").css("border-color", "#bebebe");
                $(".search_span").css("border-left", "none");
                $(".search_span").css("border-color", "#bebebe");
            }, function() {
                $(".search_input").css("border", "1px solid #e0e0e0");
                $(".search_span").css("border", "1px solid #e0e0e0");
            });
            // 小米搜索框点击事件
            $(".xm_head_right_search_div").click(function() {
                $(".search_input").css("border-color", "#FF6B00");
                $(".search_span").css("border-color", "#FF6B00");
            });

            //显示隐藏头部菜单栏商品信息
            $(".showMenu").hover(function(){
                $(".showGoodsList").stop(true,false).slideDown();
            }, function() {
                $(".showGoodsList").stop(true,false).slideUp();
            });
            $(".showGoodsList").hover(function(){
                $(this).stop(true,false).slideDown();
            }, function() {
                $(this).stop(true,false).slideUp();
            });



            // 头部菜单显示隐藏更换商品信息
            var type;
            $(".showMenu").mouseover(function(){
                type = $(this).attr("value");
                $(".showGoodsList").children("ul").html("");//先清空菜单div
                showGoods(type);
            });
            function showGoods(type){
                //读取JSON文件内容 索引0开始
                $.getJSON("JSONFile/showGoodsList.json",function(data){
                    $.each(data,function(i,goods){
                        // console.log(goods.type === type);
                        if(goods.type === type){
                            var li = "<li><a href='javascript'><img class='showGoodsList_img' src='"+ goods.img +"' ><div class='showGoodsList_title'>"+ goods.name +"</div><p class='showGoodsList_price'>"+ goods.price +"</p></a></li>"
                            var li_wire = "<li style='padding: 35px 0 0 0;width: 1px;'><div class='showGoodsList_wire'></div></li>";
                            $(".showGoodsList").children("ul").append(li);
                            $(".showGoodsList").children("ul").append(li_wire);
                        }
                    })
                });
            }

            //轮播二级菜单读取JSON文件
            $.getJSON("JSONFile/carouselTwoMenu.json",function(data){
                $.each(data,function(i,goods){
                    var li = "<li class='carouselTwoMenu_li'><a class='carouselTwoMenu_a' href='javascript:'><img src='"+ goods.img +"' class='carouselTwoMenu_img'><p class='carouselTwoMenu_p'>"+ goods.name +"</p></a></li>";
                    $(".carouselTwoMenu").children("ul").append(li);
                })
            });

            // 倒计时商品切换
            // $("#logo_transform").hover(function() {
            // 	$("#img_content").animate({
            // 		left: -55 + "px",
            // 	}, 200);
            // }, function() {
            // 	$("#img_content").animate({
            // 		left: 0 + "px"
            // 	}, 200);
            // });
            // <div class="countdown_right" >
            // <div class="countdown_goods">
            $("#btn_left").click(function(){
                $(".countdown_goods").animate({
                    left:-883.5 + "px"
                },1000)
            });
            $("#btn_right").click(function(){
                $(".countdown_goods").animate({
                    left:0 + "px"
                },1000)
            });


            // <span class="jd_remen">热门</span>
            // <span class="jd_dianshiyingyin">电视影音</span>
            // 家电读取JSON切换菜单
            var home_type;
            $(".jd").mouseover(function(){
                home_type = $(this).attr("value");
                $(".home_right").children("ul").html("");//先清空菜单div
                console.log(home_type);
                showHomeGoods(home_type);
            });
            function showHomeGoods(home_type){
                //读取JSON文件内容 索引0开始
                var count = 0;
                $.getJSON("JSONFile/showHomeGoods.json",function(data){
                    $.each(data,function(i,goods){
                        console.log(goods.type === home_type);
                        if(goods.type === home_type){
                            var li1 = "<li class='phone_right_li'><a href='javascript:' class='countdown_goods_a'><img src='"+ goods.img +"' class='countdown_goods_img'><h3 class='phone_right_h3'>"+ goods.name +"</h3><p class='phone_right_p1'>"+ goods.info +"</p><p class='phone_right_p2'>"+ goods.price +"</p></a></li>";
                            var li2 = "<li class='phone_right_li home_right_li'><a href='javascript:' class='countdown_goods_a'><img src='"+ goods.img +"' class='countdown_goods_img'><h3 class='phone_right_h3'>"+ goods.name +"</h3><p class='phone_right_p1'>"+ goods.info +"</p><p class='phone_right_p2'>"+ goods.price +"</p></a></li>";
                            count++;
                            if(count<5){
                                console.log(count);
                                $(".home_right").children("ul").append(li1);
                            } else{
                                $(".home_right").children("ul").append(li2);
                            }
                        }
                    })
                });
            }
            showHomeGoods("rm");
        });






        // 轮播图开始
        $(document).ready(function() {
            var length,
                currentIndex = 0,
                interval,
                hasStarted = false, // 是否已经开始轮播
                t = 2000; // 轮播时间间隔
            length = $('.slider-panel').length;
            // 将除了第一张图片隐藏
            $('.slider-panel:not(:first)').hide();
            // 将第一个slider-item设为激活状态
            $('.slider-item:first').addClass('slider-item-selected');
            // 隐藏向前、向后翻按钮
            $('.slider-page').hide();
            // 鼠标上悬时显示向前、向后翻按钮,停止滑动，鼠标离开时隐藏向前、向后翻按钮，开始滑动
            $('.slider-panel, .slider-pre, .slider-next').hover(function() {
                stop();
                $('.slider-page').show();
            }, function() {
                $('.slider-page').hide();
                start();
            });
            $('.slider-item').hover(function(e) {
                stop();
                var preIndex = $(".slider-item").filter(".slider-item-selected").index();
                currentIndex = $(this).index();
                play(preIndex, currentIndex);
            }, function() {
                start();
            });
            $('.slider-pre').unbind('click');
            $('.slider-pre').bind('click', function() {
                pre();
            });
            $('.slider-next').unbind('click');
            $('.slider-next').bind('click', function() {
                next();
            });
            /**
             * 向前翻页
             */
            function pre() {
                var preIndex = currentIndex;
                currentIndex = (--currentIndex + length) % length;
                play(preIndex, currentIndex);
            }
            /**
             * 向后翻页
             */
            function next() {
                var preIndex = currentIndex;
                currentIndex = ++currentIndex % length;
                play(preIndex, currentIndex);
            }
            /**
             * 从preIndex页翻到currentIndex页
             * preIndex 整数，翻页的起始页
             * currentIndex 整数，翻到的那页
             */
            function play(preIndex, currentIndex) {
                $('.slider-panel').eq(preIndex).fadeOut(500)
                    .parent().children().eq(currentIndex).fadeIn(1000);
                $('.slider-item').removeClass('slider-item-selected');
                $('.slider-item').eq(currentIndex).addClass('slider-item-selected');
            }
            /**
             * 开始轮播
             */
            function start() {
                if (!hasStarted) {
                    hasStarted = true;
                    interval = setInterval(next, t);
                }
            }
            /**
             * 停止轮播
             */
            function stop() {
                clearInterval(interval);
                hasStarted = false;
            }
            // 开始轮播
            start();
        });
        // 轮播图结束
    </script>
</head>
<body>
<div class="fixed_div">
    <ul>
        <li><a class="fixed_div_a" href="javascript:"><img class="fixed_div_img" src="img/121.png" ></a>手机APP</li>
        <li><a class="fixed_div_a" href="javascript:"><img class="fixed_div_img" src="img/122.png" ></a>个人中心</li>
        <li><a class="fixed_div_a" href="javascript:"><img class="fixed_div_img" src="img/123.png" ></a>售后</li>
        <li><a class="fixed_div_a" href="javascript:"><img class="fixed_div_img" src="img/124.png" ></a>人工客服</li>
        <li><a class="fixed_div_a" href="javascript:"><img class="fixed_div_img" src="img/125.png" ></a>购物车</li>
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
                            <li><a href="javascript:">登录</a><span class="xm_nav_span">|</span></li>
                            <li><a href="javascript:">注册</a><span class="xm_nav_span">|</span></li>
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
                        <li><a href="javascript:"><span class="glyphicon glyphicon-menu-hamburger" style="color: white;font-size: 20px;line-height: 40px;"></span></a>
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
                <!-- <div class="col-sm-6 col-xs-6 black_logo">
                    <a href="javascript:"><img src="img/小米黑色logo.png"></a>
                </div> -->
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
                            <li style="float: left;"><a href="javascript:"><img src="<%=request.getContextPath()%>/img/6.png"></a></li>
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
                    <input type="text" class="search_input" placeholder="小米10" /><span class="glyphicon glyphicon-search search_span">
                    </span>
                </div>
            </div>
        </div>
    </div>
    <!-- 菜单轮播图 -->
    <div class="row carouse">
        <div class=" col-md-3 hidden-sm hidden-xs">
            <div class="row">
                <div class="col-md-10 carousel_left">
                    <ul>
                        <li id="shouji"><a href="javascript:">手机&nbsp;电话卡</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left1">
                                <ul>

                                </ul>
                            </div>
                        </li>
                        <li id="dianshi"><a href="javascript:">电视&nbsp;盒子</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left2" style="top: -61px;">
                                <img src="img/14.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="bijiben"><a href="javascript:">笔记本&nbsp;显示器</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left3" style="top: -104px;width: 750px;">
                                <img src="img/15.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="jiadian"><a href="javascript:">家电&nbsp;插线板</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left4" style="top: -146px;">
                                <img src="img/16.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="chuxing"><a href="javascript:">出行&nbsp;穿戴</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left5" style="top: -188px;width: 750px;">
                                <img src="img/17.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="zhineng"><a href="javascript:">智能&nbsp;路由器</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left6" style="top: -230px;width: 750px;">
                                <img src="img/18.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="dianyuan"><a href="javascript:">电源&nbsp;配件</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left7" style="top: -272px;width: 500px;">
                                <img src="img/19.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="jiankang"><a href="javascript:">健康&nbsp;儿童</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left8" style="top: -313px;width: 750px;">
                                <img src="img/20.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="erji"><a href="javascript:">耳机&nbsp;音箱</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left9" style="top: -355px; width: 750px;">
                                <img src="img/21.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                        <li id="shenghuo"><a href="javascript:">生活&nbsp;箱包</a><span class="glyphicon glyphicon-menu-right"></span>
                            <div class="carouselTwoMenu" id="left10" style="top: -398px;width: 750px;">
                                <img src="img/22.png" style="width: 100%;height: 100%;">
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="col-md-2">

                </div>
            </div>
        </div>
        <!-- <div class="carouse_right"> -->
        <!-- 轮播图开始 -->
        <div class="slider col-md-12">
            <ul class="slider-main">
                <li class="slider-panel">
                    <a href="#" target="_blank"><img src="img/8.png"></a>
                </li>
                <li class="slider-panel">
                    <a href="#" target="_blank"><img src="img/9.png"></a>
                </li>
                <li class="slider-panel">
                    <a href="#" target="_blank"><img src="img/10.png"></a>
                </li>
                <li class="slider-panel">
                    <a href="#" target="_blank"><img src="img/11.png"></a>
                </li>
                <li class="slider-panel">
                    <a href="#" target="_blank"><img src="img/12.png"></a>
                </li>
                <li class="slider-panel">
                    <a href="#" target="_blank"><img src="img/13.png"></a>
                </li>
            </ul>
            <div class="slider-extra">
                <ul class="slider-nav">
                    <li class="slider-item"></li>
                    <li class="slider-item"></li>
                    <li class="slider-item"></li>
                    <li class="slider-item"></li>
                    <li class="slider-item"></li>
                    <li class="slider-item"></li>
                </ul>
                <div class="slider-page">
                    <a class="slider-pre" href="javascript:;;">
                        <</a> <a class="slider-next" href="javascript:;;">>
                </a>
                </div>
            </div>
            <!-- 轮播图结束 -->
            <!-- </div> -->
        </div>
    </div>
    <!-- 轮播图下方内容 -->
    <div class="row carousel_bottom hidden-sm hidden-xs">
        <!-- 轮播图下方左边内容 -->
        <div class="col-md-3 carousel_bottom_left">
            <!-- 轮播图下放左边6个小格子 -->
            <div class="row carousel_bottom_left_six">
                <div class="carousel_bottom_left_six_ul">
                    <ul style="margin: 0;">
                        <li class="carousel_bottom_left_six_li">
                            <a href="javascript:" class="carousel_bottom_left_six_ul_a">
                                <img src="img/68.png" class="carousel_bottom_left_six_ul_img" >
                                <p class="carousel_bottom_left_six_ul_p">小米秒杀</p>
                            </a>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_wire">
                            <div class="wire">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_li">
                            <a href="javascript:" class="carousel_bottom_left_six_ul_a">
                                <img src="img/69.png" class="carousel_bottom_left_six_ul_img" >
                                <p class="carousel_bottom_left_six_ul_p">企业团购</p>
                            </a>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_wire">
                            <div class="wire">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_li">
                            <a href="javascript:" class="carousel_bottom_left_six_ul_a">
                                <img src="img/70.png" class="carousel_bottom_left_six_ul_img" >
                                <p class="carousel_bottom_left_six_ul_p">F码通道</p>
                            </a>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_acrosswire">
                            <div style="height: 1px;width: 50px;background-color: #665E57;">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_acrosswire" style="margin-left: 25px;">
                            <div style="height: 1px;width: 50px;background-color: #665E57;">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_acrosswire" style="margin-left: 25px;">
                            <div style="height: 1px;width: 50px;background-color: #665E57;">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_li">
                            <a href="javascript:" class="carousel_bottom_left_six_ul_a">
                                <img src="img/71.png" class="carousel_bottom_left_six_ul_img" >
                                <p class="carousel_bottom_left_six_ul_p">米粉卡</p>
                            </a>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_wire">
                            <div class="wire">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_li">
                            <a href="javascript:" class="carousel_bottom_left_six_ul_a">
                                <img src="img/72.png" class="carousel_bottom_left_six_ul_img" >
                                <p class="carousel_bottom_left_six_ul_p">以旧换新</p>
                            </a>
                        </li>

                        <li class="carousel_bottom_left_six_ul_li_wire">
                            <div class="wire">

                            </div>
                        </li>

                        <li class="carousel_bottom_left_six_li">
                            <a href="javascript:" class="carousel_bottom_left_six_ul_a">
                                <img src="img/73.png" class="carousel_bottom_left_six_ul_img" >
                                <p class="carousel_bottom_left_six_ul_p">话费充值</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <ul>
                <li></li>
            </ul>
        </div>


        <!-- 轮播图下方右边内容 -->
        <div class="col-md-9 carousel_bottom_rigth">
            <div class="row">
                <div class="col-lg-12 carousel_bottom_rigth_div">
                    <div class="carousel_bottom_rigth_div_div" style="float: left;">
                        <img src="img/74.png" class="carousel_bottom_rigth_div_img">
                    </div>
                    <div class="carousel_bottom_rigth_div_div" style="float: left;margin-left: 15.5px;">
                        <img src="img/75.png" class="carousel_bottom_rigth_div_img">
                    </div>
                    <div class="carousel_bottom_rigth_div_div" style="float: left;margin-left: 15.5px;">
                        <img src="img/76.png" class="carousel_bottom_rigth_div_img">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 下方内容 -->
<div class="container-fluid" style="background-color: #F5F5F5; height: 2000px;margin-top: 30px;">
    <div class="container">

        <!-- 小米闪购：倒计时标题 -->
        <div class="row">
            <div class="col-md-11">
                <h2 class="bottom_title">小米闪购</h2>
            </div>
            <div class="col-md-1">
                <button type="button" id="btn_left" class="bottom_btn" style="border-right: none;"><</button><button type="button" id="btn_right" class="bottom_btn">></button>
            </div>
        </div>

        <!-- 倒计时 -->
        <div class="row">
            <!-- 倒计时div -->
            <div class="col-md-2">
                <div class="se-kl" style="background-image: url(<%=request.getContextPath()%>/img/秒杀背景.png);cursor: pointer;">
                    <div class="se-cn">23:00&nbsp;场</div>
                    <i class="se-io"></i>
                    <div class="se-info">距离结束还有</div>
                    <div class="se-count">
                        <div class="se-day"></div>
                        <div class="se-hour"><span class="se-txt">00</span></div>
                        <!-- <div id="" style="float: left;height: 46px;line-height: 46px;margin-left: -3px;">
                            <span style="font-size: 16px;font-weight: 900;color: #605751;">:</span>
                        </div> -->
                        <div class="se-min"><span class="se-txt">00</span></div>
                        <!-- <div id="" style="float: left;height: 46px;line-height: 46px;margin-left: -3px;">
                            <span style="font-size: 16px;font-weight: 900;color: #605751;">:</span>
                        </div> -->
                        <div class="se-sec"><span class="se-txt">00</span></div>
                    </div>
                </div>
            </div>

            <div class="col-md-10">
                <div class="countdown_right" >
                    <div class="countdown_goods">
                        <ul  style="margin: 0;">
                            <li class="countdown_goods_li">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/79.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li" style="border-top: 1px solid #83c44e;">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/80.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li" style="border-top: 1px solid #2196f3;">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/81.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li" style="border-top: 1px solid #e53935;">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/82.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li" style="border-top: 1px solid #2196f3;">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/83.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li" style="border-top: 1px solid #83c44e;">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/84.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li" style="border-top: 1px solid #e53935;">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/85.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                            <li class="countdown_goods_li">
                                <a href="javascript:" class="countdown_goods_a">
                                    <img src="img/86.png" class="countdown_goods_img">
                                    <h3 class="countdown_goods_h3">柔风 | 小米新1级空调 大1匹</h3>
                                    <p class="countdown_goods_p1">变频节能巨省电，自清洁</p>
                                    <p class="countdown_goods_p2">2299元</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>


        <!-- 小米10至尊纪念版横幅 -->
        <div class="row">
            <div class="col-md-12 banner">
                <img src="img/77.png" class="banner_img">
            </div>
        </div>

        <!-- 手机标题 -->
        <div class="row">
            <div class="col-md-10">
                <h2 class="bottom_title">手机</h2>
            </div>
            <div class="col-md-2 phone_title">
                <p class="title_p">查看全部<span class="title_span">></span></p>
            </div>
        </div>

        <!-- 手机 -->
        <div class="row">
            <div class="col-md-2 phone_left"  >
                <img src="img/95.png" class="phone_left_img">
            </div>
            <div class="col-md-10 phone_right"  style="padding: 0;">
                <ul>
                    <li class="phone_right_li">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/87.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/88.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/89.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/90.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li" style="margin-top: 15px;">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/91.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li" style="margin-top: 15px;">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/92.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li" style="margin-top: 15px;">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/93.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                    <li class="phone_right_li" style="margin-top: 15px;">
                        <a href="javascript:" class="countdown_goods_a">
                            <img src="img/94.png" class="countdown_goods_img">
                            <h3 class="phone_right_h3">小米10 至尊版</h3>
                            <p class="phone_right_p1">120X 变焦/120W秒充/120Hz屏幕</p>
                            <p class="phone_right_p2">5299元</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 banner">
                <img src="img/96.png" class="banner_img">
            </div>
        </div>
        <!-- 家电标题 -->
        <div class="row">
            <div class="col-md-10">
                <h2 class="bottom_title">家电</h2>
            </div>
            <div class="col-md-2" class="phone_title">
                <span class="jd_remen jd" value="rm">热门</span>
                <span class="jd_dianshiyingyin jd" value="dsyy">电视影音</span>
            </div>
        </div>


        <!-- 家电 -->
        <div class="row">
            <div class="col-md-2 home_left">
                <img src="img/97.png" class="home_left_img">
                <img src="img/98.png" class="home_left_img" style="margin-top: 15px;">
            </div>

            <div class="col-md-10 home_right">
                <ul style="padding: 0;">

                </ul>
            </div>
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
