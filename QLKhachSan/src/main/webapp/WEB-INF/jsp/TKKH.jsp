<%-- 
    Document   : TKKH
    Created on : Nov 16, 2021, 7:12:45 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-danger">TỔNG SỐ KHÁCH THUÊ PHÒNG THEO THÁNG</h1>

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
    <canvas id="khachHangStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Số khách thuê</th>
    </tr>
    <c:forEach items="${khStats}" var="k">
        <tr>
            <td>${k[0]}/${k[1]}</td>
            <td>${k[2]}<small> người</small></td>
        </tr>
    </c:forEach>
</table>

<script>
    let khLabels=[], khInfo=[];
    <c:forEach items="${khStats}" var="k">
        khLabels.push('${k[0]}/${k[1]}')
        khInfo.push(${k[2]})
    </c:forEach>
    
    
    window.onload = function(){
        khachStatsChart("khachHangStatsChart", khLabels, khInfo);
    };
</script>