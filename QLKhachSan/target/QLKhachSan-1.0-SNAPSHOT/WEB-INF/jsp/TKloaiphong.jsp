<%-- 
    Document   : TKloaiphong
    Created on : Nov 7, 2021, 1:01:55 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Thống kê phòng theo từng loại</h1>

<table class="table">
    <tr>
        <th>Mã loại phòng</th>
        <th>Loại phòng</th>
        <th>Số lượng phòng</th>
    </tr>
    <c:forEach items="${loaiStats}" var="l">
        <tr>
            <td>${l[0]}</td>
            <td>${l[1]}</td>
            <td>${l[2]}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <canvas id="loaiStatsChart"></canvas>
</div>
<script>
    let loaiLabels=[], loaiInfo=[];
    <c:forEach items="${loaiStats}" var="l">
        loaiLabels.push('${l[1]}')
        loaiInfo.push(${l[2]})
    </c:forEach>
    
    window.onload = function(){
        loaiChart("loaiStatsChart", loaiLabels, loaiInfo);
    };
</script>
    