<%-- 
    Document   : addCategory
    Created on : Jul 13, 2015, 12:28:35 AM
    Author     : bipin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            .subCat{
                display: none;
            }
        </style>
        <spring:url value="/resources/js/javascript.2.1.4.js" var="js" />
<%-- <spring:url value="/resources/js/script.js" var="js" /> --%>
        <script type="text/javascript" src="${js}"></script>
        <script>
            "use strict";
            $(function () {
                $('#onAddSubCat').click(function () {
                    $('.subCat').fadeIn('slow');
                });
                var dataContainer = $('#table tbody');
                $("#add").click(function (event) {
                    event.preventDefault();
                    console.log("check empty: " + $("#txtSubCatName").val().length);
                    if($("#txtSubCatName").val().length < 0){
                    	console.log("empty");
                    	return;
                    }
                    $.ajax({
                        url: '${pageContext.request.contextPath}/secure/admin/subcategory/add',
                        type: 'POST',
                        data: $('#form1').serialize(),
                        success: ajaxSuccess,
						fail:ajaxFailure
                    });
                    $("#txtSubCatName").val('');
                    $('.subCat').fadeOut('slow');
                });


                $("#table").on("click", "a",function(){
                	var val = $(this).attr("href");
                    $.ajax({
                        url: '${pageContext.request.contextPath}/secure/admin/subcategory/delete?name='+val,
                        type: 'GET',
                        success: ajaxSuccess,
						fail:ajaxFailure
                    });
                    return false;
                });
                
                function ajaxSuccess(result) {
                	dataContainer.empty();
                    $.each(result.subCategories, function (i, item) {
                        console.log(i + " " + item.name);
                        dataContainer.append($("<tr>")
                       		 .append("<td>"+ parseInt(i+1) + "</td><td>"
                       				 + item.name + "</td><td>" + "<a href='"+item.name+"'>Remove</a>" +"</td>"));
                    });
                }
                function ajaxFailure(xhr, status, exception) {
                    console.log(xhr, status, exception);
                }
            });
        </script>
        <title>Add Category</title>
    </head>
    <body>
        <h1>Add Category</h1>
        <form method="POST" action="">
            <label>Name</label>
            <input type="text" name="name" required="required"/>
            <table id="table">
                <thead>
                    <tr>
                        <th>S.No.</th>
                        <th>Sub Cat Name</th>
                        <th>Option</th>
                    </tr>
                </thead>
                <tbody>
                   
                </tbody>
            </table>
            <button id="onAddSubCat" type="button">Add Sub Category</button>
            <input type="submit" value="Submit"/>
        </form>

        <div class="subCat">
            <form id="form1">
                <label>Sub Cat Name: </label>
                <input type="text" id="txtSubCatName" name="name"/>
                <button type="button" id="add">Add</button>
            </form>
        </div>
    </body>
</html>
