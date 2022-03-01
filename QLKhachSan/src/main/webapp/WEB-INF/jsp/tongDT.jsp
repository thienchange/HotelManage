<%-- 
    Document   : tongDT
    Created on : Nov 12, 2021, 3:02:38 PM
    Author     : ACER
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">TỔNG DOANH THU KHÁCH SẠN</h1>

<div>
    <canvas id="MonthStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Tổng doanh thu</th>
    </tr>
    <c:forEach items="${dtThang}" var="p">
        <tr>
            <td>${p[0]}/${p[1]}</td>
            <td><fmt:formatNumber value = "${p[2]}"/><small>đ</small></td>
        </tr>
    </c:forEach>
</table>

<script>
    let dtLabels=[], dtInfo=[];
    <c:forEach items="${dtThang}" var="p">
        dtLabels.push('${p[0]}/${p[1]}');
        dtInfo.push(${p[2]});
    </c:forEach>
    
    
    window.onload = function(){
        MonthChart("MonthStatsChart", dtLabels, dtInfo);
    };
</script>