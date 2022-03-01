<%-- 
    Document   : DTthang
    Created on : Nov 8, 2021, 1:25:02 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">THỐNG KÊ DOANH THU PHÒNG THEO THÁNG</h1>

<form action="">
    <div class="form-group">
        <label>Loại phòng</label>
        <input type="text" name="kw" class="form-control" 
               placeholder="Nhập loại phòng cần thống kê"/>
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
    <canvas id="phongMonthStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Tổng doanh thu phòng</th>
    </tr>
    <c:forEach items="${phongMonthStats}" var="p">
        <tr>
            <td>${p[0]}/${p[1]}</td>
            <td><fmt:formatNumber value = "${p[2]}"/><small>đ</small></td>
        </tr>
    </c:forEach>
</table>

<script>
    let phongLabels=[], phongInfo=[];
    <c:forEach items="${phongMonthStats}" var="p">
        phongLabels.push('${p[0]}/${p[1]}')
        phongInfo.push(${p[2]})
    </c:forEach>
    
    
    window.onload = function(){
        phongMonthChart("phongMonthStatsChart", phongLabels, phongInfo);
    };
</script>
