<<<<<<< HEAD
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello</title>
    <link href="<c:url value="/resources/css/style-header.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style-footer.css" />" rel="stylesheet">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"/>
    </script>
    <script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"/>
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="product">
        <div class="container" style="width: 1201px; margin-bottom: 30px;">
            <div class="row">
                <c:forEach items="${productList}" var="product">
                    <div class="col-2">
                        <a href="product.html">
                            <div class="wrapper-non-flex" style="height: 100%;">
                                <div class="wrapper-product d-flex">
                                    <div class="contain-img">
                                        <div class="wrapper-img">
                                            <img src="<c:url value="/resources/image/product/product1.jfif"/> " alt="">
                                        </div>
                                    </div>
                                    <div class="wrapper-text-product d-flex">
                                        <div class="wrapper-product-name d-flex">
                                            <div class="wrapper-name d-flex">
                                                <div class="product-name">
                                                    ${product.getName()}
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-detail d-flex">
                                            <div class="product-price">
                                                <span>
                                                    đ
                                                </span>
                                                <span>
                                                    <fmt:formatNumber type="number" maxFractionDigits="1" value="${product.getPrice()}"/>
                                                </span>
                                            </div>
                                            <div class="add-to-cart-btn">
                                                <form action="add" method="post">
                                                    <input value="${product.getId()}" name="id" style="display: none">
                                                    <button type="submit" class="btn btn-danger">Thêm vào giỏ</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
=======
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello</title>
    <link href="<c:url value="/resources/css/style-header.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style-footer.css" />" rel="stylesheet">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"/>
    </script>
    <script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"/>
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="product">
        <div class="container" style="width: 1201px; margin-bottom: 30px;">
            <div class="row">
                <c:forEach items="${productList}" var="product">
                    <div class="col-2">
                        <a href="product.html">
                            <div class="wrapper-non-flex" style="height: 100%;">
                                <div class="wrapper-product d-flex">
                                    <div class="contain-img">
                                        <div class="wrapper-img">
                                            <img src="<c:url value="/resources/image/product/product1.jfif"/> " alt="">
                                        </div>
                                    </div>
                                    <div class="wrapper-text-product d-flex">
                                        <div class="wrapper-product-name d-flex">
                                            <div class="wrapper-name d-flex">
                                                <div class="product-name">
                                                    ${product.getName()}
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-detail d-flex">
                                            <div class="product-price">
                                                <span>
                                                    đ
                                                </span>
                                                <span>
                                                    <fmt:formatNumber type="number" maxFractionDigits="1" value="${product.getPrice()}"/>
                                                </span>
                                            </div>
                                            <div class="add-to-cart-btn">
                                                <form action="add" method="post">
                                                    <input value="${product.getId()}" name="id" style="display: none">
                                                    <button type="submit" class="btn btn-danger">Thêm vào giỏ</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
>>>>>>> b0da8640a166fc3ea30658d2af083bb238490599
</body>