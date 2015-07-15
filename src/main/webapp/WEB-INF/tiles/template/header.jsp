<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <spring:url value="/resources/css/style.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <header>
                <div class="menu">            
                    <a href='<spring:url value="/"/>'>Home </a> 
                    <a href='<spring:url value="/dologin"/>'>Login </a> 
                    <a href='<spring:url value="/signup"/>'>Sign Up </a>
                    <c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">
                        <a href='<spring:url value="/secure/profile"/>'>Edit Profile </a>
                    </c:if>
                   <c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">
                        <a href='<spring:url value="/logout"/>'>Logout </a>
                    </c:if>
                </div>
            </header>

            <hr/>
        </div>