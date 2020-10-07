<%--
  Created by IntelliJ IDEA.
  User: 31773
  Date: 2020/10/7
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/xm.css" />
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        .container{
            margin-top:50px;
            padding-bottom:50px;
        }
        .cartHead div {
            height: 50px;
            line-height: 50px;
            border: 1px solid #ccc;
        }
        .cartBody div {
            height: 100px;
            border: 1px solid #ccc;
        }
        #span1 {
            color: red;
        }
        .tex {
            height: 30px;
            text-align: center;
        }
        .btn1 {
            height: 30px;
        }
        .btn2 {
            height: 30px;
        }
        #ep {
            height: 60px;
            color: red;
            border: 1px solid #ccc;
        }

    </style>
    <script>
        $(function () {
            $(".che").click(function() {
                var che = $(this).prop("checked");
                $(".chec").prop("checked", che);
                samllPrice();
            });
            $(".chec").click(function() {
                var all = true;
                $(".chec").each(function() {
                    if($(this).prop("checked") == false) {
                        all = false;
                    }
                });
                $(".che").prop("checked", all);
                samllPrice();
            });
            //数量加
            $(".add").click(function() {
                var n = $(this).prev().val();
                n++;
                $(this).prev().val(n);
                var p = $(this).parent().prev().text();

                $(this).parent().next().text(p * n);
                samllPrice();
            });
            //数量减
            $(".sub").click(function() {
                var n = $(this).next().val();
                n--;
                if(n < 1) {
                    n = 1;
                }
                $(this).next().val(n);
                var p = $(this).parent().prev().text();
                $(this).parent().next().text(p * n);
                samllPrice();
            });
            $(".cartBody a").click(function() {
                if(confirm("确定删除此商品吗？")) {
                    $(this).parents(".row").remove();
                }
                emp();
                samllPrice();
            });
            $(".cartFoot a").click(function() {
                if(confirm("确定删除这些商品吗？")) {
                    $(".chec").each(function() {
                        if($(this).prop("checked")) {
                            $(this).parents(".row").remove();

                        }
                    });
                }
                samllPrice();
                emp();
            });
            function emp() {
                if($(".cartBody").length == 0) {
                    $("#ep").removeClass("hidden");
                }
            }
            emp();
            function samllPrice() {
                var p1 = 0;
                $(".chec").each(function() {
                    if($(this).prop("checked")) {
                        var p2 = $(this).parents(".row").children(".price").text();
                        p1 += parseInt(p2);
                    }
                });
                $("#span1").text(p1);
            }
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
        })

    </script>
</head>
<body>
<div class="container">
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
        <!-- 小米头部左边内容 -->
        <div class="row xm_head_left_menu col-md-9">
            <h1>我的购物车</h1>
        </div>
    </div>
</div>
</div>
<div class="container">
    <div class="cart">
        <form action="index.html">
            <div class="row cartHead text-center">
                <div class="col-md-1">
                    <input type="checkbox" class="che" />
                </div>
                <div class="col-md-3">图片</div>
                <div class="col-md-1">名字</div>
                <div class="col-md-1">价格</div>
                <div class="col-md-3">数量</div>
                <div class="col-md-1">小计</div>
                <div class="col-md-2">操作</div>
            </div>
            <div class="row cartBody text-center">
                <div class="col-md-1">
                    <input type="checkbox" class="chec" />
                </div>
                <div class="col-md-3">
                    <%--<img src="img/12.png" />--%>
                </div>
                <div class="col-md-1">大白</div>
                <div class="col-md-1">50</div>
                <div class="col-md-3">

                    <button type="button" class="sub">-</button>
                    <input type="text" value="1" readonly="readonly" />
                    <button type="button" class="add">+</button>

                </div>
                <div class="col-md-1 price">50</div>
                <div class="col-md-2"><a href="javascript:">删除</a></div>
            </div>
            <div class="row cartBody text-center">
                <div class="col-md-1">
                    <input type="checkbox" class="chec" />
                </div>
                <div class="col-md-3">
                    <%--<img src="img/12.png" />--%>
                </div>
                <div class="col-md-1">大白</div>
                <div class="col-md-1">60</div>
                <div class="col-md-3">
                    <button type="button" class="sub">-</button>
                    <input type="text" value="1" readonly="readonly" />
                    <button type="button" class="add">+</button>
                </div>
                <div class="col-md-1 price">60</div>
                <div class="col-md-2"><a href="javascript:">删除</a></div>
            </div>
            <div class="row cartBody text-center">
                <div class="col-md-1">
                    <input type="checkbox" class="chec" />
                </div>
                <div class="col-md-3">
                    <%--<img src="img/12.png" />--%>
                </div>
                <div class="col-md-1">大白</div>
                <div class="col-md-1">70</div>
                <div class="col-md-3">

                    <button type="button" class="sub">-</button>
                    <input type="text" value="1" readonly="readonly" />
                    <button type="button" class="add">+</button>

                </div>
                <div class="col-md-1 price">70</div>
                <div class="col-md-2"><a href="javascript:">删除</a></div>

            </div>
            <div class="row hidden"id="ep">
                <div class="col-md-12 text-center" >
                    购物车为空，请前往商城够买所需物品
                </div>
            </div>
            <div class="cartFoot">
                <div class="row">
                    <div class="col-lg-1"><a href="javascript:">批量删除</a></div>
                    <div class="col-lg-7"></div>
                    <div class="col-lg-2">总价格</div>
                    <div class="col-lg-2">
                        <span id="span1">0</span>元
                        <button type="submit" value="付款">付款</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="container">
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
</body>
</html>
