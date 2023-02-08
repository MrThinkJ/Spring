<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <div class="topHead d-flex" style="justify-content: space-between;">
        <div class="navbar" style="padding: 0; display: block;">
            <ul class="nav">
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="./order">Xem đơn đặt hàng</a></li>
                <li class="nav-item separator">
                    <div></div>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Trở thành
                    Người bán Shopee </a></li>
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
        <div class="navbar" style="padding: 0px 0px 10px 0px; display: block;">
            <ul class="nav">
                <li class="nav-item"><a class="nav-link active" href="#"><i class="fa-regular fa-bell"></i> Thông
                    Báo</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa-regular fa-circle-question"></i> Hỗ
                    Trợ</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa-solid fa-earth-americas"></i> Tiếng
                    Việt</a></li>
            </ul>
        </div>
    </div>
    <div class="wrapHeaderSearch">
        <div class="headerSearch d-flex" style="justify-content: space-between;">
            <div class="logo d-flex">
                <div style="width: 47px; height: 48px; color: #fff;">
                    <i class="fa-brands fa-github fa-3x"></i>
                </div>
                <div>
                        <span style="font-size: 25px; margin-left: 10px; color: white;">MrThinkJ</span>
                </div>
            </div>
            <div class="wrapper-searchbar">
                <div class="searchbar d-flex">
                    <form action='home' method='post' class='d-flex'>
                        <div class="input">
                            <input name='search-input' type="text"
                                   style="border: none; width: 754px; height: 34px; padding-left: 10px; border-radius: 3px;"
                                   placeholder="Nhập sản phẩm bạn muốn tìm">
                        </div>
                        <div class="d-flex searchbtn">
                            <button class="d-flex">
                                <i class="fa-solid fa-magnifying-glass fa-xs"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <a class="cart d-flex" style="margin-right: 60px; color: white; font-size: 10px;" href="./cart">
                <i class="fa-solid fa-cart-shopping fa-2xl"></i>
            </a>
            <div class="arrow"></div>
            <div class="in-cart">
                <div class="product-in-cart">
                    ${headCart }
                    <c:forEach items="${productsInCart }" var="productInCart">
                        <div class="product-cart">
                            <div class="product-cart-image">
                            </div>
                            <div class="in-cart-product-name">
                                <div class="product-cart-name">
                                    <div class="name">Laptop</div>
                                    <div class="price">1000000</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</header>