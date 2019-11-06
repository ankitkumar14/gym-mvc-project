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
	<form:form method="post" modelAttribute="trainer" action="addtrainer" class="form-inline">
	<div class="form-group">
            <label for="">username</label>
            <br>
            <form:input type="text" class="form-control" path="username" placeholder="username" value="aaa" />
            <form:errors path="username" />
        </div>
			<br>
			<br>
			<div class="form-group">
			<label for="">name</label>
			<br>
				<form:input path="name" type="text" class="form-control" placeholder="name" value="aaa"/>
				<!-- bind to user.name-->
				<form:errors path="name" />
			</div>
			<br>
			<br>
			<div class="form-group">
           <label for="">EMAIL</label>
			<br>
				<form:input path="email_id" type="text" class="form-control" placeholder="email_id" value="aaa" />
				<form:errors path="email_id" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">PHONE</label>
			<br>
				<form:input path="contact_no" type="text" class="form-control" placeholder="contact_no" value="111"/>
				<!-- bind to user.name-->
				<form:errors path="contact_no" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">achievement</label>
			<br>
				<form:input path="achievement" type="text" class="form-control" placeholder="achievement" value="111"/>
				<!-- bind to user.name-->
				<form:errors path="achievement" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">AGE</label>
			<br>
				<form:input path="age" type="integer" class="form-control" placeholder="age" value="000"/>
				<!-- bind to user.name-->
				<form:errors path="age" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">studiess</label>
			<br>
				<input name="studies" type="text" class="form-control" placeholder="studies"/>
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">slot no</label>
			<br>
				<form:input path="slot_no" type="integer" class="form-control" placeholder="slot_no" value="000"/>
				<!-- bind to user.name-->
				<form:errors path="slot_no" />
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