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
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"/>
    </script>
    <script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"/>
    </script>
</head>
<body>
<mvc:form action="" id="add-form" method="post" modelAttribute="book">
    <div class='wrapper-update-form wrapper-form add-form' style="display: none">
        <div class='head-form d-flex'>
            <div class='title d-flex'>
                <div style='flex-shrink: 0; margin-right: 10px;'>Add Book</div>
                <mvc:input class='id-input' path='id' type='text' role='spinbutton' value='1'
                           style='background-color: #fff; border: none; display: none; width: 20px;'/>
                <button style="margin-left: 226px" type="button" class="btn-close" onclick="remove('add')" aria-label="Close"></button>
            </div>
        </div>
        <div class='main-form'>
            <mvc:input class='name' type='text' placeholder='Book Name' value='' path='name'/>
            <div class='padding-bottom'></div>
            <mvc:input class='author' type='text' placeholder='Book Author' value='' path='author'/>
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
            <div class='padding-bottom'></div>
            <button class='update-btn'> Cập Nhật</button>
        </div>
    </div>
</mvc:form>
<mvc:form action="" id="update-form" method="post" modelAttribute="book">
    <div class='wrapper-update-form wrapper-form update-form' style="display: none">
        <div class='head-form d-flex'>
            <div class='title d-flex'>
                <div style='flex-shrink: 0; margin-right: 10px;'>Update for Book</div>
                <mvc:input class='id-input' path='id' type='text' role='spinbutton' value='1'
                           style='background-color: #fff; border: none; display: none; width: 20px;'/>
                <mvc:input class='id-detail' path='bookDetails.id' role='spinbutton' type='text' value=''
                           style='display:none'/>
                <button style="margin-left: 170px" type="button" class="btn-close" onclick="remove('update')" aria-label="Close"></button>
            </div>
        </div>
        <div class='main-form'>
            <mvc:input class='name' type='text' placeholder='Book Name' value='' path='name'/>
            <div class='padding-bottom'></div>
            <mvc:input class='author' type='text' placeholder='Book Author' value='' path='author'/>
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
            <div class='padding-bottom'></div>
            <button class='update-btn'> Cập Nhật</button>
        </div>
    </div>
</mvc:form>
<mvc:form action="" id="delete-form" method="post"></mvc:form>
<main>
    <div class="title d-flex">Spring Web MVC DEMO</div>
    <div class='d-flex'>
        <mvc:form action="search" method="get">
            <div class="search d-flex">
                <input type="text" name="searchInput" placeholder="Search"
                       style="width: 400px; height: 40px; margin-top: 10px;">
                <button class="search-btn">Search</button>
            </div>
        </mvc:form>
        <button class="add">Add Book</button>
    </div>
    <div class="list-Book">
        <div class="container">
            <div class="title-row d-flex">
                <div class="column" style="width: 74px;">Id</div>
                <div class="column">Name</div>
                <div class="column">Author</div>
                <div class="column">ISBN</div>
                <div class="column">Price</div>
                <div class="column">Publish Date</div>
                <div class="column">Category</div>
                <div class="column">Action</div>
            </div>
            <div class="row d-flex">
                <c:forEach items="${bookEntityList}" var="book">
                    <div class="col-sm col_${book.getId()}">
                        <div class="block" id="id">${book.getId() }</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="name">${book.getName()}</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="author">${book.getAuthor()}</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="isbn">${book.bookDetails.getIsbn()}</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="price">${book.bookDetails.getPrice()}</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="publish-date">${book.bookDetails.getPublishDate()}</div>
                    </div>
                    <div style="display: none" class="col col_${book.getId()}">
                        <div class="block" id="number-of-page">${book.bookDetails.getNumberOfPage()}</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="category">${book.category.getName()}</div>
                    </div>
                    <div class="col col_${book.getId()}">
                        <div class="block" id="action">
                            <input type="text" class="pid"
                                   value="${book.getId()}" style="display: none;">
                            <button class="update">Update</button>
                            <button class="delete">Delete</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<script src="<c:url value="resources/js/home.js"/>"></script>
</body>