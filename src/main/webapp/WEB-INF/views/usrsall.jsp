    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USERS slot</title>
</head>
<body>
	<table border="1px solid black">
                    <tr>
                        <th>USERNAME</th>
                        <th>SLOT NUMBER</th>
                   
       
                    </tr>
                    <c:forEach var="slot" items="${list}">
                        <tr>
                            <td>${slot.username}</td>
                            <td>${slot.slot_no}</td>
                        	
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>