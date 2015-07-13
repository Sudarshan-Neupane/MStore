<%-- 
    Document   : addCategory
    Created on : Jul 13, 2015, 12:28:35 AM
    Author     : bipin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <h1>Add Category</h1>
        <form metho="post">
            <label>Name</label>
            <input type="text" name="name" required="requered"/>
            <table>
                <thead>
                    <tr>
                        <th>S.No.</th>
                        <th>Sub Cat Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${subCat}" var="subCat">
                        <tr>
                            <td>${subCat.id}</td>
                            <td>${subCat.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button id="onAddSubCat" type="button">Add Sub Category</button>
        </form>
        
        <div class="subCat">
            <form method="">
                
            </form>
        </div>
    </body>
</html>
