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
    <link href="<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"/>
    </script>
    <script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"/>
    </script>
</head>
<body>
<header class="d-flex">
    <div class="title">Order Management</div>
</header>
<main>
    <div class="title d-flex">List Orders</div>
    <div class="list-orders">
        <div class="container">
            <div class="title-row d-flex">
                <div class="column">Id</div>
                <div class="column">Customer Name</div>
                <div class="column">Customer Address</div>
                <div class="column">Order Detail</div>
            </div>
            <div class="row d-flex">
                <c:forEach items="${ordersList}" var="order">
                    <div class="col col_${order.getId()}">
                        <div class="block" id="name">${order.getId() }</div>
                    </div>
                    <div class="col col_${order.getId()}">
                        <div class="block" id="price">${order.getCustomerName()}</div>
                    </div>
                    <div class="col col_${order.getId()}">
                        <div class="block" id="description">${order.getCustomerAddress()}</div>
                    </div>
                    <div class="col">
                        <div class="block">
                            <input type="text" class="pid"
                                   value="${order.getId()}" style="display: none;">
                            <button class="update" onclick="location.href='./orderdetails/${order.getId()}'">View Detail</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/script-cart.js"/>"></script>
</body>