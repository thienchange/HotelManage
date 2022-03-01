<%-- 
    Document   : user-info
    Created on : Oct 29, 2021, 5:33:28 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Thông tin người dùng</h2>

<c:if test="${currentUser == null}" >
    <h5 class="text-danger">Bạn đã đăng kí thành công</h5>
    <i class="fa fa-hand-o-right" aria-hidden="true"></i>
    <a href="<c:url value="/login"/>" class="text-primary">
        Đăng nhập ngay
    </a>
</c:if>
<c:if test="${updateUser != null}">
    <div class="alert alert-primary">
        ${updateUser}
    </div>
</c:if>
<c:if test="${currentUser != null}" >
    <div class="container bootstrap snippets bootdey">
        <div class="panel-body inf-content">
            <div class="row">
                <div class="col-md-4">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <c:if test="${currentUser.avatar != null}" >
                            <img class="img-fluid rounded" src="${currentUser.avatar}" class="rounded" /> 
                        </c:if>

                        <c:if test="${currentUser.avatar == null}" >
                            <img class="img-fluid" src="<c:url value="/images/user.png" />" />
                        </c:if>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <div class="table-responsive">
                        <table class="table table-user-information">
                            <tbody>
                                <tr>        
                                    <td>
                                        <strong>
                                            <span class="fa fa-user-circle-o"></span> 
                                            Username                                                
                                        </strong>
                                    </td>
                                    <td class="text-danger">
                                        ${currentUser.user}
                                    </td>
                                </tr>
                                <tr>    
                                    <td>
                                        <strong>
                                            <span class="fa fa-info-circle"></span>    
                                            Tên người dùng                                                
                                        </strong>
                                    </td>
                                    <td class="text">
                                        ${kh.ten}    
                                    </td>
                                </tr>
                                <tr>        
                                    <td>
                                        <strong>
                                            <span class="fa fa-tablet"></span>
                                            Số điện thoại                                               
                                        </strong>
                                    </td>
                                    <td class="text">
                                        ${kh.sdt}    
                                    </td>
                                </tr>
                                <tr>        
                                    <td>
                                        <strong>
                                            <span class="fa fa-envelope-o"></span> 
                                            Email                                                
                                        </strong>
                                    </td>
                                    <td class="text">
                                        ${kh.email}
                                    </td>
                                </tr>
                                <tr>        
                                    <td>
                                        <strong>
                                            <span class="fa fa-address-book"></span>
                                            Địa chỉ                                              
                                        </strong>
                                    </td>
                                    <td class="text">
                                        ${kh.diaChi}   
                                    </td>
                                </tr>
                                <tr>        
                                    <td class="text">
                                        <a href="<c:url value="/user-info/updateuser/${currentUser.khachHang.id}"/>"><button class="btn">Chỉnh sửa thông tin</button></a> 
                                    </td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
    