/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function addtoBooking(id, soP, loaiP, gia) {
    event.preventDefault()
    let slk = document.getElementById("slk");
    let from = document.getElementById("DateIn");
    let to = document.getElementById("DateOut");
    var date = new Date();
    date = from.value;
    var out = new Date();
    out = to.value;
    fetch("/QLKhachSan/api/room", {
        method: 'post',
        body: JSON.stringify({
            "phongId": id,
            "soPhong": soP,
            "loaiPhong": loaiP,
            "gia": gia,
            "soKhach": slk.value,
            "soLuong": 1,
            "checkin": date,
            "checkout": out
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("bookingCounter")
        alert("Bạn đã đặt phòng? Vui lòng xác nhận trong mục Booking");
        counter.innerText = data
        let amount = document.getElementById("sumAmount")
        amount.innerText = data.amount
    })
}

function addtoOrder(idDvu, ten, giaDvu) {
    fetch("/QLKhachSan/api/service", {
        method: 'post',
        body: JSON.stringify({
            "dichVuId": idDvu,
            "tenDvu": ten,
            "giaDvu": giaDvu,
            "soDvu": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("orderCounter")
        let amount = document.getElementById("sumAmount")
        var mess = alert("Bạn đã thêm 1 dịch vụ");
        counter.innerText = data.countDvu
        amount.innerText = data.amount
        document.getElementById("msg").innerText = mess;
    })
}

function updateBooking(obj, phongId) {
    let cin = document.getElementById("DateIn");
    let cout = document.getElementById("DateOut");
    fetch("/QLKhachSan/api/room", {
        method: 'put',
        body: JSON.stringify({
            "phongId": phongId,
            "soPhong": "",
            "gia": 0,
            "soLuong": 0,
            "soKhach": obj.value,
            "checkin": cin.value,
            "checkout": cout.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        alert(s.value)
        return res.json();
    }).then(function (data) {
        let s = document.getElementById("slk");
        s.innerHTML = data.slk;
    });
}

function updateDate(from, to, phongId) {
//    to = document.getElementById("DateOut");
    from = document.getElementById("DateIn");
    var date = new Date();
    date = from.value;
    var out = new Date();
    out = to.value;
    let l = document.getElementById("slk");
    fetch("/QLKhachSan/api/room", {
        method: 'put',
        body: JSON.stringify({
            "phongId": phongId,
            "soPhong": "",
            "gia": 0,
            "soLuong": 0,
            "soKhach": l.value,
            "checkin": date,
            "checkout": out
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let l = document.getElementById("slk");
        let fromDate = document.getElementById("DateIn");
        let toDate = document.getElementById("DateOut");
        l.innerText = date.slk;
        fromDate.innerText = data.ngayIn;
        toDate.innerText = data.ngayOut;
    });
}

function updateOrder(obj, dvuId) {
    fetch("/QLKhachSan/api/service", {
        method: 'put',
        body: JSON.stringify({
            "dichVuId": dvuId,
            "tenDvu": "",
            "giaDvu": 0,
            "soDvu": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("orderCounter")
        let amount = document.getElementById("sumAmount")
        location.reload()
        var mess = alert("Bạn đã cập nhật số lượng dịch vụ");
        document.getElementById("msg").innerText = "Đang cập nhật thanh toán";
        counter.innerText = data.countDvu
        amount.innerText = data.amount
    })
}

function cancelBooking(phongId) {
    if (confirm("Bạn chắc chắn hủy phòng đang đặt?") == true) {
        fetch(`/QLKhachSan/api/room/${phongId}`, {
            method: "delete"
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
//            row.style.display = "none"
            document.getElementById("msg").innerText = "Đang cập nhật thanh toán";
            let counter = document.getElementById("bookingCounter")
            counter.innerText = data.counter
            location.reload()
            let amount = document.getElementById("sumAmount")
            amount.innerText = data.amount
            location.reload()
        })
    }
}

function deleteService(dvuId) {
    if (confirm("Bạn có muốn hủy dịch vụ?") == true) {
        fetch(`/QLKhachSan/api/service/${dvuId}`, {
            method: "delete"
        }).then(function (res) {
            var mess = alert("Bạn đã xóa dịch vụ");
            document.getElementById("msg").innerText = "Đang cập nhật thanh toán";
            location.reload()
            return res.json()
        }).then(function (data) {
            let counter = document.getElementById("orderCounter")
            counter.innerText = data.countDvu
            let amount = document.getElementById("sumAmount")
            amount.innerText = data.amount
            location.reload()
        })
    }
}

function pay() {
    let vao = document.getElementById("DateIn")
    let ra = document.getElementById("DateOut")
    let sk = document.getElementById("slk")

    var firstDate = new Date(vao.value);
    var secondDate = new Date(ra.value);

    var now = new Date();

    if (sk.value < 1 || sk.value > 4)
        alert("Vui lòng kiểm tra lại số lượng khách !!!")
    else
    if (firstDate <= now)
        alert("Ngày checkin sau hiện tại 1 ngày. Vui lòng hủy phòng và đặt lại !!!");
    else
    if (firstDate > secondDate)
        alert("Ngày checkout không hợp lệ. Vui lòng hủy phòng và đặt lại !!!");
    else
    {
        if (confirm("Xác nhận đặt phòng?") == true) {
            fetch("/QLKhachSan/api/pay", {
                method: "post"
            }).then(function (res) {
                return res.json();
            }).then(function (code) {
                console.info(code);
                location.reload();
                alert("Bạn đã đặt phòng thành công");
            })
        }
    }
}
