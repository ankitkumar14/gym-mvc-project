<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>ADMIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body style="background: #996633">
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">FIT & FORMULA</a>
			</div>
		</div>
	</nav>
<div class="container">
<div class="jumbotron" style="background:  #ffff00">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome to the admin page :${user}	  | <a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a>
        </h2>
    </c:if>
    </div>
    <h2> <a href="admin/alusers">All USERS</a></h2>
    <h2> <a href="admin/altr">ALL TRAINER</a></h2>
    <h2><a href="admin/aloff">OFFICES</a></h2>
    <h2><a href="admin/slots">SLOTS</a></h2>
    <h2><a href="admin/kits">ALL EQUIPMENT</a></h2>
    <h2><a href="admin/pay">PAYMENT HISTORY</a></h2>
    </div>
</body>
</html>
