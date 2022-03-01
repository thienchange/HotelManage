<%-- 
    Document   : header
    Created on : Aug 18, 2021, 1:06:29 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-large">
    <ul class="root">
        <li>
            <a href="<c:url value="/"/>" class="w3-bar-item w3-button w3-red w3-mobile" style="text-decoration: none;">
                <i class="fa fa-bed"></i> Trang chủ</a>
        </li>
        <li>
            <a href="<c:url value="/"/>#rooms" class="dropbtn">
                Loại phòng
            </a>
        </li>
        <li>
            <a href="<c:url value="/dichvu"/>" class="dropbtn">
                Dịch vụ
            </a>
        </li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li>
                <a href="<c:url value="/admin/qlnv"/>" class="dropbtn">
                    Nhân viên
                </a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li>
                <a href="<c:url value="/admin/ThongKe/doanhthuthang"/>" target="_blank" class="dropbtn ">
                    Thống kê
                </a>
            </li>
        </sec:authorize>
        <li>
            <a href="<c:url value="/"/>#about">
                Về chúng tôi
            </a>
        </li>
        <li>
            <a href="<c:url value="/"/>#contact">Liên hệ <i class="fa fa-angle-right"></i></a>
        </li>
        <sec:authorize access="hasRole('ROLE_STAFF')">
            <li>
                <a href="<c:url value="/admin/hoadon"/>" >
                    Quản lý đặt phòng
                </a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
            <li>
                <a href="<c:url value="/booking"/>" >
                    <i class="fa fa-id-card" aria-hidden="true"></i> Booking
                    <span class="badge badge-danger" id="bookingCounter">${bookingCounter}</span></a>
                </a>
            </li>
        </sec:authorize>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="<c:url value="/login"/>" class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Đăng nhập</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a href="<c:url value="/logout"/>" class="text-danger w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Đăng xuất</a>
            <a href="<c:url value="/user-info/?id=${currentUser.khachHang.id}"/>" class="nav-link text-warning" style="margin-top: 2px; float:right;">
                <c:if test="${currentUser.avatar != null}" >
                    <img src="${currentUser.avatar}" style="width: 30px;" class="rounded" /> 
                </c:if>
                <c:if test="${currentUser.avatar == null}" >
                    <i class="fa fa-user-circle" aria-hidden="true"></i>
                </c:if>

                ${pageContext.request.userPrincipal.name}</a>    
        </c:if>
    </ul>
</div>