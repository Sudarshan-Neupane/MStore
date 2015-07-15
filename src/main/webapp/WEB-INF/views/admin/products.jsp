<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/admin.style.css'/>" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

        <script type="text/javascript" src="<c:url value='/resources/js/javascript.2.1.4.js'/>"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

        <title>MStore :: Products</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container" id="content">
            <h1>Product List</h1>
            <a href="<spring:url value='/secure/admin/product/add'/>">Add</a>
            <table class="table table-striped table-hover">
                <tr>
                    <td>S No.</td>
                    <td>Name</td>
                    <td>Category</td>
                    <td>Sub Category</td>
                    <td>Album</td>
                    <td>Published Year</td>
                    <td>Price</td>
                    <td>Length</td>
                </tr>
                <c:forEach items="${products}" varStatus="ind" var="myproduct">
                    <tr>
                        <td>${ind.index+1}</td>
                        <td>${myproduct.name}</td>
                        <td>${myproduct.category.name}</td>
                        <td>${myproduct.subCategory.name}</td>
                        <td>${myproduct.album.name}</td>
                        <td>${myproduct.year}</td>
                        <td>${myproduct.price}</td>
                        <td>${myproduct.length}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
