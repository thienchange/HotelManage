<%-- 
    Document   : dichvu
    Created on : Aug 21, 2021, 7:31:34 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class ="text-center text-danger">DỊCH VỤ KHÁCH SẠN</h1>

<form action="">
    <div class="row">
        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_STAFF')">
            <div class="col-md-2">
                <a href="<c:url value="/admin/qldv"/>" class="btn btn-danger" >Quản lý dịch vụ</a>
            </div>
        </sec:authorize>
        <div class="col-md-6">
            <input class="form-control" type="text" name="kw" placeholder="Nhập dịch vụ bạn cần tìm "/>
        </div>
        <div class="col-md-2">
            <button class="btn btn-danger">Tìm <i class="fa fa-search"></i></button>
        </div>
        <sec:authorize access="hasRole('ROLE_USER')">
            <c:if test="${bookingCounter == 0}">
                <div class="col-md-4">
                    <h5 class="text-danger">*lưu ý: đặt phòng trước khi đặt dịch vụ</h5>
                </div>
            </c:if>
        </sec:authorize>
    </div>
</form>
<br>
<div class = "row">
    <c:forEach var="d" items="${dvu}">
        <div class="card col-md-4">
            <div class="card-body">
                <c:if test="${d.hinhanh != null && d.hinhanh.startsWith('https') == true}">
                    <img class="img-fluid" src="<c:url value="${d.hinhanh}" />" alt="${d.ten}" />       
                </c:if>
                <c:if test="${d.hinhanh == null || d.hinhanh.startsWith('https') == false}">
                    <img class="img-fluid" src="<c:url value="/images/beef.jpg" />" alt="${d.ten}" />       
                </c:if>
                <h4>Dịch vụ: ${d.ten}</h4>
                <h6>Phạm vi: ${d.loaiDichVu.loai}</h6>
            </div>   
            <div class="card-footer bg-primary">
                <h4 class="text-truncate text-light">Giá: <fmt:formatNumber value = "${d.gia}"/><small> vnđ</small></h4>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="<c:url value="/booking"/>" class="btn btn-danger" 
                       onclick="addtoOrder(${d.id}, '${d.ten}', ${d.gia})">Chọn dịch vụ
                    </a>
                </sec:authorize>
                <a href="<c:url value="/#contact"/>"><button class="btn btn-dv">Liên hệ tư vấn</button></a>
            </div>
        </div>

    </c:forEach>
</div>

