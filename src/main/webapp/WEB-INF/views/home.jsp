<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script>
    function selectSubCategory() {

        var categoryId = $("#categoryName").val();
        var dataContainer = $("select#subCategory");
        // 	 alert(categoryName);
        // 	 return false;
        $
                .ajax({
                    url: '${pageContext.request.contextPath}/secure/admin/subcategory/listbyid?categoryId='
                            + categoryId,
                    type: 'GET',
                    success: ajaxSuccess,
                    fail: ajaxFailure
                });

        function ajaxSuccess(result) {
            //               alert(result.subCategories);
            dataContainer.empty();
            dataContainer.append($("<option>").append("Select Sub Category"));

            $.each(result.subCategories, function (i, item) {
                console.log(i + " " + item.name);
                dataContainer.append("<option value=" + item.id + ">" + item.name + "</option>");
            });

        }

        function ajaxFailure() {
            alert("Failure");

        }
    }

    function selectAlbum() {

        var subCategoryId = $("#subCategory").val();
        var dataContainerAlbum = $("select#album");
        $.ajax({
            url: '${pageContext.request.contextPath}/secure/admin/album/list?subCategoryId='
                    + subCategoryId,
            type: 'GET',
            success: ajaxSuccessAlbum,
            fail: ajaxFailureAlbum
        });

        function ajaxSuccessAlbum(result) {
            dataContainerAlbum.empty();
            dataContainerAlbum.append($("<option>").append("Select Album"));
            $.each(result, function (i, item) {
                console.log(i + " iiii  " + item.name);
                dataContainerAlbum.append("<option value=" + item.id + ">" + item.name + "</option>");
            });

        }

        function ajaxFailureAlbum() {
            alert("Failure");

        }
    }
</script>
<section>
    <div class="container">
        <div class="sidebar">
            <form:form modelAttribute="product"  method="POST">
                <div class="form-group">
                    <label for="categoryName">Category:</label>  
                    <form:select id="categoryName" path="category.id" onchange="selectSubCategory()" class="form-control">
                        <form:option value="Select Category" />
                        <form:options items="${categories}" itemValue="id"
                                      itemLabel="name" />
                    </form:select>   
                    
                        <label for="sel1">Sub category:</label>
                        <form:select id="subCategory" path="subCategory.id"
                                     onchange="selectAlbum()" class="form-control">
                            <form:option value="Select Sub Category" />
                        </form:select>
                        
                        <label for="sel1">Albums:</label>
                        <form:select id="album" path="album.id"
                                      class="form-control">
                            <form:option value="Select Albums" />
                        </form:select>
                    

                </div>
            </form:form>

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