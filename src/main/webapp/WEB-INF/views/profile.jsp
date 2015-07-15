<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section>
    <div class="container">
        <div class="container">
            <h1>Edit Profile</h1>
            <span class="message"><b>Welcome ${user.firstName} ${user.lastName}</b></span>
            <hr>
            <div class="profileForm">

                <form:form commandName="profile" method="post">
                    <div class="profile1">
                        <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <form:input path="phone" class="form-control"  placeholder=""/><br>
                            <form:errors path="phone"/>
                        </div>
                        <div class="form-group">
                            <label for="dateOfBirth">Date Of Birth</label>
                            <form:input path="dateOfBirth" class="form-control"  placeholder="MM/DD/YYYY"/><br>
                            <form:errors path="dateOfBirth"/>
                        </div>
                        <div class="form-group">
                            <form:label path="gender" cssClass="leftfloat">Gender:</form:label>
                            <form:radiobuttons items="${gender}" path="gender" cssClass="radiobtns"/>
                        </div>
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#home"><b>Shipping Address</b></a></li>                           
                        </ul>
                        <div class="tab-content">
                            <div id="home" class="tab-pane fade in active">
                                <div class="form-group">
                                    <label for="shippingStreet">Street</label>
                                    <form:input path="shipping.street" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="city">City</label>
                                    <form:input path="shipping.city" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="zipcode">state</label>
                                    <form:input path="shipping.state" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="country">country</label>
                                    <form:input path="shipping.country" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="zipcode">Zip Code</label>
                                    <form:input path="shipping.zipcode" class="form-control" />
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="profile2">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#home"><b>Permanent Address</b></a></li>                           
                        </ul>
                        <div class="tab-content">
                            <div id="home" class="tab-pane fade in active">
                                <div class="form-group">
                                    <label for="street">Street</label>
                                    <form:input path="permanentAddress.street" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="city">City</label>
                                    <form:input path="permanentAddress.city" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="zipcode">state</label>
                                    <form:input path="permanentAddress.state" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="country">country</label>
                                    <form:input path="permanentAddress.country" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="zipcode">ZipCode</label>
                                    <form:input path="permanentAddress.zipcode" class="form-control" />
                                </div>
                            </div>
                        </div>
                      
                        <form:button type="submit" id="btnUpdate">Update</form:button>
                        <form:button type="reset">Reset</form:button>
                    </form:form>
                </div>


            </div>
        </div>
    </div>

<hr>

</section>
