<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/admin.style.css'/>" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

        <script type="text/javascript" src="<c:url value='/resources/js/javascript.2.1.4.js'/>"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

        <style type="text/css">
            .subCat{
                display: none;
            }
        </style>
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
                    if ($("#txtSubCatName").val().length < 0) {
                        console.log("empty");
                        return;
                    }
                    $.ajax({
                        url: '${pageContext.request.contextPath}/secure/admin/subcategory/add',
                        type: 'POST',
                        data: $('#form1').serialize(),
                        success: ajaxSuccess,
                        fail: ajaxFailure
                    });
                    $("#txtSubCatName").val('');
                    $('.subCat').fadeOut('slow');
                });


                $("#table").on("click", "a", function () {
                    var val = $(this).attr("href");
                    $.ajax({
                        url: '${pageContext.request.contextPath}/secure/admin/subcategory/delete?name=' + val,
                        type: 'GET',
                        success: ajaxSuccess,
                        fail: ajaxFailure
                    });
                    return false;
                });

                function ajaxSuccess(result) {
                    dataContainer.empty();
                    $.each(result.subCategories, function (i, item) {
                        console.log(i + " " + item.name);
                        dataContainer.append($("<tr>")
                                .append("<td>" + parseInt(i + 1) + "</td><td>"
                                        + item.name + "</td><td>" + "<a href='" + item.name + "'>Remove</a>" + "</td>"));
                    });
                }
                function ajaxFailure(xhr, status, exception) {
                    console.log(xhr, status, exception);
                }
            });
        </script>
        <title>MStore :: Category Add</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container" id="content">
            <fieldset>
                <legend>Category &gtcc; Add</legend>
                <form method="POST" action="">
                    <label>Name: </label>
                    <input type="text" name="name" required="required"/><br/>
                    <button id="onAddSubCat" type="button">Add Sub Category</button><br/>

                    <table id="table" class="table table-striped table-hover">
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
                    <input type="submit" value="Submit"/>
                </form>
            </fieldset>
            <div class="subCat">
                <fieldset>
                    <legend>Sub Category &gtcc; Add</legend>
                    <form id="form1">
                        <label>Sub Cat Name: </label>
                        <input type="text" id="txtSubCatName" name="name"/>
                        <button type="button" id="add">Add</button>
                    </form>
                </fieldset>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
