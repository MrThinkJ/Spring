$(document).ready(function () {
    $('.checkout-btn').click(function(){
        let html = "<div class='head'>"+
        "<span>Thông tin người đặt hàng</span>"+
        "</div>"+
        "<div class='body'>"+
        "<div class='input'>"+
        "    <label for='customerName'>Tên Khách Hàng</label>"+
        "    <input id='customerName' type='text' name='customerName'>"+
        "</div>"+
        "<div class='input'>"+
        "    <label for='customerAddress'>Địa Chỉ Khách Hàng</label>"+
        "    <input id='customerAddress' type='text' name='customerAddress'>"+
        "</div>"+
        "</div>"+
        "<div class='foot'>"+
        "<button type='submit' class='btn btn-danger'>Xác Nhận</button>"+
        "<button onclick='remove()' type='button' class='btn btn-dark close-form-btn'>Đóng</button>"+
        "</div>";
        document.getElementById('order-form').innerHTML = html;
        $(document.getElementsByClassName('checkout-form')).css('display', 'block');
        ($(document.getElementsByClassName('checkout-form'))).addClass('active');
        ($(document.getElementsByTagName('header'))).addClass('blur');
        ($(document.getElementsByTagName('main'))).addClass('blur');
    })
})
function remove(){
    let html = '';
    document.getElementById('order-form').innerHTML = html;
    $(document.getElementsByClassName('checkout-form')).css('display', 'none');
    ($(document.getElementsByClassName('checkout-form'))).removeClass('active').addClass('out');
    ($(document.getElementsByTagName('header'))).removeClass('blur');
    ($(document.getElementsByTagName('main'))).removeClass('blur');
}