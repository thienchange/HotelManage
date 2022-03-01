<%-- 
    Document   : admin-left
    Created on : Nov 7, 2021, 12:58:03 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar">
    <ul class="navbar-nav bg-dark">
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/TKloaiphong" />">Thống kê loại phòng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/thongkekhachhang" />">Thống kê khách hàng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/khachhangtungphong" />">Số khách từng phòng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/doanhthudichvu" />">Doanh thu theo dịch vụ</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/dtdichvuthang" />">Doanh thu dịch vụ tháng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/doanhthuphong" />">Doanh thu theo từng phòng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/doanhthuthang" />">Doanh thu phòng theo tháng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-left" href="<c:url value="/admin/ThongKe/tongdoanhthu" />">Tổng doanh thu theo tháng</a>
        </li>
    </ul>
</nav>