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
    <link href="<c:url value="/resources/css/style-order.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style-footer.css" />" rel="stylesheet">
    <link href="<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/> "
          rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/webjars/jquery/3.6.0/jquery.js"/> "/>
    </script>
    <script type="text/javascript" src="<c:url value="/webjars/popper.js/2.9.3/umd/popper.min.js"/> "/>
    </script>
</head>
<body>
<header class="d-flex">
    <div class="title">Order Details</div>
</header>
<main>
    <div class="title d-flex">List Orders</div>
    <div class="list-orders">
        <div class="container">
            <div class="title-row d-flex">
                <div class="column">Id</div>
                <div class="column">Product Name</div>
                <div class="column">Product Price</div>
                <div class="column">Quantity</div>
            </div>
            <div class="row d-flex">
                <c:forEach items="${orderDetailsList}" var="orderdetail">
                    <div class="col col_${orderdetail.getId()}">
                        <div class="block" id="name">${orderdetail.getId() }</div>
                    </div>
                    <div class="col col_${orderdetail.getId()}">
                        <div class="block" id="price">${orderdetail.getProduct().getName()}</div>
                    </div>
                    <div class="col col_${orderdetail.getId()}">
                        <div class="block" id="description">${orderdetail.getProduct().getPrice()}</div>
                    </div>
                    <div class="col">
                        <div class="block" id="quantity">${orderdetail.getQuantity()}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <nav class="page_nav">
        <ul class="pagination">
            <c:forEach var="page" begin="1" end="${numberOfPages}">
                <c:choose>
                    <c:when test="${currentPage == page}">
                        <li class="page_item active"><a class="page_link" href="./${orderId}?page=${page}">${page}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page_item"><a class="page_link" href="./${orderId}?page=${page}">${page}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </nav>
</main>
<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/script-cart.js"/>"></script>
</body>