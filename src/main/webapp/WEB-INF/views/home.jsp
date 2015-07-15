<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section>
    <div class="container">
        <div class="sidebar">
            <div class="form-group">
                <label for="sel1">Select Category:</label>
                <select class="form-control" id="sel1">
                    <option>Romantic</option>
                    <option>Nepali</option>
                    <option>English</option>
                </select>
            </div>
            <div class="form-group">
                <label for="sel1">Sub Category:</label>
                <select class="form-control" id="sel1">
                    <option>Romantic</option>
                    <option>Nepali</option>
                    <option>English</option>
                </select>
            </div>
            <button type="button" class="btn btn-primary">Search</button>
            <br>
        </div>
        <div class="products">
            <div class="product">
                <div>
                    <img src="#" alt="image">
                </div>
                <div class="buynow">
                 <a href='<spring:url value="/secure/addtocart"/>' class="btn btn-info"><i class="icon-shopping-cart"></i> $20 Buy now</a>

                </div>

            </div>
            <div class="product">
                <div>
                    <img src="#" alt="image">
                </div>
                <div class="buynow">
                    <a href='<spring:url value="/secure/addtocart"/>' class="btn btn-info"><i class="icon-shopping-cart"></i> $20 Buy now</a>

                </div>

            </div>
            <div class="product">
                <div>
                    <img src="#" alt="image">
                </div>
                <div class="buynow">
                    <a href='<spring:url value="/secure/addtocart"/>' class="btn btn-info"><i class="icon-shopping-cart"></i> $20 Buy now</a>

                </div>

            </div>
            <div class="product">
                <div>
                    <img src="#" alt="image">
                </div>
                <div class="buynow">
                    <a href='<spring:url value="/secure/addtocart"/>' class="btn btn-info"><i class="icon-shopping-cart"></i> $20 Buy now</a>

                </div>

            </div>
            <div class="product">
                <div>
                    <img src="#" alt="image">
                </div>
                <div class="buynow">
                    <a href="#" class="btn btn-info"><i class="icon-shopping-cart"></i> $20 Buy now</a>

                </div>

            </div>
            <div class="product">
                <div>
                    <img src="#" alt="image">
                </div>
                <div class="buynow">
                    <a href="#" class="btn btn-info"><i class="icon-shopping-cart"></i> $20 Buy now</a>

                </div>

            </div>

        </div>

    </div>
</section>