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
    <link href="<c:url value="/resources/css/style-checkout.css" />" rel="stylesheet">
    <link href="<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/> "
          rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/webjars/jquery/3.6.0/jquery.js"/> "/>
    </script>
    <script type="text/javascript" src="<c:url value="/webjars/popper.js/2.9.3/umd/popper.min.js"/> "/>
    </script>
</head>
<body>
<div class="login_form">
    <h2 class="title">Checkout Form</h2>
    <mvc:form action="process-checkout" method="post" modelAttribute="orders">
        <div class="login_input">
            <mvc:input class="text_input text_input_name" type="text" path="customerName"/>
            <label class="label_input ${status}">Name</label>
            <div class="error">
                <span><mvc:errors path="customerName"/></span>
            </div>
        </div>
        <div class="login_input">
            <mvc:input class="text_input text_input_address" type="text" path="customerAddress"/>
            <label class="label_input" ${status}>Address</label>
            <div class="error">
                <span><mvc:errors path="customerAddress"/></span>
            </div>
        </div>
        <button class="process_btn">
            <div class="text">CHECKOUT</div>
            <span></span>
        </button>
    </mvc:form>
</div>
<script src="<c:url value="/resources/js/script-checkout.js"/>"></script>
</body>
</html>