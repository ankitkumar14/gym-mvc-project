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
                        <th>NUMBER</th>
                        <th>LOCATION</th>
                        <th>RATING</th>
                 
                    </tr>
                    <c:forEach var="office" items="${list}">
                        <tr>
                            <td>${office.no}  </td>
                            <td>${office.location}</td>
                            <td>${office.rating}</td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>