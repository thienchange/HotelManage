<%-- 
    Document   : qlnv
    Created on : Oct 31, 2021, 10:03:04 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class ="text-center text-danger">NHÂN SỰ CÔNG TY</h1>
<table class="table table-borderless">
    <thead class="thead-light">
        <tr>
            <th scope="col">
                <a href="<c:url value="/admin/qlnv/qtv"/>" class="btn btn-danger" >Quản trị viên</a>
                <a href="<c:url value="/admin/qlnv/add"/>" class="btn btn-danger" >Thêm nhân viên</a>
            </th>
            <th scope="col">
                <form action="">
                <div class="row">
                <div class="col-md-8">
                        <input class="form-control" type="text" name="kw" placeholder="Nhập tên nhân viên hoặc bộ phận"/>
                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-danger"><i class="fa fa-search"></i></button>
                    </div>
                </div>
                </form>
            </th>
        </tr>
    </thead>
</table>
<c:if test="${param.mess != null}">
    <div class="alert alert-primary">
        Xóa nhân viên thành công!
    </div>
</c:if>    
<c:if test="${param.messUpdate != null}">
    <div class="alert alert-primary">
        Cập nhật thông tin nhân viên thành công!
    </div>
</c:if> 
<table class="table">
    <tr class="thead-dark">
        <th scope="col">Mã nhân viên</th>
        <th scope="col">Tên nhân viên</th>
        <th scope="col">Chức vụ</th>
        <th scope="col">Bộ phận</th>
    </tr>
    <c:forEach var="n" items="${nhanvien}">
        <tr>
            <td>${n.id}</td>
            <td>${n.ten}</td>
            <td>${n.chucVu.ten}</td>
            <td>${n.boPhan.ten}</td>
            <td>
                <a href="<c:url value="/admin/qlnv/update/${n.id}"/>" class="btn fa fa-edit"></a>
                <a href="<c:url value="/admin/qlnv/delete/${n.id}"/>" class="btn fa fa-recycle"></a>
            </td>
        </tr>
    </c:forEach>
</table>