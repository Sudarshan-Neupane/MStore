<%-- 
    Document   : header
    Created on : Jul 15, 2015, 1:58:50 AM
    Author     : bipin
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar-inverse navbar-fixed-top">
    <div class="container">
        <a href="<c:url value="home" />" ><div class="navbar-brand navbar-left">Music Store Admin Panel</div></a>
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="collapse navbar-collapse navHeaderCollapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/secure/admin/categories" />" > Category Mgmt</a></li>
                <li><a href="<c:url value="/secure/admin/albums" />" > Album Mgmt</a></li>
                <li><a href="<c:url value="/secure/admin/products" />" > Product Mgmt</a></li>
                <li><a href="<c:url value="/logout" />" > Logout</a></li>
            </ul>
        </div>
    </div>
</div>
