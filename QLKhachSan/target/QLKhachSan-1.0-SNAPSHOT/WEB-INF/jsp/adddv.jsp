<%-- 
    Document   : qldv
    Created on : Aug 21, 2021, 11:12:09 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2 class="text-primary">THÊM THÔNG TIN QUẢN LÝ DỊCH VỤ</h2>
<c:url value="/admin/qldv/add" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<form:form class="col-md-6" method="post" action="${action}" modelAttribute="dvu" enctype="multipart/form-data" >
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
        <input type="submit" value="Thêm dịch vụ" class="btn btn-danger" />
    </div>
</form:form>
