<%-- 
    Document   : DTDVthang
    Created on : Nov 15, 2021, 10:27:48 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">THỐNG KÊ DOANH THU DỊCH VỤ THEO THÁNG</h1>

<form action="">
    <div class="form-group">
        <label>Tên dịch vụ</label>
        <input type="text" name="kw" class="form-control" 
               placeholder="Nhập tên dịch vụ cần thống kê"/>
    </div>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Thống kê" class="btn text-warning" />
</form>

<div>
    <canvas id="dvMonthStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Tổng doanh thu dịch vụ</th>
    </tr>
    <c:forEach items="${dvuMonthStats}" var="d">
        <tr>
            <td>${d[0]}/${d[1]}</td>
            <td><fmt:formatNumber value = "${d[2]}"/><small>đ</small></td>
        </tr>
    </c:forEach>
</table>

<script>
    let dvLabels=[], dvInfo=[];
    <c:forEach items="${dvuMonthStats}" var="d">
        dvLabels.push('${d[0]}/${d[1]}')
        dvInfo.push(${d[2]})
    </c:forEach>
    
    
    window.onload = function(){
        dichVuMonthStatsChart("dvMonthStatsChart", dvLabels, dvInfo);
    };
</script>