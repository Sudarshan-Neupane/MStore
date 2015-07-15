<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
            <div class="productdetails">
                <div>
                    <img src="#" alt="image">
                </div>
                <h3>description</h3>

            </div>   
        </div>

    </div>
</section>