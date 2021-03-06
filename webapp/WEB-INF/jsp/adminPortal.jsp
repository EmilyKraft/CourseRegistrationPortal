<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Registration System - Home</title>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.bundle.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>

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
					<!--<a href="index.html" class="logo"><img src="other/images/logo_white_2.png" height="28"></a>-->
					<!--<a href="index.html" class="logo-sm"><img src="other/images/logo_sm.png" height="36"></a>-->
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
											value='${loggedInUser.firstName} ${loggedInUser.lastName}' />
										<br /> <small><c:out value='${loggedInUser.role}' /></small>
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
						<li><a href="/" class="waves-effect"><i
								class="mdi mdi-home"></i><span>Home</span></a></li>
						<li class="has_sub"><a href="javascript:void(0);"
							class="waves-effect"><i class="mdi mdi-plus"></i> <span>Manage
									Courses</span> <span class="pull-right"><i class="mdi mdi-plus"></i></span></a>
							<ul class="list-unstyled">
								<li><a href="scheduleCourse">Schedule a Course</a></li>
								<li><a href="newCourse">Create New Course</a></li>
							</ul></li>
						<li><a href="upcomingSchedule" class="waves-effect"><i
								class="mdi mdi-calendar-clock"></i> <span>Upcoming
									Schedule</span></a></li>

						<li class="has_sub"><a href="javascript:void(0);"
							class="waves-effect"><i class="mdi mdi-book-open"></i> <span>Manage
									Invoices</span> <span class="pull-right"><i
									class="mdi mdi-plus"></i></span></a>
							<ul class="list-unstyled">
								<li><a href="generateInvoice">Generate New Invoice</a></li>
								<li><a href="viewOutstanding">View Outstanding Invoices</a></li>
							</ul></li>
						<li class="has_sub"><a href="javascript:void(0);"
							class="waves-effect"><i class="mdi mdi-buffer"></i><span>View
									Enrolled</span><span class="pull-right"><i class="mdi mdi-plus"></i></span></a>
							<ul class="list-unstyled">
								<c:forEach var="courseOffering" items="${sideCourseList}">
									<li><a
										href="viewEnrollments?cID=${courseOffering.courseOfferingID}"><c:out
												value="${courseOffering.course.courseTitle} - ${courseOffering.dateOffered}" /></a></li>
								</c:forEach>
							</ul></li>
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
						<h4 class="page-title">Dashboard</h4>
					</div>
				</div>

				<div class="page-content-wrapper ">

					<div class="container">
						<div class="row">
							<div class="col-lg-12">
								<div class="panel panel-color panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">Welcome to the Course
											Registration System!</h3>
									</div>
									<div class="panel-body">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor incididunt ut labore et dolore
											magna aliqua. Ut enim ad minim veniam, quis nostrud
											exercitation ullamco laboris nisi ut aliquip ex ea commodo
											consequat.</p>
									</div>
								</div>
							</div>
						</div>
						<!-- end row -->

						<div class="row">
							<div class="col-sm-6 col-lg-3">
								<div class="panel text-center">
									<div class="panel-heading">
										<h4 class="panel-title text-muted font-light">New
											Enrollments</h4>
									</div>
									<div class="panel-body p-t-10">
										<h2 class="m-t-0 m-b-15">
											<i
												class="mdi mdi-arrow-down-bold-circle-outline text-danger m-r-10"></i><b>8952</b>
										</h2>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-3">
								<div class="panel text-center">
									<div class="panel-heading">
										<h4 class="panel-title text-muted font-light">Upcoming
											Classes</h4>
									</div>
									<div class="panel-body p-t-10">
										<h2 class="m-t-0 m-b-15">
											<i
												class="mdi mdi-arrow-up-bold-circle-outline text-primary m-r-10"></i><b>6521</b>
										</h2>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-3">
								<div class="panel text-center">
									<div class="panel-heading">
										<h4 class="panel-title text-muted font-light">Total
											Enrollments YTD</h4>
									</div>
									<div class="panel-body p-t-10">
										<h2 class="m-t-0 m-b-15">
											<i
												class="mdi mdi-arrow-up-bold-circle-outline text-primary m-r-10"></i><b>452</b>
										</h2>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-3">
								<div class="panel text-center">
									<div class="panel-heading">
										<h4 class="panel-title text-muted font-light">Monthly
											Tuition</h4>
									</div>
									<div class="panel-body p-t-10">
										<h2 class="m-t-0 m-b-15">
											<i
												class="mdi mdi-arrow-down-bold-circle-outline text-danger m-r-10"></i><b>5621</b>
										</h2>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-border panel-primary">
									<div class="panel-body">
										<h4 class="m-t-0 m-b-30">Total Enrollments by Month</h4>

										<canvas id="myLineChart" width="400" height="300"></canvas>
										<script>
var ctx = document.getElementById("myLineChart");
var myLineChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: [        	
        	<c:forEach varStatus="counter" items="${enrollmentMonthList}" var="enrollmentMonth">
        <c:out value="\"${enrollmentMonth.acronym}\"""/>
            <c:if test="${!counter.last}">,</c:if>
            </c:forEach>
            ],
        datasets: [{
            label: '# of Enrollments',
            data: [
            	<c:forEach varStatus="counter" items="${enrollmentMonthList}" var="enrollmentMonth">
            <c:out value="${enrollmentMonth}"/>
            <c:if test="${!counter.last}">,</c:if>
            </c:forEach>
            ],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
            ],
            borderColor: [
                'rgba(255,99,132,1)',
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
</script>
									</div>
								</div>
							</div>

							<div class="col-lg-6">
								<div class="panel panel-border panel-primary">
									<div class="panel-body">
										<h4 class="m-t-0 m-b-30">Outstanding Amounts by Agency</h4>
										<canvas id="barChart" width="400" height="300"></canvas>
										<script>
var ctx = document.getElementById("barChart").getContext('2d');
var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["DNR", "DMH", "DOC"
            ],
        datasets: [{
            label: '# of Enrollments',
            data: [100, 250, 125
            ],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
</script>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-border panel-primary">
									<div class="panel-body">
										<div id="pie-chart">
											<h4 class="m-t-0 m-b-30">Enrollments by Agency</h4>
											<canvas id="pieChart" width="400" height="300"></canvas>
											<script>
var ctx = document.getElementById("pieChart");
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: [
        	<c:forEach varStatus="counter" items="${enrollmentAgencyList}" var="enrollmentAgency">
            <c:out value="\"${enrollmentAgency.acronym}\"""/>
                <c:if test="${!counter.last}">,</c:if>
                </c:forEach>
        ],
        datasets: [{
            label: 'Percent of Enrollments',
            data: [
            	<c:forEach varStatus="counter" items="${enrollmentAgencyList}" var="enrollmentAgency">
                <c:out value="${enrollmentAgency.numEnrollments}"/>
                <c:if test="${!counter.last}">,</c:if>
                </c:forEach>
            ],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
});
</script>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<!-- end row -->

				</div>
				<!-- container -->

			</div>
			<!-- Page content Wrapper -->

		</div>
		<!-- content -->

		<footer class="footer"> © 2017 State of Missouri - All Rights
		Reserved. </footer>

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

	<script src="other/plugins/flot-chart/jquery.flot.min.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.time.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.tooltip.min.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.resize.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.pie.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.selection.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.stack.js"></script>
	<script src="other/plugins/flot-chart/jquery.flot.crosshair.js"></script>
	<script src="other/pages/flot.init.js"></script>

	<script src="other/plugins/chart.js/chart.min.js"></script>
	<script src="other/pages/chartjs.init.js"></script>

</body>
</html>