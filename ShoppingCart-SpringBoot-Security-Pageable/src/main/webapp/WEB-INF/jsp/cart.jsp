<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello</title>
    <link href="<c:url value="/css/style-cart.css" />" rel="stylesheet">
    <link href="<c:url value="/css/style-footer.css" />" rel="stylesheet">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"/>
    </script>
    <script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"/>
    </script>
</head>
<body>
<header>
    <div class="topHead d-flex" style="justify-content: space-between;">
        <div class="navbar" style="padding: 0; display: block;">
            <ul class="nav">
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="./">Trang Chủ</a></li>
                <li class="nav-item separator">
                    <div></div>
                </li>
                <li class="nav-item"><a class="nav-link" href="./order">Xem Order</a></li>
                <li class="nav-item separator">
                    <div></div>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Tải ứng
                    dụng</a></li>
                <li class="nav-item separator">
                    <div></div>
                </li>
            </ul>
        </div>
        <div class="navbar"
             style="padding: 0px 0px 10px 0px; display: block;">
            <ul class="nav">
                <li class="nav-item"><a class="nav-link active" href="#"><i
                        class="fa-regular fa-bell"></i> Thông Báo</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i
                        class="fa-regular fa-circle-question"></i> Hỗ Trợ</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i
                        class="fa-solid fa-earth-americas"></i> Tiếng Việt</a></li>
                <li class="nav-item separator">
                    <div></div>
                </li>
                <li class="nav-item"><a class="nav-link" href="logout">Đăng
                    Xuất</a></li>
            </ul>
        </div>
    </div>
</header>
<main>
    <div class="container">
        <div class="wrapper-head-cart d-flex">
            <div class="title-product">Sản Phẩm</div>
            <div class="title-price">Đơn Giá</div>
            <div class="title-quantity">Số Lượng</div>
            <div class="title-total-bill">Số Tiền</div>
            <div class="title-action">Thao Tác</div>
        </div>
        <c:forEach items="${orderDetailsList}" var="orderDetail">
            <div class="product-container">
                <div class="wrapper-margin-product">
                    <div class="wrapper-padding-product">
                        <div class="wrapper-product">
                            <div class="product">
                                <div class="product-image" style="background-image: url(<c:url value="/image/product/product1.jfif"/>);">
                                </div>
                                <div class="wrapper-name">
                                    <div class="product-name">${orderDetail.getProduct().getName()}</div>
                                </div>
                            </div>
                            <div class="space"></div>
                            <div class="price"><fmt:formatNumber type="number" maxFractionDigits="1" value="${orderDetail.getProduct().getPrice()}" />đ</div>
                            <div class="quantity">
                                <form action="decrease-product" method="post" class="d-flex">
                                    <input name="product-id" type="text" value="${orderDetail.getProduct().getId()}"
                                           style="display: none;">
                                    <button class="decrease d-flex">
                                        <svg enable-background="new 0 0 10 10" viewBox="0 0 10 10" x="0" y="0"
                                             class="shopee-svg-icon">
                                            <polygon
                                                    points="4.5 4.5 3.5 4.5 0 4.5 0 5.5 3.5 5.5 4.5 5.5 10 5.5 10 4.5">
                                            </polygon>
                                        </svg>
                                    </button>
                                </form>
                                <input class="quantity-input" type="text" role="spinbutton"
                                       value="${orderDetail.getQuantity() }">
                                <form action="increase-product" method="post" class="d-flex">
                                    <input name="product-id" type="text" value="${orderDetail.getProduct().getId()}"
                                           style="display: none;">
                                    <button class="increase d-flex">
                                        <svg enable-background="new 0 0 10 10" viewBox="0 0 10 10" x="0" y="0"
                                             class="shopee-svg-icon icon-plus-sign">
                                            <polygon
                                                    points="10 4.5 5.5 4.5 5.5 0 4.5 0 4.5 4.5 0 4.5 0 5.5 4.5 5.5 4.5 10 5.5 10 5.5 5.5 10 5.5">
                                            </polygon>
                                        </svg>
                                    </button>
                                </form>
                            </div>
                            <div class="total-price"><fmt:formatNumber type="number" maxFractionDigits="1" value="${orderDetail.getQuantity()*orderDetail.getProduct().getPrice()}" />đ</div>
                            <form action="remove-product" method="post" class="d-flex">
                                <input name="product-id" type="text" value="${orderDetail.getProduct().getId()}"
                                       style="display: none;">
                                <button style="border:none; background-color: #fff; margin-left:60px;"
                                        class="action">Xóa</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="checkout-detail">
            <div class="detail">
                <span>Tổng Thanh Toán</span>
                <div class="right-block">
                    <div class="price"><fmt:formatNumber type="number" maxFractionDigits="1" value="${totalAmount}" /><span>đ</span></div>
                    <div class="button">
                        <button type="button" class="btn btn-danger checkout-btn" onclick="location.href='./checkout-product'">Thanh Toán</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
<script src="<c:url value="/js/script.js"/>"></script>
</body>