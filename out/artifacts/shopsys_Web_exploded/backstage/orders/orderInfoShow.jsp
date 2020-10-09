<%@ page import="com.etc.shopsys.domain.OrderState" %>
<%@ page import="com.etc.shopsys.service.OrderStateService" %>
<%@ page import="com.etc.shopsys.service.impl.OrderStateServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/07
  Time: 13:37
  To change this tuserlate use File | Settings | File Tuserlates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单信息</title>
    <!-- 标题头部logo设置 -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/titlelogo.ico" type="image/x-icon">
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function(){
            // 分页搜索：当下拉框发生改变的时候
            $("#state").change(function(){
                var osid = $(this).val();
                window.location.href = "backstageOrders?op=findAllOrder&osid="+osid;
            })
            //修改：根据 UUID 修改订单状态
            $("#mytbody>tr>td:last-child>select").change(function(){
                var oid = $(this).attr("oid");
                var osid = $(this).val();
                // console.log("oid" + oid);
                // console.log("osid" + osid);
                $.ajax({
                    url:"<%=request.getContextPath()%>/backstageOrders?op=updateOrderState",
                    type:"get",
                    data:{
                        "oid":oid,
                        "osid":osid,
                    },
                    success:function(data){
                        alert(data)
                    },
                    error:function(e){
                        alert("失败"+e);
                    }
                })
            })
        })
    </script>
    <%
        OrderStateService osService = new OrderStateServiceImpl();
        List<OrderState> ors = osService.findAllOrderState();
        request.setAttribute("ors", ors);
    %>
</head>
<body>

<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row" style="margin-top: 50px">
                <div class="form-group col-md-3 col-md-offset-9">
                    <select class="form-control" id="state" name="state" >
                        <option value="">根据订单状态查询</option>
                        <c:forEach var="orederstate" items="${ors}">
                            <c:if test="${orederstate.osid == requestScope.osid}">
                                <option value="${orederstate.osid}" selected="selected">${orederstate.state}</option>
                            </c:if>
                            <c:if test="${orederstate.osid != requestScope.osid}">
                                <option value="${orederstate.osid}">${orederstate.state}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <table class="table table-hover table-bordered" >
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>用户名</th>
                    <th>总价</th>
                    <th>下单时间</th>
                    <th>订单状态</th>
                </tr>
                </thead>
                <tbody id="mytbody">
                <c:forEach var="o" items="${requestScope.orders.data}">
                    <tr>
                        <%--点击查看订单详情--%>
                        <td><a href="#">${o.oid}</a></td>
                        <%--点击查看用户购买记录--%>
                        <td><a href="#">${o.uid.username}</a></td>
                        <td>${o.total}</td>
                        <td>${o.createdate}</td>
                        <td>
                            <select class="form-control ostate" name="ostate" oid="${o.oid}">
                                <c:forEach var="orederstate" items="${ors}">
                                    <c:if test="${orederstate.osid == o.osid.osid}">
                                        <option value="${orederstate.osid}" selected="selected">${orederstate.state}</option>
                                    </c:if>
                                    <c:if test="${orederstate.osid != o.osid.osid}">
                                        <option value="${orederstate.osid}">${orederstate.state}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="width:100%;position: fixed;bottom: 130px" class="row text-center" >
                <ul class="pagination" style="margin: 0 auto">
                    <c:if test="${orders.currentPage == 1}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=1&osid=${requestScope.osid}">首页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${orders.prevPage}&osid=${requestScope.osid}">上一页</a></li>
                    </c:if>
                    <c:if test="${orders.currentPage != 1}">
                        <li><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=1&osid=${requestScope.osid}">首页</a></li>
                        <li><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${orders.prevPage}&osid=${requestScope.osid}">上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${orders.totalPage}" varStatus="i" >
                        <c:if test="${orders.currentPage == i.index}">
                            <li class="active"><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${i.index}&osid=${requestScope.osid}">${i.index}</a></li>
                        </c:if>
                        <c:if test="${orders.currentPage != i.index}">
                            <li><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${i.index}&osid=${requestScope.osid}">${i.index}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${orders.currentPage == orders.totalPage}">
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${orders.nextPage}&osid=${requestScope.osid}">下一页</a></li>
                        <li class="disabled"><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${orders.totalPage}&osid=${requestScope.osid}">尾页</a></li>
                    </c:if>
                    <c:if test="${orders.currentPage != orders.totalPage}">
                        <li><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${orders.nextPage}&osid=${requestScope.osid}">下一页</a></li>
                        <li><a href="<%=request.getContextPath()%>/backstageOrders?op=findAllOrder&pageCount=${orders.totalPage}&osid=${requestScope.osid}">尾页</a></li>
                    </c:if>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">页数：${orders.currentPage}/${orders.totalPage}</li>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">记录数：${orders.totalCount}条</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
