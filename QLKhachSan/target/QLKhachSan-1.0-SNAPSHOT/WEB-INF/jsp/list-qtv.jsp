<%-- 
    Document   : list-qtv
    Created on : Nov 15, 2021, 7:55:08 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center text-primary">Danh sách quản trị viên</h2>
<c:if test="${param.mess != null}">
    <div class="alert alert-success">
        Xóa quyền quản trị thành công !!!
    </div>
</c:if>
<table class="table table-bordered">
    <tr>
        <th scope="col">Mã quản trị viên</th>
        <th scope="col">Quản trị viên</th>
        <th scope="col">Role</th>
        <th scope="col">Quản trị tài khoản</th>
    </tr>
    <c:forEach var="q" items="${qtv}">
        <tr>
            <td>${q.id}</td>
            <td>${q.user}</td>
            <td>${q.quyenUser}</td>
            <td><a href="<c:url value="/admin/qlnv/qtv/${q.id}"/>" class="btn">Vô hiệu hóa</a></td>
        </tr>
    </c:forEach>
</table>
