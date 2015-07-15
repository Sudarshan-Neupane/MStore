<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>Product List</h1>
        <a href="<spring:url value='/secure/admin/product/add'/>">Add</a>
        <table>
            <tr>
                <td>S No.</td>
                <td>Name</td>
                <td>Option</td>
            </tr>
            <c:forEach items="${products}" varStatus="ind" var="myproduct">
                <tr>
                    <td>${ind.index+1}</td>
                    <td>${myproduct.name}</td>
                    <td><a href="<spring:url value='/secure/admin/product/edit/${product.id}'/>">Edit</a>/<a href="<spring:url value='/secure/admin/product/delete?id=${product.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
