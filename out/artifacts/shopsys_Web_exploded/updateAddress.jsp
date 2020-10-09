<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/10/8
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>地址信息修改</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="UTF-8"></script>
    <script type="text/javascript">
        $(function () {
            $("#uname").blur(function(){
                var uname=$("#uname").val();
                if(uname==""){
                    $("#mp").text("联系人姓名不能为空").css("display","block");
                }else{
                    $("#mp").css("display","none");
                }
            })

            $("#tel").blur(function(){
                var tel=$("#tel").val();
                var telck = /^1[3456789]\d{9}$/;
                if(tel==""){
                    $("#mt").text("联系电话不能为空").css("display","block");
                }else if(telck.test(tel)){
                    $("#mt").css("display","none");
                }else{
                    $("#mt").text("手机号格式错误").css("display","block");
                }
            })

            $("#address").blur(function(){
                var address=$("#address").val();
                if(address==""){
                    $("#ma").text("收件地址不能为空").css("display","block");
                }else{
                    $("#ma").css("display","none");
                }
            })

            $("#btn").click(function(){
                /* alert("注册成功"); */
                var uname = $("#uname").val();
                var tel=$("#tel").val();
                var address=$("#address").val();

                var telck = /^1[3456789]\d{9}$/;
                if(uname!=null&&address!=null&&telck.test(tel)){
                    alert("修改成功");

                }else{
                    alert("请输入有效信息");
                }
            })
        })

    </script>
</head>
<body>

<form class="form-horizontal" action="<%=request.getContextPath()%>/address?op=updateSuccess" method="post">
    <div class="form-group">
        <label for="uname" class="col-sm-2 control-label">联系人姓名</label>
        <div class="col-sm-4">
            <input type="hidden" class="form-control" id="uuid" name="UUID" value="${addressByUUID.UUID}">
            <input type="text" class="form-control" id="uname" name="contactname" value="${addressByUUID.contactname}">
            <div id="mp" style="display: none; color:red"></div>
        </div>
    </div>
    <div class="form-group">
        <label for="tel" class="col-sm-2 control-label">联系电话</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="tel" name="phone" value="${addressByUUID.phone}">
            <div id="mt" style="display: none; color:red"></div>
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-2 control-label">收件地址</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="address" name="uaddress" value="${addressByUUID.uaddress}">
            <div id="ma" style="display: none; color:red"></div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="btn" type="submit" class="btn btn-default" href="<%=application.getContextPath()%>/address?op=updateSuccess&contactname=${addressByUUID.contactname}
            &phone=${addressByUUID.phone}&uaddress=${addressByUUID.uaddress}">提交</button>
        </div>
    </div>
</form>

</body>
</html>
