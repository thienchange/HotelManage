<%-- 
    Document   : booking
    Created on : Oct 18, 2021, 6:30:50 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-danger">Xác nhận đặt phòng</h1>

<c:if test="${room == null}">
    <h5 class="text-danger">*chúng tôi sẽ liên hệ sau khi đặt phòng</h5>
    <i class="fa fa-hand-o-right" aria-hidden="true"></i>
    <a href="<c:url value="/"/>#rooms" class="text-primary">
        Đặt thêm phòng
    </a>
</c:if>
<c:if test="${room != null}">
    <table class="table">
        <tr>
            <th>Số phòng</th>
            <th>Loại phòng</th>
            <th>Thành tiền</th>
            <th>Số lượng khách</th>
            <th>Check-in</th>
            <th>Check-out</th>
        </tr>
        <c:forEach var="c" items="${room}">
            <tr>
                <td>${c.soPhong}</td>
                <td>${c.loaiPhong}</td>
                <td><fmt:formatNumber value = "${c.gia}"/>đ</td>
                <td class="form-group">
                    <input type="number" value="${c.soKhach}" 
                           min="1" max="4" id="slk" class="text-danger" disabled="true"/>
                </td>
                <td class="form-group">
                    <input type="date" 
                           value="<fmt:formatDate value="${c.checkin}" pattern="yyyy-MM-dd" />" 
                           id="DateIn" class="form-group text-primary" disabled="true"/>
                </td>
                <td class="form-group">
                    <input type="date"
                           value="<fmt:formatDate value="${c.checkout}" pattern="yyyy-MM-dd" />" 
                           id="DateOut" class="form-group text-primary" disabled="true"/>
                </td>
                <td>
                    <input type="button" value="Hủy" onclick="cancelBooking(${c.phongId})" class="btn btn-link" />
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${orderCounter != 0}">
        <table class="table">
            <tr>
                <th>Mã dịch vụ</th>
                <th>Tên dịch vụ</th>
                <th>Thành tiền</th>
                <th>Số lượng</th>
            </tr>
            <c:forEach var="s" items="${service}">
                <tr>
                    <td>${s.dichVuId}</td>
                    <td>${s.tenDvu}</td>
                    <td><fmt:formatNumber value = "${s.giaDvu}"/>đ</td>

                    <td class="form-group">
                        <input type="number" onblur="updateOrder(this, ${s.dichVuId})" value="${s.soDvu}" 
                               min="1" class="form-group" />
                    </td>
                    <td>
                        <input type="button" value="Hủy" onclick="deleteService(${s.dichVuId})" class="btn btn-link" />
                    </td>
                </tr>

            </c:forEach>
        </table>
    </c:if>
    <div><span id="msg"></span></div>
    <table  class="table">
        <tr>
            <td>
                <h5>Tổng thanh toán: <span id="${sumAmount}"><fmt:formatNumber value = "${bookingStats.amount}"/></span>đ</h5>
                <small class="text-danger">*bạn đang đặt <span id="orderCounter">${orderCounter}</span> dịch vụ</small>
            </td>
            <td>
                <c:if test="${room != null}">
                    <a href="<c:url value="/dichvu"/>" class="btn btn-warning">
                        Đặt dịch vụ
                    </a>
                </c:if>
                <a href="<c:url value="/phong"/>" class="btn btn-warning">
                    Đặt thêm phòng
                </a>
            </td>
            <td>
                <c:if test="${amount != 0 && bookingCounter != 0}">
                    <input type="button" onclick ="pay()" value="Xác nhận" class="btn btn-danger" />
                </c:if>
                <c:if test="${bookingCounter == 0}">
                    <h5 class="text-danger">*vui lòng đặt thêm phòng trước khi xác nhận</h5>
                </c:if>
            </td>
        <tr>
    </table>

</c:if>


