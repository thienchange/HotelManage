<%-- 
    Document   : update-dv
    Created on : Nov 4, 2021, 12:47:47 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1 class="text-center text-danger">CẬP NHẬT DỊCH VỤ</h1>
<c:if test="${param.messUpdate != null}">
    <div class="alert alert-primary">
        ${param.messUpdate}
    </div>
</c:if>
<div class="row">
    <div class=" col-md-6">
        <c:if test="${dvu.hinhanh != null && dvu.hinhanh.startsWith('https') == true}">
            <img class="img-fluid" src="<c:url value="${dvu.hinhanh}" />" alt="${dvu.ten}" />       
        </c:if>
        <c:if test="${dvu.hinhanh == null || dvu.hinhanh.startsWith('https') == false}">
            <img class="img-fluid" src="<c:url value="/images/not_found.jpg" />" alt="${dvu.ten}" />       
        </c:if>
    </div>
    <form:form class="col-md-6" method="post" action="success" modelAttribute="dvu" enctype="multipart/form-data" >
        <form:errors path="*" cssClass="alert alert-danger" element="div" />
        <form:hidden path="id" />
        <div class="form-group">
            <lable for="ten">Tên dịch vụ</lable>
                <form:input type="name" id="name" path="ten" cssClass="form-control" />
                <form:errors path="ten" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="mota">Mô tả</lable>
                <form:textarea id="mota" path="mota" cssClass="form-control"></form:textarea>
            </div>

            <div class="form-group">
                <lable for="gia">Giá</lable>
                <form:input type="text" id="gia" path="gia" cssClass="form-control" />
                <form:errors path="gia" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="loai">Loại dịch vụ</lable>
                <form:select id="loai" path="loaiDichVu" cssClass="form-control">
                    <c:forEach items="${loaidvu}" var="l">
                    <option value="${l.id}">${l.loai}</option>
                </c:forEach>
            </form:select>
            <form:errors path="loaiDichVu" cssClass="text-danger" element="div" />
        </div>

        <div class="form-group">
            <lable for="file">Ảnh dịch vụ</lable>
                <form:input type="file" id="file" path="file" cssClass="form-control" />
        </div>

        <div class="form-group">
            <input type="submit" value="Cập nhật" class="btn btn-danger" />
        </div>
    </form:form>
</div>