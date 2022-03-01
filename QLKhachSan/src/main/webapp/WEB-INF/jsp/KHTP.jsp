<%-- 
    Document   : KHTP
    Created on : Nov 16, 2021, 7:47:48 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-danger">THỐNG KÊ SỐ KHÁCH THUÊ THEO TỪNG PHÒNG</h1>

<form action="">
    <div class="form-group">
        <label>Loại phòng</label>
        <input type="text" name="kw" class="form-control" 
               placeholder="Nhập loại phòng cần thống kê khách hàng"/>
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
    <canvas id="khachHangPhongStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã phòng</th>
        <th>Số phòng</th>
        <th>Số khách thuê</th>
    </tr>
    <c:forEach items="${khpStats}" var="k">
        <tr>
            <td>${k[0]}</td>
            <td>${k[1]}</td>
            <td>${k[2]}<small> người</small></td>
        </tr>
    </c:forEach>
</table>

<script>
    let khLabels=[], khInfo=[];
    <c:forEach items="${khpStats}" var="k">
        khLabels.push('${k[1]}')
        khInfo.push(${k[2]})
    </c:forEach>
    
    
    window.onload = function(){
        khPhongStatsChart("khachHangPhongStatsChart", khLabels, khInfo);
    };
</script>