<%-- 
    Document   : updatenv
    Created on : Nov 3, 2021, 9:03:26 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1 class="text-center text-danger">CẬP NHẬT NHÂN SỰ</h1>
<c:if test="${param.messUpdate != null}">
    <div class="alert alert-primary">
        Lỗi cập nhật !!! Vui lòng kiểm tra lại các thông tin
    </div>
</c:if>
<form:form class="" method="post" action="updateNhanVien" modelAttribute="nhanvien" enctype="multipart/form-data" >
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <form:hidden path="id" />
    <div class="form-row">
        <div class="col-md-4 form-group">
            <lable for="ten">Tên nhân viên</lable>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-id-badge" aria-hidden="true"></i></span>
                </div>
                <form:input type="text" id="name" path="ten" cssClass="form-control" />
            </div>
        </div>
        <div class="col-md-5 form-group">
            <lable for="mota">Email</lable>
            <div class="input-group">
                <form:input type="text" id="email" path="email" cssClass="form-control" />
                <div class="input-group-append">
                    <span class="input-group-text" id="basic-addon2">@example.com</span>
                </div>
            </div>
        </div>
    </div>      
    <div class="form-row">
        <div class="col-md-6 form-group">
            <lable for="gia">Địa chỉ</lable>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-address-book" aria-hidden="true"></i></span>
                </div>
                <form:input type="text" id="address" path="diaChi" cssClass="form-control" />
            </div>
        </div>
        <div class="col-md-3 form-group">
            <lable for="gia">Số điện thoại</lable>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-tablet" aria-hidden="true"></i></span>
                </div>
                <form:input type="text" id="phone" path="sdt" cssClass="form-control" />
            </div>
        </div>
    </div>
            
    <div class="form-row">
        <div class="col-md-5 form-group">
            <lable for="bphan">Bộ phận</lable>
                <form:select id="bphan" path="boPhan" cssClass="form-control">
                    <c:forEach items="${bophan}" var="b">
                    <option value="${b.id}">${b.ten}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="col-md-4 form-group">
            <lable for="cvu">Chức vụ</lable>
                <form:select id="cvu" path="chucVu" cssClass="form-control">
                    <c:forEach items="${chucvu}" var="c">
                    <option value="${c.id}">${c.ten}</option>
                </c:forEach>
            </form:select>
        </div>

    </div>

    <div class="form-group">
        <input type="submit" value="Cập nhật" class="btn btn-danger" />
    </div>
</form:form>
