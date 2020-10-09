<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/10/6
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小米账号 - 商品详情</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="UTF-8"></script>
    <style type="text/css">
        #btn{
            width: 300px;
            height: 60px;
            background-color: orangered;
        }
    </style>
    <script>
        $(function(){
            $("#btn").click(function () {
                $.ajax({
                    // 获取 #ajax_a id标签的 href 属性值
                    url:$("#ajax_a").attr("href"),
                    type:"get",
                    data:{
                        "div5":$("#div5").val()
                    },
                    success:function(data){
                        alert("结果为:"+data)
                    },
                    error:function (e) {
                        alert("结果为:"+e)
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
    <div class = "container-fluid">
        <div class="row">

                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 ">
                    <img src=" <%=request.getContextPath()%>/${goods.gimg}">
                </div>

                <div class="col-lg-6 col-md-6 col-sm-6 hidden-xs">
                    <h3>${goods.gname}</h3>
                    <p>${goods.gdepict}</p>
                    <h5 style="color: orangered">小米自营</h5>
                    <h4>${goods.gtid}</h4>
                    <h4>${goods.gprice}</h4>
                    <hr>

                    <div>
                        <a id="ajax_a" href="<%=application.getContextPath()%>/good?op=insertIntoCart&gid=${goods.gid}"><button id="btn">加入购物车</button></a>
                    </div>
                </div>

        </div>

    </div>
</body>
</html>
