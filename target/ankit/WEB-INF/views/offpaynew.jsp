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
	<form:form method="post" modelAttribute="offline_pay" action="addoff" class="form-inline">
	<div class="form-group">
            <label for="">username</label>
            <br>
            <form:input type="text" class="form-control" path="username" placeholder="username" value="aaa" />
            <form:errors path="username" />
        </div>
			<br>
			<br>
			<div class="form-group">
			<label for="">amount</label>
			<br>
				<form:input path="amount" type="integer" class="form-control" placeholder="amount" value="0"/>
				<!-- bind to user.name-->
				<form:errors path="amount" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">date</label>
			<br>
				<form:input path="d_ate" type="text" class="form-control" placeholder="d_ate" value="aaa"/>
				<!-- bind to user.name-->
				<form:errors path="d_ate" />
			</div>
			<br>
			<br>
			<div class="form-group">

				<label for="">from</label>
				<br>
				<form:input path="start_month" type="text" class="form-control" placeholder="start_month" value="aaa" />
				<!-- bind to user.name-->
				<form:errors path="start_month" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">to</label>
			<br>
				<form:input path="end_month" type="text" class="form-control" placeholder="end_month" value="111"/>
				<!-- bind to user.name-->
				<form:errors path="end_month" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">payment</label>
			<br>
				<form:input path="payment_id" type="text" class="form-control" placeholder="payment_id" value="000"/>
				<!-- bind to user.name-->
				<form:errors path="payment_id" />
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