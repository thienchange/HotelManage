<%-- 
    Document   : index.jsp
    Created on : Aug 12, 2021, 2:39:47 PM
    Author     : ACER
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="now" class="java.util.Date" />

<!-- Header -->
<div class="w3-display-container w3-content" style="max-width:1500px;">
    <img class="w3-image" src="<c:url value="images/view.jpg" />" alt="The Hotel">
    <div class="w3-display-left w3-padding w3-col l6 m8">
        <div class="w3-container w3-red">
            <h2>Change Peace</h2>
        </div>
        <div class="w3-container w3-white w3-padding-16">
            <form action="<c:url value="/phong"/>" target="_blank">
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label><i class="fa fa-calendar-o"></i> Loại phòng</label>
                        <input class="w3-input w3-border" type="text" placeholder="Phòng đơn/đôi/vip" name="kw" required>
                    </div>
                    <div class="w3-half">
                        <label><i class="fa fa-money" aria-hidden="true"></i> Mức giá</label>
                        <input class="w3-input w3-border" type="text" placeholder="<fmt:formatNumber value = "650000"/> - <fmt:formatNumber value = "1500000"/>đ" name="kw">
                    </div>
                </div>
                <div class="w3-row-padding" style="margin:8px -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label><i class="fa fa-male"></i> Người lớn</label>
                        <input class="w3-input w3-border" type="number" value="1" name="Adults" min="1" max="4">
                    </div>
                    <div class="w3-half">
                        <label><i class="fa fa-child"></i> Trẻ em</label>
                        <input class="w3-input w3-border" type="number" value="0" name="Kids" min="0" max="4">
                    </div>
                </div>
                <button class="w3-button w3-dark-grey" type="submit"><i class="fa fa-search w3-margin-right"></i> Tìm phòng</button>
            </form>
        </div>
    </div>
</div>
<div class="w3-content" style="max-width:1532px;">

    <div class="w3-container w3-margin-top" id="rooms">
        <h3>Chúng tôi cam kết</h3>
        <p>Luôn mang đến cho bạn một trải nghiệm tuyệt vời nhất. Với phương châm
            khách hàng luôn là ưu tiên hàng đầu, chúng tôi tin vào năng lực và 
            chất lượng dịch vụ mà mình mang lại, đảm bảo đây sẽ là
            căn phòng thoải mái nhất của riêng bạn.
        </p>
    </div>

    <div class="w3-row-padding">
        <div class="w3-col m3">
            <label><i class="fa fa-calendar-o"></i> Check In</label>
            <input class="w3-input w3-border" type="text" placeholder="DD MM YYYY">
        </div>
        <div class="w3-col m3">
            <label><i class="fa fa-calendar-o"></i> Check Out</label>
            <input class="w3-input w3-border" type="text" placeholder="DD MM YYYY">
        </div>
        <div class="w3-col m2">
            <label><i class="fa fa-male"></i> Người lớn</label>
            <input class="w3-input w3-border" type="number" placeholder="1">
        </div>
        <div class="w3-col m2">
            <label><i class="fa fa-child"></i> Trẻ em</label>
            <input class="w3-input w3-border" type="number" placeholder="0">
        </div>
        <div class="w3-col m2">
            <label><i class="fa fa-search"></i> Tra cứu</label>
            <button class="w3-button w3-block w3-black">Tìm kiếm</button>
        </div>
    </div>

    <div class="w3-row-padding w3-padding-16">
        <div class="w3-third w3-margin-bottom">
            <img src="<c:url value="images/single.jpg" />" alt="Norway" style="width:100%">
            <div class="w3-container w3-white">
                <h3>Phòng đơn</h3>
                <h6 class="w3-opacity">Chỉ từ $29</h6>
                <p>Phòng đơn 1 người</p>
                <p>15m<sup>2</sup></p>
                <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i></p>
                <a href="<c:url value="/phong?kw=đơn"/>">
                    <button class="w3-button w3-block w3-black w3-margin-bottom">Xem ngay</button>
                </a>
            </div>
        </div>
        <div class="w3-third w3-margin-bottom">
            <img src="<c:url value="images/double.jpg" />" alt="Norway" style="width:100%">
            <div class="w3-container w3-white">
                <h3>Phòng đôi</h3>
                <h6 class="w3-opacity">Chỉ từ $35</h6>
                <p>Phòng vừa từ 2-3 người
                </p>
                <p>25m<sup>2</sup></p>
                <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i></p>
                <a href="<c:url value="/phong?kw=đôi"/>">
                    <button class="w3-button w3-block w3-black w3-margin-bottom">Xem ngay</button>
                </a>
            </div>
        </div>
        <div class="w3-third w3-margin-bottom">
            <img src="<c:url value="images/vip.jpg" />" alt="Norway" style="width:100%">
            <div class="w3-container w3-white">
                <h3>Phòng VIP</h3>
                <h6 class="w3-opacity">Chỉ từ $65</h6>
                <p>Phòng VIP tối đa 4 người
                </p>
                <p>40m<sup>2</sup></p>
                <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
                <a href="<c:url value="/phong?kw=vip"/>">
                    <button class="w3-button w3-block w3-black w3-margin-bottom">Xem ngay</button>
                </a>
            </div>
        </div>
    </div>

    <div class="w3-row-padding" id="about">
        <div class="w3-col l4 12">
            <h3>Về chúng tôi</h3>
            <h6>
                Khách sạn Change Peace tọa lạc gần Quảng trường 3/2 -
                nằm giữa trung tâm kinh tế và văn hóa của Thành Phố Rạch Giá, 
                chúng tôi mong muốn là cánh cửa đầu tiên ở thành phố biển này, 
                chào đón Quý khách về với Kiên Giang, miền đất sở hữu loại hình du 
                lịch đặc trưng là du lịch sinh thái miền đất vùng Tây Nam Bộ. 
                <br>
                Với chất lượng đạt chuẩn Quốc tế 4 sao,  Khách sạn Change Peace không chỉ đáp ứng 
                hoàn hảo nhu cầu nghỉ ngơi của Quý khách mà còn mang đến những giây phút thư giãn 
                giải trí tuyệt vời và để lại dư vị ấn tượng trong văn hóa ẩm thực nơi đây. 
                Khách sạn là sự kết hợp hài hòa của phong cách mang màu sắc sang trọng, 
                hiện đại và cổ kính bao gồm cả quần thể Nhà hàng, Bể Bơi, sân Tennis 
                và các khu vui chơi giải trí khác được quy tụ trong một khuôn viên 
                rộng lớn gần 15.000 m<sup>2</sup>. 
            </h6>
            <br>
            <p>Chấp nhận thanh toán: <i class="fa fa-credit-card w3-large"></i> <i class="fa fa-cc-mastercard w3-large"></i> <i class="fa fa-cc-amex w3-large"></i> <i class="fa fa-cc-cc-visa w3-large"></i><i class="fa fa-cc-paypal w3-large"></i></p>
        </div>
        <div class="w3-col l8 12">
            <!-- Image of location/map -->
            <img src="<c:url value="images/hotel.jpg" />" class="w3-image w3-greyscale" style="width:100%;">
        </div>
    </div>

    <div class="w3-row-padding w3-large w3-center" style="margin:32px 0">
        <div class="w3-third"><i class="fa fa-map-marker w3-text-red"></i> 162 qt 3/2, Rạch Giá, Kiên Giang</div>
        <div class="w3-third"><i class="fa fa-phone w3-text-red"></i> Điện thoại: +84 16216212</div>
        <div class="w3-third"><i class="fa fa-envelope w3-text-red"></i> Email: changepeace@gmail.com</div>
    </div>

    <div class="w3-panel w3-red w3-leftbar w3-padding-32">
        <h6><i class="fa fa-info w3-deep-orange w3-padding w3-margin-right"></i> 
            Nếu ở nơi khác, bạn phải dè chừng vì không thể mang thú cưng theo chuyến đi của mình thì
            đừng lo. Đến với Change Peace, bạn có thể mang theo người bạn đồng hành của mình
            đến khắp mọi nơi. Chỉ cần bạn yêu cầu, chúng tôi sẵn sàng phục vụ.

        </h6>
    </div>

    <div class="w3-container">
        <h3>Về sự phát triển</h3>
        <h6>Chúng tôi đang xây dựng mô hình dự án dinh thự biển. Đây sẽ là một bước tiến
            lớn với đẳng cấp dịch vụ đứng đầu ngành. Cùng chờ xem nhé</h6>
    </div>

    <div class="w3-row-padding w3-padding-16 w3-text-white w3-large">
        <div class="w3-half w3-margin-bottom">
            <div class="w3-display-container">
                <img src="<c:url value="images/villa.jpg" />" alt="Cinque Terre" style="width:100%">
                <span class="w3-display-bottomleft w3-padding">Mô hình biệt thự biển</span>
            </div>
        </div>
        <div class="w3-half">
            <div class="w3-row-padding" style="margin:0 -16px">
                <div class="w3-half w3-margin-bottom">
                    <div class="w3-display-container">
                        <img src="<c:url value="images/villa_1.jpg" />" alt="New York" style="width:100%">
                        <span class="w3-display-bottomleft w3-padding">Sang trọng</span>
                    </div>
                </div>
                <div class="w3-half w3-margin-bottom">
                    <div class="w3-display-container">
                        <img src="<c:url value="images/villa_2.jpg" />" alt="San Francisco" style="width:100%">
                        <span class="w3-display-bottomleft w3-padding">Quý phái</span>
                    </div>
                </div>
            </div>
            <div class="w3-row-padding" style="margin:0 -16px">
                <div class="w3-half w3-margin-bottom">
                    <div class="w3-display-container">
                        <img src="<c:url value="images/villa_3.jpg" />" alt="Pisa" style="width:100%">
                        <span class="w3-display-bottomleft w3-padding">Đẳng cấp</span>
                    </div>
                </div>
                <div class="w3-half w3-margin-bottom">
                    <div class="w3-display-container">
                        <img src="<c:url value="images/villa_4.jpg" />" alt="Paris" style="width:100%">
                        <span class="w3-display-bottomleft w3-padding">Lịch lãm</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="w3-container w3-padding-32 w3-black w3-opacity w3-card w3-hover-opacity-off" style="margin:32px 0;">
        <h2>Nhận ưu đãi ngay hôm nay!</h2>
        <p>Còn chần chờ gì nữa, gửi mail ngay nào</p>
        <label>E-mail</label>
        <input class="w3-input w3-border" type="text" placeholder="Địa chỉ email của bạn">
        <button type="button" class="w3-button w3-red w3-margin-top">Gửi</button>
    </div>

    <div class="w3-container" id="contact">
        <h2>Vui lòng đăng kí trước</h2>
        <p>Hoặc liên hệ với chúng tôi qua</p>
        <i class="fa fa-map-marker w3-text-red" style="width:30px"></i> 162 qt 3/2, Rạch Giá, Kiên Giang<br>
        <i class="fa fa-phone w3-text-red" style="width:30px"></i> Phone: +84 16216212<br>
        <i class="fa fa-envelope w3-text-red" style="width:30px"> </i> Email: changepeace@gmail.com<br>
        
        <br>
        <a href="<c:url value="/signup"/>">
            <p><button class="w3-button w3-black w3-padding-large" type="submit">Đăng kí ngay</button></p>
        </a>
    </div>

    <!-- End page content -->
</div>
<ul>
    <c:forEach var="p" items="${phongs}">
        <li>${p.soPhong} - ${p.id}</li>
    </c:forEach>
</ul>