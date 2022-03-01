<%-- 
    Document   : user-update
    Created on : Oct 30, 2021, 8:10:42 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Cập nhật thông tin người dùng</h2>
<c:if test="${updateUser != null}">
    <div class="alert alert-danger">
        ${updateUser}
    </div>
</c:if>
<form:form method="post" action="success" enctype ="multipart/form-data" modelAttribute="kh">
    <form:hidden path="id" />
    <table class="table">
        <tr>
            <td>
                <form:errors path="*" cssClass="text-danger" element="div" />
            </td>
            <td>
                <div class="col-md-9">
                    <label for="basic-url">Họ tên</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-id-badge" aria-hidden="true"></i></span>
                        </div>
                        <form:input id="name" type="text" class="form-control" 
                                    aria-describedby="basic-addon1" path="ten" />
                    </div>
                    <label for="basic-url">Email</label>
                    <div class="input-group mb-3">
                        <form:input id="email" type="text" class="form-control" 
                                    aria-describedby="basic-addon1" path="email" />   
                        <div class="input-group-append">
                            <span class="input-group-text" id="basic-addon2">@example.com</span>
                        </div>
                    </div>
                    <label for="basic-url">Địa chỉ</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-address-book" aria-hidden="true"></i></span>
                        </div>
                        <form:input id="address" type="text" class="form-control" 
                                    aria-describedby="basic-addon1" path="diaChi" />
                    </div>
                    <label for="basic-url">Số điện thoại</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1"><i class="fa fa-tablet" aria-hidden="true"></i></span>
                        </div>
                        <form:input id="phone" type="text" class="form-control" 
                                    aria-describedby="basic-addon1" path="sdt" />
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input class="btn" type="submit" value="Cập nhật" />
            </td>
        </tr>
    </table>  
</form:form>

