<%-- 
    Document   : ql-ctphong
    Created on : Nov 15, 2021, 10:21:12 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class ="text-center text-danger">DANH SÁCH ĐƠN ĐẶT PHÒNG</h1>

<form action="">
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-5">
            <input class="form-control" type="text" name="kw" placeholder="Nhập mã hóa đơn hoặc khách hàng cần tìm "/>
        </div>
        <div>
            <button class="btn btn-danger">Tìm <i class="fa fa-search"></i></button>
        </div>
    </div>
</form>
<br>
<c:if test="${param.mess != null}">
    <div class="alert alert-primary">
        Hủy đặt phòng thành công!
    </div>
</c:if>
<table class="table table-striped">
    <tr>
        <th scope="col">Mã hóa đơn</th>
        <th scope="col">Tên khách hàng</th>
        <th scope="col">Tổng thanh toán <small>(vnđ)</small></th>
        <th scope="col">Ngày đặt phòng</th>
        <th scope="col">Trạng thái phòng</th>
    </tr>
    <c:forEach var="h" items="${hd}">
        <tr>
            <td>${h.id}</td>
            <td>${h.user.khachHang.ten}</td>
            <td><fmt:formatNumber value = "${h.tongTien}"/></td>
            <td><fmt:formatDate value="${h.ngayDat}" pattern="dd/MM/yyyy" /></td>
            <td>
                <a href="<c:url value="/admin/hoadon/ctdat?id=${h.id}"/>" class="btn">Chi tiết</a>
                <a href="<c:url value="/admin/hoadon/delete/${h.id}"/>" class="btn">Hủy</a>
            </td>
        </tr>
    </c:forEach>
</table>