<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->

<title>Add Product Page</title>

</head>
<body>
	<form:form modelAttribute="product"
		action='<spring:url value="/addProduct"></spring:url>' method="POST">


		<fieldset>
			<legend>Add an Product</legend>
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>

			<p>
				<label for="name">Product Name:</label>
				<form:input path="name" />
			<div style="text-align: center;">
				<form:errors path="name" cssStyle="color : red;" />
			</div>
			</p>

			<p>
				<label for="category">Product Category: </label>
				<form:input path="category" />
			<div style="text-align: center;">
				<form:errors path="category" cssStyle="color : red;" />
			</div>
			</p>


			<p>
				<label for="subCategory">Sub Category: </label>
				<form:input path="subCategory" id="birthDate" />
				<form:errors path="subCategory" cssStyle="color : red;" />
			</p>

			<p>
				<label for="album">Album: </label>
				<form:input path="album" id="album" />
				<form:errors path="album" cssStyle="color : red;" />
			</p>



			<p>
				<label for="artistName">Artist Name: </label>
				<form:input path="artistName" id="artistName" />
			<div style="text-align: center;">
				<form:errors path="artistName" cssStyle="color : red;" />
			</div>
			</p>


			<p>
				<label for="year">Release Year: </label>
				<form:input path="year" id="year" />
			<div style="text-align: center;">
				<form:errors path="year" cssStyle="color : red;" />
			</div>
			</p>


			<p>
				<label for="price">Price: </label>
				<form:input path="price" id="price" />
			<div style="text-align: center;">
				<form:errors path="price" cssStyle="color : red;" />
			</div>
			</p>

			<p>
				<label for="length">Length: </label>
				<form:input path="length" id="length" />
			<div style="text-align: center;">
				<form:errors path="length" cssStyle="color : red;" />
			</div>
			</p>

			<p>
				<input type="button" value="Add">
			</p>


			<c:forEach var="productFile" items="${productFiles}">
            
				<form:label path="productFile.filePath">File Path:</form:label>
				<form:input path="productFile.filePath" />
				<c:out value="${productFile.filePath}"></c:out>	
			</c:forEach>


		</fieldset>



	</form:form>

</body>
</html>