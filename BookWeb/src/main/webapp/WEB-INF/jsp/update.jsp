<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link href="<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/> "
          rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/webjars/jquery/3.6.0/jquery.js"/> "/>
    </script>
    <script type="text/javascript" src="<c:url value="/webjars/popper.js/2.9.3/umd/popper.min.js"/> "/>
    </script>
</head>
<body>
<mvc:form action="/BookWeb/process-update" id="update-form" cssStyle="display: block" method="post" modelAttribute="book">
    <div class='wrapper-update-form wrapper-form update-form' style="display: block">
        <div class='head-form d-flex'>
            <div class='title d-flex'>
                <div style='flex-shrink: 0; margin-right: 10px;'>Update for Book</div>
                <mvc:input class='id-input' path='id' type='text' role='spinbutton' value=''
                           style='background-color: #fff; border: none; display: none; width: 20px;'/>
                <mvc:input class='id-detail' path='bookDetails.id' role='spinbutton' type='text' value=''
                           style='display:none'/>
                <button style="margin-left: 170px" type="button" class="btn-close" onclick="remove()" aria-label="Close"></button>
            </div>
        </div>
        <div class='main-form'>
            <mvc:input class='name' type='text' placeholder='Book Name' value='' path='name'/>
            <mvc:errors path="name" cssClass="error"/>
            <div class='padding-bottom'></div>
            <mvc:input class='author' type='text' placeholder='Book Author' value='' path='author'/>
            <mvc:errors path="author" cssClass="error"/>
            <div class='padding-bottom'></div>
            <mvc:input class='isbn' type='text' placeholder='Book Isbn' value='' path='bookDetails.isbn'/>
            <div class='padding-bottom'></div>
            <mvc:input class='price' type='text' placeholder='Book Price' value='' path='bookDetails.price'/>
            <div class='padding-bottom'></div>
            <mvc:input class='publish-date' type='date' placeholder='Publish Date' value=''
                       path='bookDetails.publishDate'/>
            <div class='padding-bottom'></div>
            <mvc:input class='number-of-pages' type='number' placeholder='Number Of Page' value=''
                       path='bookDetails.numberOfPage'/>
            <div class='padding-bottom'></div>
            <mvc:select path="category.id" class="category">
                <mvc:option value="0" label="--- select ---"/>
                <mvc:options items="${categoryList}"/>
            </mvc:select>
            <mvc:errors path="category.id" cssClass="error"/>
            <div class='padding-bottom'></div>
            <button class='update-btn'> UPDATE</button>
        </div>
    </div>
</mvc:form>
</body>