<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration System - View Enrollments </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="Admin Dashboard" name="description" />
        <meta content="ThemeDesign" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <link rel="shortcut icon" href="other/images/favicon.ico">

        <link href="other/css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
                        <a href="index.html" class="logo"><span>State Training Center</span></a>
                        <!--<a href="index.html" class="logo"><img src="assets/images/logo_white_2.png" height="28"></a>-->
                        <!--<a href="index.html" class="logo-sm"><img src="assets/images/logo_sm.png" height="36"></a>-->
                    </div>
                </div>
                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">
                        <div class="">
                            <div class="pull-left">
                                <button type="button" class="button-menu-mobile open-left waves-effect waves-light">
                                    <i class="ion-navicon"></i>
                                </button>
                                <span class="clearfix"></span>
                            </div>

                            <ul class="nav navbar-nav navbar-right pull-right">
                               
                                <li class="dropdown">
                                    <a href="" class="dropdown-toggle profile waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                                <span class="profile-username">
                                                    <c:out value='${loggedInUser.firstName} ${loggedInUser.lastName}' /> <br/>
                                                    <small><c:out value='${loggedInUser.role}'/></small>
                                                </span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="javascript:void(0)"> Profile</a></li>
                                        <li><a href="javascript:void(0)"> Change Password </a></li>
                                        <li class="divider"></li>
                                        <li><a href="javascript:void(0)"> Logout</a></li>
                                    </ul>
                                </li>
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
                        <div class="text-center">
                        </div>
                        <div class="user-info">
                            <div class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><c:out value='${loggedInUser.firstName} ${loggedInUser.lastName}' /></a>
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
                            <li>
                                <a href="/" class="waves-effect"><i class="mdi mdi-home"></i><span>Home</span></a>
                            </li>
                                  <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-plus"></i> <span>Manage Courses</span> <span class="pull-right"><i class="mdi mdi-plus"></i></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="scheduleCourse">Schedule a Course</a></li>
                                    <li><a href="newCourse">Create New Course</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="upcomingSchedule" class="waves-effect"><i class="mdi mdi-calendar-clock"></i> <span>Upcoming Schedule</span></a>
                            </li>

                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-book-open"></i> <span>Manage Invoices</span> <span class="pull-right"><i class="mdi mdi-plus"></i></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="generateInvoice">Generate New Invoice</a></li>
                                    <li><a href="viewOutstanding">View Outstanding Invoices</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-buffer"></i><span>View Enrolled</span><span class="pull-right"><i class="mdi mdi-plus"></i></span></a>
                                <ul class="list-unstyled">
                                <c:forEach var="courseOffering" items="${sideCourseList}">
                                    <li><a href="viewEnrollments?cID=${courseOffering.courseOfferingID}"><c:out value="${courseOffering.course.courseTitle} - ${courseOffering.dateOffered}"/></a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div> <!-- end sidebarinner -->
            </div>
            <!-- Left Sidebar End -->

            <!-- Start right Content here -->

             <div class="content-page">
                <!-- Start content -->
                <div class="content">

                    <div class="">
                        <div class="page-header-title">
                            <h4 class="page-title">Course Enrollment</h4>
                        </div>
                    </div>

                    <div class="page-content-wrapper ">

                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <h4 class="m-b-30 m-t-0"><c:out value="${thisCourse.course.courseTitle}"/></h4>
                                            <div class="row">
                                                <div class="col-xs-12">
												<form action="submitAttendance" method="post">
                                                    <table class="table table-hover">
                                                            <thead>
                                                            <tr>
                                                                <th>First Name</th>
                                                                <th>Last Name</th>
                                                                <th>Agency</th>
                                                                <th>Present</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                             <c:forEach var="enrollment" items="${courseEnrollmentList}">
                                                            <tr>
                                                                <td><c:out value="${enrollment.user.firstName}"/></td>
                                                                <td><c:out value="${enrollment.user.lastName}"/></td>
                                                                <td><c:out value="${enrollment.user.agency.agencyName}"/></td>
                                                                <input type="hidden" name="courseOfferingID" value="${thisCourse.courseOfferingID}"/>
                                                                <td><input type="checkbox" name="enrollmentsPresent" id="${enrollment.enrollmentID}" value="${enrollment.enrollmentID}"/></td>
                                                            </tr>
                                                            </c:forEach>
                                                            </tbody>
                                                        </table>
														<input type="submit" value="Submit Attendance"/>
														</form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> <!-- End Row -->

                            

                        </div><!-- container -->

                    </div> <!-- Page content Wrapper -->

                </div> <!-- content -->

                <footer class="footer">
                    © 2017 State of Missouri - All Rights Reserved.
                </footer>

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