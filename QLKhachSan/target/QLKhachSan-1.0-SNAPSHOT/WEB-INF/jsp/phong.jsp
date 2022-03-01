<%-- 
    Document   : phong
    Created on : Aug 18, 2021, 7:53:17 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class ="text-center text-danger">DANH SÁCH PHÒNG</h1>
<form action="">
    <div class="row">
        <div class="col-md-7">
            <input class="form-control" type="text" name="kw" 
                   placeholder="Nhập loại phòng (đơn/đôi/vip) hoặc mức giá bạn cần tìm kiếm"/>
        </div>
        <div>
            <button class="btn btn-danger">Tìm <i class="fa fa-search"></i></button>
        </div>
    </div>
</form>
<br>
<c:if test="${param.messUpdate != null}">
    <div class="alert alert-primary">
        Cập nhật thông tin phòng thành công !!!
    </div>
</c:if>
<div class="col-md-11">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <div class="col-md-6"><h6 style="color:#fff; margin-top: 7px;">
                    Khách sạn chúng tôi hiện cung cấp đến ${counter} phòng, vui lòng chọn</h6>
            </div>
            <c:forEach begin="1" end="${Math.ceil(counter/9)}" var="i">
                <li class="page-item"><a class="page-link" href="<c:url value="/phong" />?page=${i}">${i}</a></li> 
                </c:forEach>
            <div class="col-md-5"><h6 style="color:#fff; margin-top: 7px;">
                    để xem tất cả các phòng. Xin chân thành cảm ơn !!!</h6>
            </div>
        </ul>
    </nav>
</div>
<div class = "row">
    <c:forEach var="p" items="${phongks}">

        <div class="card col-md-4">
            <div class="card-body">
                <a href="<c:url value="/phong/${p.id}"/>">
                    <c:if test="${p.hinhanh != null && p.hinhanh.startsWith('https') == true}">
                        <img class="img-fluid" src="<c:url value="${p.hinhanh}" />" alt="${p.soPhong}" />       
                    </c:if>
                    <c:if test="${p.hinhanh == null || p.hinhanh.startsWith('https') == false}">
                        <img class="img-fluid" src="<c:url value="/images/vip.jpg" />" alt="${p.soPhong}" />       
                    </c:if>
                </a>

                <h4>Phòng: ${p.soPhong}</h4>
                <div class="row">
                    <h5 class="col-md-8 text-danger">Loại: ${p.loaiPhong.loai}</h5>
                    <h5>${p.loaiPhong.sl} người</h5>
                </div>

            </div>
            <div class="card-footer bg-warning">
                <h4 class="text-truncate text-dark">Giá: <fmt:formatNumber value = "${p.gia}"/><small> vnđ</small></h4>
                <a href="<c:url value="/phong/${p.id}"/>"><button class="btn">Chi tiết</button></a>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="<c:url value="/#contact"/>"><button class="btn">Liên hệ</button></a>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_STAFF')">
                    <a href="<c:url value="/admin/qlp/${p.id}"/>"><button class="btn">Cập nhật</button></a>
                </sec:authorize>
            </div>
        </div>

    </c:forEach>
</div>
