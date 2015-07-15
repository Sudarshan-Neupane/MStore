<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Album</title>
        <spring:url value="/resources/js/javascript.2.1.4.js" var="js" />
        <script type="text/javascript" src="${js}"></script>
        <script>
            "use strict";
            $(function () {
                var subCatContainer = $('#subCategory');
                var cat = $('#category').val();
                if (cat > 0) {
                    loadSubCategory();
                }
                $('#category').change(function () {
                    loadSubCategory();
                });
                function loadSubCategory() {
                    var catVal = $('#category').val();
                    $.ajax({
                        url: '<c:url value="/secure/admin/subcategory/listbyid"/>?categoryId=' + catVal,
                        type: 'GET',
                        success: ajaxSuccess,
                        fail: ajaxFailure
                    });
                }
                function ajaxSuccess(result) {
                    subCatContainer.empty();
                    subCatContainer.append("<option value='0'>Select Sub Product</option>");
                    $.each(result.subCategories, function (i, item) {
                        console.log(i + " " + item.name);
                        subCatContainer.append("<option value=" + item.id + ">" + item.name + "</option>");
                    });
                }
                function ajaxFailure(xhr, status, exception) {
                    console.log(xhr, status, exception);
                }
            });

        </script>
    </head>
    <body>
        <h1>Add Album</h1>
        <table>
            <form:form modelAttribute="album" enctype="multipart/form-data">
                <tr>
                    <td><form:label path="name">Album Name</form:label></td>
                    <td><form:input path="name" required="required" /></td>
                    <td><form:errors path="*" /></td>
                </tr>
                <tr>
                    <td><form:label path="artist">Artist Name</form:label></td>
                    <td><form:input path="artist" required="required" /></td>
                    <td><form:errors path="artist" /></td>
                </tr>

                <tr>
                    <td><form:label path="image">Album Image</form:label></td>
                    <td><form:input type="file" path="image" /></td>
                    <td><form:errors path="image" /></td>
                </tr>
                <tr>
                    <td><form:label path="category">Category</form:label></td>
                    <td><form:select id="category" path="category.id"
                                 required="required">
                            <form:option value="0">Select Category</form:option>
                            <form:options items="${categories}"
                                          itemValue="id" itemLabel="name" />
                        </form:select></td>
                    <td><form:errors path="category" /></td>
                </tr>
                <tr>
                    <td><form:label path="subCategory">Sub Category</form:label></td>
                        <td>
                        <form:select id="subCategory" path="subCategory.id" required="required" >
                        </form:select>
                    </td>
                    <td><form:errors path="subCategory" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2"><form:button type="submit">Submit</form:button>&nbsp;&nbsp;
                        <form:button type="reset">Reset</form:button></td>
                    </tr>

            </form:form>

        </table>
        <c:if test="${not empty image}">
            <img src='<spring:url value="/resources/images/album/${image}"/>'height="200" width="250"/>
        </c:if>
    </body>
</html>