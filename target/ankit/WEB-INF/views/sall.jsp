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
                        <th>USERNAME</th>
                        <th>SLOT NUMBER</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach var="slot" items="${list}">
                        <tr>
                            <td>${slot.username}</td>
                            <td>${slot.slot_no}</td>
                        	<td><button><a href="deleteslot${slot.username}">Delete this user</a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>