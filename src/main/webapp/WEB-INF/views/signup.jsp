<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    <section>
        <div class="container">
	<h2>Sign up page</h2>
	<form:form commandName="user" method="POST">
            
		<table>
		
		<tr>
				<td><form:label path="firstName">First Name:<em>*</em>
					</form:label></td>
				<td><form:input path="firstName"  class="form-control" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="middleName">Middle Name: </form:label></td>
				<td><form:input path="middleName"  class="form-control" /></td>
				<td><form:errors path="middleName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:<em>*</em>
					</form:label></td>
				<td><form:input path="lastName" class="form-control"/></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userName">Username:<em>*</em>
					</form:label></td>
				<td><form:input path="userName" class="form-control" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:<em>*</em>
					</form:label></td>
				<td><form:password path="password" class="form-control"/></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="rePassword">Re Password:<em>*</em>
					</form:label></td>
				<td><form:password path="rePassword" class="form-control"/></td>
				<td><form:errors path="rePassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2">
                                    <input type="submit" class="btn btn-primary" value="Submit">
                                   &nbsp;&nbsp;
					<input type="reset" value="Reset" class="btn btn-primary"/></td>
			</tr>
		</table>
	</form:form>
</div>