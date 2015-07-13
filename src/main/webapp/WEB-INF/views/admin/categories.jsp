<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories List</title>
    </head>
    <body>
        <h1>Categories List</h1>
        <a href="/secure/admin/category/add">Add</a>
        <table>
            <tr>
                <td>S No.</td>
                <td>Name</td>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>1</td>
                    <td>${category.name}</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
