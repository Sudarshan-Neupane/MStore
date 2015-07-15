<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MStore :: Categories</title>
        <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/admin.style.css'/>" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
        <script type="text/javascript" src="<c:url value='/resources/js/javascript.2.1.4.js'/>"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container" id="content">
            <h1 class="left">Categories</h1>
            <a class="right icon-shopping-cart" href="<spring:url value='/secure/admin/category/add'/>">Add</a>
            <table class="table table-striped table-hover">
                <tr>
                    <td>S No.</td>
                    <td>Name</td>
                    <td>Option</td>
                </tr>
                <c:forEach items="${categories}" varStatus="ind" var="category">
                    <tr>
                        <td>${ind.index+1}</td>
                        <td>${category.name}</td>
                        <td>
<!--                            <a href="<spring:url value='/secure/admin/category/edit/${category.id}'/>">Edit</a>
                            /-->
                            <a href="<spring:url value='/secure/admin/category/delete?id=${category.id}'/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
