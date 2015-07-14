<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home Page</title>
</head>
<body>
<h1>Admin Home Page</h1>
<a href="<c:url value="categories" />" > Category Mgmt</a><br/>
<a href="<c:url value="/logout" />" > Logout</a>
</body>
</html>