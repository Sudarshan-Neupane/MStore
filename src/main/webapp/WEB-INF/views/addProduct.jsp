<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Add Product Page</title>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
 function selectSubCategory(){

    var categoryName =  $("#categoryName").val();
	 var dataContainer = $("select#subCategory");
// 	 alert(categoryName);
// 	 return false;
	 $.ajax({
         url: '${pageContext.request.contextPath}/secure/admin/subcategory/list?categoryName='+categoryName,
         type: 'GET',
         success: ajaxSuccess,
			fail:ajaxFailure
     });

  function ajaxSuccess(result){
//               alert(result.subCategories);
              dataContainer.empty();
              $.each(result.subCategories, function (i, item) {
                  console.log(i + " " + item.name);
                  dataContainer.append($("<option>")
                 		 .append(item.name));
              });

              
 
	   }

  function ajaxFailure(){
             alert("Failure");

	  }
	 }
</script>
</head>
<body>
     
<spring:url value="addProduct" var="action"/>

	<form:form modelAttribute="product"
		action= "${action}" method="POST">


		<fieldset>
			<legend>Add an Product</legend>
			
			<table>
			<tr>
			<td>	<form:errors path="*" cssStyle="color : red;" /></td>
			</tr>

			<tr>
			<td>	<label for="name">Product Name:</label> </td>
			<td>	<form:input path="name" /> </td>
			<td><div style="text-align: center;">
				<form:errors path="name" cssStyle="color : red;" />
			</div></td>
			</tr>
			
				<tr>
				<td><label for="category.name">Category:</label> </td>
				<td>
				    <form:select id="categoryName" path = "category.name" onchange="selectSubCategory()" >
				    <form:option value="Select Category"/>
				    <form:options items="${categories}" itemValue="name" itemLabel="name"/>
				    </form:select>
				 </td>
			<td><div style="text-align: center;">
				<form:errors path="category.name" cssStyle="color : red;" />
			</div> </td>
			</tr>
			
			<tr>
				<td><label for="subCategory.name">SubCategory:</label> </td>
				<td>
				    <form:select id="subCategory" path = "subCategory.name">
				    <form:option value="Select Sub Category"/>
<%-- 				    <form:options items="${categories}" itemValue="name" itemLabel="name"/> --%>
				    </form:select>
				 </td>
			<td><div style="text-align: center;">
				<form:errors path="category.name" cssStyle="color : red;" />
			</div> </td>
			</tr>
			
	
			<tr>
			<td>	<input type="Submit" value="Add"> </td>
			</tr>
			
			</table>

		</fieldset>



	</form:form>

</body>
</html>