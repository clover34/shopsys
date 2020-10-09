<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/10/8
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的收货地址</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="UTF-8"></script>
    <script>
        $(function () {
            $(".delClass").click(function (event) {
                event.preventDefault();
                if(confirm("是否确认删除?")){
                    window.location.href=$(this).attr("href");
                }else{
                    alert("取消删除");
                }
            })
        })
    </script>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr colspan="3">
            <a href="insertAddress.jsp"><button>新增地址</button></a>
        </tr>
        <tr>
            <th>姓名</th>
            <th>地址信息</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${allAddress}" var="addr">
            <tr>
                <td>${addr.contactname}</td>
                <td>${addr.uaddress}</td>
                <td>
                    <a href="<%=application.getContextPath()%>/address?op=update&UUID=${addr.UUID}"><button>修改</button></a>
                    <a class="delClass" href="<%=application.getContextPath()%>/address?op=delete&UUID=${addr.UUID}"><button>删除</button></a>
                </td>

            </tr>

        </c:forEach>


    </table>
</div>
</body>
</html>
