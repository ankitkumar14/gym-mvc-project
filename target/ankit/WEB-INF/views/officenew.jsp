<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<title>register</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body style="background: #ffe6e6">

<div class="container">
	<form:form method="post" modelAttribute="office" action="addoffice" class="form-inline">
	<div class="form-group">
            <label for="">NUMBER</label>
            <br>
            <form:input type="integer" class="form-control" path="no" placeholder="no" value="000" />
            <form:errors path="no" />
        </div>
			<br>
			<br>
			<div class="form-group">
			<label for="">LOCATION</label>
			<br>
				<form:input path="location" type="text" class="form-control" placeholder="location" value="aaa"/>
				<!-- bind to user.name-->
				<form:errors path="location" />
			</div>
			<br>
			<br>
			
			<div class="form-group">
			<label for="">RATING</label>
			<br>
				<form:input path="rating" type="integer" class="form-control" placeholder="rating" value="0/10"/>
				<!-- bind to user.name-->
				<form:errors path="rating" />
			</div>
			<br>
			<br>
			
			<button type="submit" class="btn btn-primary">Submit</button>
				
				<td>${error}</td>
			
	</form:form>
	</div>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>