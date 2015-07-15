<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <!--   <div class="login">
                        <h2 class="form-signin-heading">Login Page</h2>
        ${msg}
        <c:if test="${not empty error}">
            <div class="error">Invalid Username or Password</div>
        </c:if>
        <form method="POST"
              action='<spring:url value="/j_spring_security_check"></spring:url>'>

                  <div class="form-group">
                      <label for="username">UserName:</label> <input type="text"
                                                                     id="j_username" name="username" placeholder="username">
                  </div>
                  <div class="form-group">
                      <label for="pwd">Password:</label> <input type="password"
                                                                id="j_password" name="password" placeholder="password">
                  </div>
                  <input type="submit" value="Login" /> <input type="reset"
                                                               value="Reset" />
              </form>
        </div>-->

            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="panel panel-login">
                            <div class="panel-body">
                                <div class="row">
                                ${msg}
                                <c:if test="${not empty error}">
                                    <div class="error">Invalid Username or Password</div>
                                </c:if>
                                <div class="col-lg-12">
                                    <form method="POST"
                                          action='<spring:url value="/j_spring_security_check"></spring:url>'>
                                        <div class="form-group">
                                            <input type="text" name="username" id="j_username" tabindex="1" class="form-control" placeholder="Username" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password"  id="j_password" tabindex="2" class="form-control" placeholder="Password">
                                        </div>
                                        <div class="form-group text-center">
                                            <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                            <label for="remember"> Remember Me</label>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="btn btn-lg btn-primary btn-block" value="Log In">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <div class="text-center">
                                                        <a href="<c:url value="/"/>" tabindex="5" class="forgot-password">Forgot Password?</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>