<%-- 
    Document   : chitiet-dat
    Created on : Nov 15, 2021, 2:27:01 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h2 class="text-center text-success">Chi tiết đặt phòng</h2>

<table class="table table-striped">
    <tr>
        <td>Mã hóa đơn: ${hdkh.id}</td>
        <td>Khách hàng: ${hdkh.user.khachHang.ten}</td>
        <td>Ngày giờ đặt: <fmt:formatDate value="${hdkh.ngayDat}" pattern="dd/MM/yyyy HH:mm" /></td>
        <td>Tổng thanh toán: <fmt:formatNumber value = "${hdkh.tongTien}"/><small>đ</small></td>
    </tr>
</table>
<c:forEach var="c" items="${ctp}">
    <div class="row">
        <div class=" col-md-4">
            <c:if test="${c.phong.hinhanh != null && c.phong.hinhanh.startsWith('https') == true}">
                <img class="img-fluid" src="<c:url value="${c.phong.hinhanh}" />" alt="${c.phong.soPhong}" />       
            </c:if>
            <c:if test="${c.phong.hinhanh == null || c.phong.hinhanh.startsWith('https') == false}">
                <img class="img-fluid" src="<c:url value="/images/vip.jpg" />" alt="${c.phong.soPhong}" />       
            </c:if>
        </div>
        <div class=" col-md-8">
            <table class="table table-bordered">
                <tbody>
                    <tr>        
                        <td>
                            <strong>
                                Phòng                                       
                            </strong>
                        </td>
                        <td class="text-danger">
                            ${c.phong.soPhong} - ${c.phong.loaiPhong.loai}
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                                Đơn giá <i class="fa fa-money" aria-hidden="true"></i>                                               
                            </strong>
                        </td>
                        <td class="text">
                            <fmt:formatNumber value = "${c.donGia}"/> <small>VNĐ</small>   
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                                Check-in <i class="fa fa-sign-in" aria-hidden="true"></i>                                                
                            </strong>
                        </td>
                        <td class="text">
                            <fmt:formatDate value="${c.checkin}" pattern="dd/MM/yyyy HH:mm" />
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                                Check-out <i class="fa fa-sign-out" aria-hidden="true"></i>                                             
                            </strong>
                        </td>
                        <td class="text">
                            <fmt:formatDate value="${c.checkout}" pattern="dd/MM/yyyy HH:mm" />  
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                                Số khách <i class="fa fa-street-view" aria-hidden="true"></i>                                            
                            </strong>
                        </td>
                        <td class="text">
                            ${c.soLuongKhach}  
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

    </div>
</c:forEach>
<div class="row">
    <c:forEach var="d" items="${ctdv}">

        <div class=" col-md-6">
            <table class="table table-bordered">
                <tbody>
                    <tr>        
                        <td>
                            <strong>
                                Dịch vụ                                               
                            </strong>
                        </td>
                        <td class="text-danger">
                            ${d.dichVu.ten}
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                                Đơn giá <i class="fa fa-money" aria-hidden="true"></i>                                               
                            </strong>
                        </td>
                        <td class="text">
                            <fmt:formatNumber value = "${d.gia}"/> <small>VNĐ</small>   
                        </td>
                    </tr>
                    <tr>        
                        <td>
                            <strong>
                                Số lượng <i class="fa fa-gift" aria-hidden="true"></i>                                          
                            </strong>
                        </td>
                        <td class="text">
                            ${d.soDvu}  
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

    </c:forEach>
</div>
