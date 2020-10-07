<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/10/6
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>小米账号 - 登录</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="UTF-8"></script>
    <style type="text/css">
        .ip{
            width: 300px;
            height: 30px;
        }
        img{
            height: 500px;
        }
        #btn{
            width: 300px;
            height: 60px;
            background-color: orangered;
        }
    </style>
    <script>
        $(function () {
            $("#i1").click(function () {
                $("#i7").show()
                $("#i1").css("color","orangered")
                $("#i2").css("color","black");
            })

            $("#i2").click(function () {
                $("#i7").hide()
                $("#i2").css("color","orangered")
                $("#i1").css("color","black");
            })

            $("#i4").click(function () {
                $("#i4").css("color","orangered")
                $("#i5,#i6,#i7").css("color","black");

            })
            $("#i5").click(function () {
                $("#i5").css("color","orangered")
                $("#i4,#i6,#i7").css("color","black");
            })

            $("#i6").click(function () {
                $("#i6").css("color","orangered")
                $("#i4,#i5,#i7").css("color","black");
            })

            $("#i7").click(function () {
                $("#i7").css("color","orangered")
                $("#i4,#i5,#i6").css("color","black");
            })
        })
    </script>
</head>
<body>
    <div class = "container-fluid">
        <div class="row">

            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 ">
                ${goods.gimg}
            </div>

            <div class="col-lg-6 col-md-6 col-sm-6 hidden-xs">
                <h3>${goods.gname}</h3>
                <p>${goods.gdepict}</p>
                <h5 style="color: orangered">小米自营</h5>
                <h4>${goods.gtid}</h4>
                <h4>${goods.gprice}</h4>
                <hr>

                <div>
                    <a href="<%=application.getContextPath()%>/goods?op=insertIntoCart"><button id="btn">加入购物车</button></a>
                </div>

            </div>
        </div>

    </div>
</body>
</html>
