<%-- 
    Document   : login
    Created on : Aug 14, 2021, 11:25:36 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link href="<c:url value="/css/style_login.css" />" rel="stylesheet" />
<c:url value="/login" var="action" />

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Tên đăng nhập hoặc mật khẩu không đúng
    </div>
</c:if>
<c:if test="${err != null}">
    <div class="alert alert-success">
        ${err}
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Không có quyền truy cập!
    </div>
</c:if>
        <h3>Đăng nhập</h3>
        <form method="post" action="${action}" class="login">
            <div class="container">
                <div class="user">
                    
                    <input id="tentk" name="tentk" type="text" required/>
                    <label for="tentk">Tên đăng nhập</label>
                </div>
                <div class="user">
                    
                    <input id="mk" name="mk" type="password" required/>
                    <label for="mk">Mật khẩu</label>
                </div>
                <br>
                <div class="col-md-12">
                    <input class="col-md-6" type="submit" value="Đăng nhập" />
                    <p><a href="<c:url value="/signup"/>" >Bạn chưa có tài khoản ?</a></p>
                </div>
            </div>
        </form>

