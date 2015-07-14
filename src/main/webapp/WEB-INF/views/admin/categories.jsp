<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories List</title>
    </head>
    <body>
        <h1>Categories List</h1>
        <a href="<spring:url value='/secure/admin/category/add'/>">Add</a>
        <table>
            <tr>
                <td>S No.</td>
                <td>Name</td>
                <td>Option</td>
            </tr>
            <c:forEach items="${categories}" varStatus="ind" var="category">
                <tr>
                    <td>${ind.index+1}</td>
                    <td>${category.name}</td>
                    <td><a href="<spring:url value='/secure/admin/category/edit/${category.id}'/>">Edit</a>/<a href="<spring:url value='/secure/admin/category/delete?id=${category.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
