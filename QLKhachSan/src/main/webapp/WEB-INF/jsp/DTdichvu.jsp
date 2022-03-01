<%-- 
    Document   : DTdichvu
    Created on : Nov 15, 2021, 11:23:58 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">THỐNG KÊ DOANH THU DỊCH VỤ</h1>

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
    <canvas id="dichVuStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã dịch vụ</th>
        <th>Tên dịch vụ</th>
        <th>Doanh thu dịch vụ</th>
    </tr>
    <c:forEach items="${dvuStats}" var="d">
        <tr>
            <td>${d[0]}</td>
            <td>${d[1]}</td>
            <td><fmt:formatNumber value = "${d[2]}"/><small>đ</small></td>
        </tr>
    </c:forEach>
</table>

<script>
    let dvLabels=[], dvInfo=[];
    <c:forEach items="${dvuStats}" var="d">
        dvLabels.push('${d[1]}')
        dvInfo.push(${d[2]})
    </c:forEach>
    
    
    window.onload = function(){
        dichVuChart("dichVuStatsChart", dvLabels, dvInfo);
    };
</script>