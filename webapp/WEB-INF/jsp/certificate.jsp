<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Certificate</title>
<link href="certificate/styles.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Cookie" rel="stylesheet"> 
</head>
<body>
<div id="border1">
<div id="border2">
<div><img src="certificate/CMPDlogo1.jpg" align="left"/></div>
<div class="main">
       <span class="bgText"><i>Recognizes</i></span>
       <br><br>
       <span id="nameText"><b><c:out value="${enrollment.user.firstName} ${enrollment.user.lastName}"/></b></span><br/><br/>
       <span class="smallText"><i>For successful completion of training in</i></span> <br/><br/>
       <span class="bgText"><c:out value="${enrollment.courseOffering.course.courseTitle}"/></span> <br/><br/>
       <span class="smallText"><i>Awarded and Recognized</i></span><br>
      <span class="bgText"><c:out value="${enrollment.courseOffering.dateOffered}"/></span><br><br>
<div id="signature1">
<img src="certificate/RobertGatesSignature.png" width="200px"/>
<p>Robert Gates</p>
<p>Commissioner of Administration</p>
</div>
<img src="certificate/Missouri State Seal.png" width="200px" height="200px"/>
<div id="signature2">
<img src="certificate/JohnGatesSignature.jpg" width="300px"/>
<p>John Langes</p>
<p>Director of Personnel</p>
</div>
<div class="stcFoot">
<p>State Training Center</p>
<p><strong>www.training.mo.gov</strong></p>
</div>
</div>
</div>
</div>
</body>
</html>