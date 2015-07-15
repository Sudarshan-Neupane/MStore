<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/admin.style.css'/>" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

        <script type="text/javascript" src="<c:url value='/resources/js/javascript.2.1.4.js'/>"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

        <title>MStore ::  Albums</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container" id="content">
            <h1>Albums</h1>
            <div>${successMsg}</div>
            <a href="<c:url value="/secure/admin/album/add"/>">Add</a>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <td>S No.</td>
                        <td>Name</td>
                        <td>Artist</td>
                        <td>Category</td>
                        <td>Sub Category</td>
                        <td>Option</td>
                    </tr>
                </thead>
                <tbody>
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
                </tbody>
            </table>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>