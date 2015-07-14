<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Albums</title>
</head>
<body>
<h1>Album List</h1>
		<div>${successMsg}</div>
        <a href="<c:url value="/secure/admin/album/add"/>">Add</a>
        <table>
            <tr>
                <td>S No.</td>
                <td>Name</td>
                <td>Artist</td>
                <td>Category</td>
                <td>Sub Category</td>
                <td>Option</td>
            </tr>
            <c:forEach items="${albums}" varStatus="ind" var="album">
                <tr>
                    <td>${ind.index+1}</td>
                    <td>${album.name}</td>
                    <td>${album.artist}</td>
                    <td>${album.category.name}</td>
                    <td>${album.subCategory.name}</td>
                    <td><a href="<c:url value="/secure/admin/album/edit/${album.id}"/>">Edit</a>/<a href="<c:url value="/secure/admin/album/delete/${album.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>

        </table>
</body>
</html>