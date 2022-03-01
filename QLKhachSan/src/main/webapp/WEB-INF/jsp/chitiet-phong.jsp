<%-- 
    Document   : chitiet-phong
    Created on : Oct 17, 2021, 8:46:18 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="now" class="java.util.Date" />

<h2 class="text-secondary">Thông tin phòng</h2>
<div class="row">
    <div class=" col-md-6">
        <c:if test="${phongs.hinhanh != null && phongs.hinhanh.startsWith('https') == true}">
            <img class="img-fluid" src="<c:url value="${phongs.hinhanh}" />" alt="${phongs.soPhong}" />       
        </c:if>
        <c:if test="${phongs.hinhanh == null || phongs.hinhanh.startsWith('https') == false}">
            <img class="img-fluid" src="<c:url value="/images/vip.jpg" />" alt="${phongs.soPhong}" />       
        </c:if>
    </div>
    <div class=" col-md-6">
        <h1>Phòng ${phongs.soPhong}</h1>
        <p class="text-danger">Giá: <fmt:formatNumber value = "${phongs.gia}"/> <small>đ</small> /đêm</p> 
        <p>${phongs.mota}</p>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="<c:url value="/login"/>"><button class="btn">Đặt ngay</button></a>
        </c:if>
        <sec:authorize access="hasRole('ROLE_USER')">
            <table class="table">
                <thead
                    <tr>
                <th>Check-in</th>
                <th>Check-out</th>
                <th>Số khách</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="date" 
                                   value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />" 
                                   id="DateIn" class="form-group" />
                        </td>
                        <td>
                            <input type="date" 
                                   value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />" 
                                   id="DateOut" class="form-group" />
                        </td>
                        <td class="form-group">
                            <input type="number" onblur="updateBooking(this, ${phongs.id})" value="${phongs.loaiPhong.sl}" 
                                   min="1" max="${phongs.loaiPhong.sl}" id="slk" class="form-group" />
                        </td>
                    </tr>
                    <tr>
                <small class="text-danger">*lưu ý: Khách sạn chỉ nhận checkin sau 1 ngày kể từ ngày đặt</small> 
                </tr>
                </tbody>
            </table>
            <a href="<c:url value="javascript:;"/>" class="btn btn-danger" 
               onclick="addtoBooking(${phongs.id}, '${phongs.soPhong}',
                               '${phongs.loaiPhong.loai}', ${phongs.gia})">Đặt phòng</a>
        </sec:authorize>
    </div>
</div>
        
        <script></script>
