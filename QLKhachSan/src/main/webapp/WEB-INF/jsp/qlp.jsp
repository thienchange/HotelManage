<%-- 
    Document   : qlp
    Created on : Aug 22, 2021, 6:01:37 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class ="text-center text-danger">CẬP NHẬT THÔNG TIN PHÒNG</h1>

<c:if test="${param.messUpdate != null}">
    <div class="alert alert-primary">
        ${param.messUpdate}
    </div>
</c:if>

<div class="row">
    <form:form class="col-md-6" method="post" action="success" modelAttribute="phongks" enctype="multipart/form-data" >
        <form:hidden path="id" />
        <form:hidden path="loaiPhong.id" />
        <div class="form-group">
            <lable for="soPhong">Số phòng</lable>
                <form:input type="soPhong" id="soPhong" path="soPhong" cssClass="form-control" />
                <form:errors path="soPhong" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="mota">Mô tả</lable>
                <form:textarea rows="6" id="mota" path="mota" cssClass="form-control"></form:textarea>
                <form:errors path="mota" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="gia">Giá phòng</lable>
                <form:input type="text" id="gia" path="gia" cssClass="form-control" />
                <form:errors path="gia" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="lphong">Loại phòng</lable>
                <form:select id="lphong" path="loaiPhong" cssClass="form-control">
                    <c:forEach items="${lphong}" var="l">
                    <option value="${l.id}">${l.loai}</option>
                </c:forEach>
            </form:select>
            <form:errors path="loaiPhong" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="file">Hình ảnh</lable>
                <form:input type="file" id="file" path="file" cssClass="form-control" />
        </div>

        <div class="form-group">
            <input type="submit" value="Cập nhật" class="btn btn-danger" />
        </div>
    </form:form>
    <div class=" col-md-6">
        <c:if test="${phongks.hinhanh != null && phongks.hinhanh.startsWith('https') == true}">
            <img class="img-fluid" src="<c:url value="${phongks.hinhanh}" />" alt="${phongks.soPhong}" />       
        </c:if>
        <c:if test="${phongks.hinhanh == null || phongks.hinhanh.startsWith('https') == false}">
            <img class="img-fluid" src="<c:url value="/images/not_found.jpg" />" alt="${phongks.soPhong}" />       
        </c:if>
    </div>
</div>
