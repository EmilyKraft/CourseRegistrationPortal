<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration System - Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="Admin Dashboard" name="description" />
        <meta content="ThemeDesign" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <link rel="shortcut icon" href="other/images/favicon.ico">

        <link href="other/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="other/css/icons.css" rel="stylesheet" type="text/css">
        <link href="other/css/style.css" rel="stylesheet" type="text/css">

    </head>


    <body>

        <!-- Begin page -->
        <div class="accountbg"></div>
        <div class="wrapper-page">
            <div class="panel panel-color panel-primary panel-pages">

                 <div class="panel-body">
                    <h3 class="text-center m-t-0 m-b-15">Course Registration System</h3>
                    <h4 class="text-muted text-center m-t-0"><b>Register</b></h4>

                    <form:form class="form-horizontal m-t-20" action="submitRegistrationForm" method="post" modelAttribute="userSignUp">
					
					                        <div class="form-group">
                            <div class="col-xs-12">
                                <form:input path="firstName" class="form-control" type="text" required="" placeholder="First Name" name="firstName"></form:input>
                            </div>
                        </div>
						
						                        <div class="form-group">
                            <div class="col-xs-12">
                                <form:input path="lastName" class="form-control" type="text" required="" placeholder="Last Name" name="lastName"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-12">
                                <form:input path="email" class="form-control" type="email" required="" placeholder="Email" name="email"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-12">
                                <form:input path="password" class="form-control" type="password" required="" placeholder="Password" name="password"></form:input>
                            </div>
                        </div>

					<div class="form-group">
						<div class="col-xs-12">
							<form:input path="phone" class="form-control" type="text"
								required="" placeholder="Phone Number" name="phone"></form:input>
						</div>
					</div>

					<label>Agency</label>
					<form:select path="agencyID" class="form-control">
						<c:forEach var="agency" items="${agencyList}">

							<form:option value="${agency.agencyID}">${agency.agencyName}</form:option>

						</c:forEach>
					</form:select>

					<div class="form-group text-center m-t-40">
						<div class="col-xs-12">
							<button
								class="btn btn-primary btn-block btn-lg waves-effect waves-light"
								type="submit">Register</button>
						</div>
					</div>

					<div class="form-group m-t-30 m-b-0">
						<div class="col-sm-12 text-center">
							<a href="/controller/signIn" class="text-muted">Already have
								account?</a>
						</div>
					</div>

				</form:form>
                </div>

            </div>
        </div>



        <!-- jQuery  -->
        <script src="other/js/jquery.min.js"></script>
        <script src="other/js/bootstrap.min.js"></script>
        <script src="other/js/modernizr.min.js"></script>
        <script src="other/js/detect.js"></script>
        <script src="other/js/fastclick.js"></script>
        <script src="other/js/jquery.slimscroll.js"></script>
        <script src="other/js/jquery.blockUI.js"></script>
        <script src="other/js/waves.js"></script>
        <script src="other/js/wow.min.js"></script>
        <script src="other/js/jquery.nicescroll.js"></script>
        <script src="other/js/jquery.scrollTo.min.js"></script>

        <script src="other/js/app.js"></script>

    </body>
</html>