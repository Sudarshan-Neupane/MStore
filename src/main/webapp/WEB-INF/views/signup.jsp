<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<h2>Sign up page</h2>
	<form:form commandName="user" method="POST">
		<table>
		
		<tr>
				<td><form:label path="firstName">First Name:<em>*</em>
					</form:label></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="middleName">Middle Name: </form:label></td>
				<td><form:input path="middleName" /></td>
				<td><form:errors path="middleName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:<em>*</em>
					</form:label></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userName">Username:<em>*</em>
					</form:label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:<em>*</em>
					</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="rePassword">Re Password:<em>*</em>
					</form:label></td>
				<td><form:password path="rePassword" /></td>
				<td><form:errors path="rePassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2"><input type="submit" value="Submit" />&nbsp;&nbsp;
					<input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>