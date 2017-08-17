<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Registration System - Course Timeline</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="Admin Dashboard" name="description" />
<meta content="ThemeDesign" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<link rel="shortcut icon" href="other/images/favicon.ico">

<link href="other/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="other/css/icons.css" rel="stylesheet" type="text/css">
<link href="other/css/style.css" rel="stylesheet" type="text/css">

</head>


<body class="fixed-left">

	<!-- Begin page -->
	<div id="wrapper">

		<!-- Top Bar Start -->
		<div class="topbar">
			<!-- LOGO -->
			<div class="topbar-left">
				<div class="text-center">
					<a href="index.html" class="logo"><span>State Training
							Center</span></a>
					<!--<a href="index.html" class="logo"><img src="assets/images/logo_white_2.png" height="28"></a>-->
					<!--<a href="index.html" class="logo-sm"><img src="assets/images/logo_sm.png" height="36"></a>-->
				</div>
			</div>
			<!-- Button mobile view to collapse sidebar menu -->
			<div class="navbar navbar-default" role="navigation">
				<div class="container">
					<div class="">
						<div class="pull-left">
							<button type="button"
								class="button-menu-mobile open-left waves-effect waves-light">
								<i class="ion-navicon"></i>
							</button>
							<span class="clearfix"></span>
						</div>

						<ul class="nav navbar-nav navbar-right pull-right">

							<li class="dropdown"><a href=""
								class="dropdown-toggle profile waves-effect waves-light"
								data-toggle="dropdown" aria-expanded="true"> <span
									class="profile-username"> <c:out
											value='${loggedInUser.firstName} ${loggedInUser.lastName}' /><br />
										<small><c:out value='${loggedInUser.role}' /></small>
								</span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="javascript:void(0)"> Profile</a></li>
									<li><a href="javascript:void(0)"> Change Password </a></li>
									<li class="divider"></li>
									<li><a href="javascript:void(0)"> Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		<!-- Top Bar End -->


		<!-- ========== Left Sidebar Start ========== -->

		<div class="left side-menu">
			<div class="sidebar-inner slimscrollleft">

				<div class="user-details">
					<div class="text-center"></div>
					<div class="user-info">
						<div class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"><c:out
									value='${loggedInUser.firstName} ${loggedInUser.lastName}' /></a>
							<ul class="dropdown-menu">
								<li><a href="javascript:void(0)"> Profile</a></li>
								<li><a href="javascript:void(0)"> Change Password </a></li>
								<li class="divider"></li>
								<li><a href="logout"> Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!--- Divider -->


				<div id="sidebar-menu">
					<ul>
						<li><a href="index.html" class="waves-effect"><i
								class="mdi mdi-home"></i><span>Home</span></a></li>
						<li><a href="/controller/upcomingCourses"
							class="waves-effect"><i class="mdi mdi-cart-plus"></i> <span>Upcoming
									Courses</span></a></li>

						<li class="has_sub"><a href="javascript:void(0);"
							class="waves-effect"><i
								class="mdi mdi-calendar-multiple-check "></i> <span>Enrollments</span>
								<span class="pull-right"><i class="mdi mdi-plus"></i></span></a>
							<ul class="list-unstyled">
								<li><a href="icons-material.html">View Enrollments</a></li>
								<li><a href="icons-ion.html">Enrollment History</a></li>
							</ul></li>

						<!--<li class="has_sub">-->
						<!--<a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-share-variant"></i><span>Multi Menu </span><span class="pull-right"><i class="mdi mdi-plus"></i></span></a>-->
						<!--<ul>-->
						<!--<li class="has_sub">-->
						<!--<a href="javascript:void(0);" class="waves-effect"><span>Menu Item 1.1</span> <span class="pull-right"><i class="mdi mdi-plus"></i></span></a>-->
						<!--<ul style="">-->
						<!--<li><a href="javascript:void(0);"><span>Menu Item 2.1</span></a></li>-->
						<!--<li><a href="javascript:void(0);"><span>Menu Item 2.2</span></a></li>-->
						<!--</ul>-->
						<!--</li>-->
						<!--<li>-->
						<!--<a href="javascript:void(0);"><span>Menu Item 1.2</span></a>-->
						<!--</li>-->
						<!--</ul>-->
						<!--</li>-->
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- end sidebarinner -->
		</div>
		<!-- Left Sidebar End -->

		<!-- Start right Content here -->

		<div class="content-page">
			<!-- Start content -->
			<div class="content">

				<div class="">
					<div class="page-header-title">
						<h4 class="page-title">Available Courses</h4>
					</div>
				</div>

				<div class="page-content-wrapper ">

					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div class="panel panel-primary">
									<div class="panel-body">
										<div class="row">
											<div class="col-sm-12">
												<h4 class="page-header m-t-0">Current Courses</h4>
											</div>
										</div>
<c:out value='${successMsg}' />
<c:out value='${alreadyExistsMsg}' />
										<div class="row">
											<div class="col-lg-12">
												<div class="panel-group" id="accordion-test-2">
													<c:forEach var="courseOffering" items="${courses}">
														<div class="panel panel-info panel-color">
															<div class="panel-heading">
																<h4 class="panel-title">
																	<a data-toggle="collapse"
																		data-parent="#accordion-test-2" href="#${courseOffering.courseOfferingID}"
																		aria-expanded="false" class="collapsed"> <c:out
																			value="${courseOffering.course.courseTitle} - ${courseOffering.dateOffered} at ${courseOffering.courseTime}" />
																	</a>
																</h4>
															</div>
															<div id="${courseOffering.courseOfferingID}" class="panel-collapse collapse">
																<!-- add "in" to class to make it load open -->
																<div class="panel-body">
																	<c:out
																		value="${courseOffering.course.courseDescription}" />
																	<br />
																	<c:out
																		value="${courseOffering.streetAddress}, ${courseOffering.city}, ${courseOffering.state}, ${courseOffering.zip}" />
																	<br />
																	<form:form modelAttribute="newEnrollment" action="submitEnrollment" method="post">
																		<form:input type="hidden" path="userID"
																			value="${loggedInUser.userID}" class="form-control" />
																		<form:input type="hidden" path="courseOfferingID"
																			value="${courseOffering.courseOfferingID}"
																			class="form-control" />
																		<button type="submit"
																			class="btn btn-primary btn-rounded waves-effect waves-light m-t-15">Enroll</button>
																	</form:form>
																</div>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>

										</div>
										<!-- container -->

									</div>
									<!-- Page content Wrapper -->

								</div>
								<!-- content -->

								<footer class="footer"> © 2017 State of Missouri - All
								Rights Reserved. </footer>

							</div>
							<!-- End Right content here -->

						</div>
						<!-- END wrapper -->


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