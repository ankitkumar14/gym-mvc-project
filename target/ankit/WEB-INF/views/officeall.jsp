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
                        <th>No</th>
                        <th>LOcation</th>
                        <th>rating</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach var="office" items="${list}">
                        <tr>
                            <td>${office.no}  </td>
                            <td>${office.location}</td>
                            <td>${User.rating}</td>
                       
                        	<td><button><a href="deleteoffice${office.no}">Delete this office</a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>