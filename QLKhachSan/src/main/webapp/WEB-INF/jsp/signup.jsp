<%-- 
    Document   : hello
    Created on : Aug 2, 2021, 3:57:08 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url value="/signup" var="action" />
<c:if test="${err != null}">
    <div class="alert alert-danger">
        ${err}
    </div>
</c:if>

<h3>Đăng ký thông tin người dùng</h3>
    <small class="text-danger">(*) là các trường bắt buộc đăng kí</small>
    <form:form method="post" action="${action}" enctype ="multipart/form-data" modelAttribute="user" id="myForm">
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="name" class="text-dark">Họ tên</label> *</lable>
                <div class="col-sm-6">
                <form:input id="name" type="text" path="khachHang.ten" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="email" class="text-dark">Email</label> *</lable>
                <div class="col-sm-6">
                <form:input id="email" type="text" path="khachHang.email" class="form-control"/>
                <small id="emailHelp" class="form-text text-muted">myEmail@sample.com</small>
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 col-form-label">Địa chỉ</label>
                <div class="col-sm-6">
                <form:input id="address" type="text" path="khachHang.diaChi" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="phone" class="text-dark">Số điện thoại</label> *</lable>
                <div class="col-sm-6">
                <form:input id="phone" type="text" path="khachHang.sdt" class="form-control"/>
                <small id="emailHelp" class="form-text text-muted">Số điện thoại 8-12 số</small>
                </div>
            </div>
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="user" class="text-dark">Tài khoản</label> *</lable>
                <div class="col-sm-6">
                <form:input id="tentk" name="tentk" type="text" path="user" class="form-control"/>
                <form:errors path="user" cssClass="text text-danger" element="div" />
                </div>
            </div>
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="passwork" class="text-dark">Mật khẩu</label> *</lable>
                <div class="col-sm-6">
                <form:input id="mk" name="mk" type="password" path="pass" class="form-control"/>
                <form:errors path="pass" cssClass="text text-danger" element="div" />
                </div>
            </div>
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="confirm-password" class="text-dark">Xác nhận mật khẩu</label> *</lable>
                <div class="col-sm-6">
                <form:input id="confirm-password" name="mk" type="password" path="confirmPassword" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <lable class="text-danger col-sm-2"><label for="avatar" class="text-dark">Avatar</label> *</lable>
                <div class="col-sm-6">
                <form:input id="avatar" name="avt" type="file" path="file" class="form-control-file"/>
                </div>
            </div>
            <br>
            <div class="form-group col-md-6">
            <input class="col-md-12 btn" type="submit" value="Đăng ký" />
            <p style="text-align: center;"><a href="<c:url value="/login"/>" >Bạn đã có tài khoản ?</a></p>
            </div>
    </form:form>
