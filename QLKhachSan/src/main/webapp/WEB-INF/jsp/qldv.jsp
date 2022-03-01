<%-- 
    Document   : qldv
    Created on : Oct 17, 2021, 10:00:14 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class ="text-center text-danger">DANH SÁCH DỊCH VỤ</h1>
<form action="">
    <div class="row">
        <div class="col-md-7">
            <input class="form-control" type="text" name="kw" placeholder="Nhập dịch vụ bạn cần tìm "/>
        </div>
        <div>
            <button class="btn btn-danger">Tìm <i class="fa fa-search"></i></button>
        </div>
        <div class="col-md-2">
            <a href="<c:url value="/admin/qldv/add"/>" class="btn btn-danger" >Thêm dịch vụ</a>
        </div>
    </div>
</form>
<br>
<c:if test="${param.mess != null}">
    <div class="alert alert-primary">
        Xóa dịch vụ thành công!
    </div>
</c:if>
<c:if test="${param.messUpdate != null}">
    <div class="alert alert-primary">
        Cập nhật dịch vụ thành công !!!
    </div>
</c:if>
<table class="table table-striped">
    <tr>
        <th scope="col">Mã dịch vụ</th>
        <th scope="col">Tên dịch vụ</th>
        <th scope="col">Đơn giá(vnđ)</th>
        <th scope="col"></th>
    </tr>
    <c:forEach var="d" items="${dvu}">
        <tr>
            <td>${d.id}</td>
            <td>${d.ten}</td>
            <td><fmt:formatNumber value = "${d.gia}"/></td>
            <td>
                <a href="<c:url value="/admin/qldv/update/${d.id}"/>" class="btn fa fa-edit"></a>
                <a href="<c:url value="/admin/qldv/delete/${d.id}"/>" class="btn fa fa-recycle"></a>
            </td>
        </tr>
    </c:forEach>
</table>
