    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USERS</title>
</head>
<body>
	<table border="1px solid black">
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Name</th>
                        
                        <th>Email</th>
                        <th>Contacts</th>
                        <th>Address</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach var="users" items="${list}">
                        <tr>
                            <td>${users.username}</td>
                            <td>${users.password}</td>
                            <td>${users.name}</td>
                            
                            <td>${users.email}</td>
                            <td>${users.phone}</td>
                            <td>${users.address}</td>
                        	<td><button><a href="deleteusr${users.username}">Delete this user</a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>