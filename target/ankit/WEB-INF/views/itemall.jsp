    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>items</title>
</head>
<body>
	<table border="1px solid black">
                    <tr>
                        <th>kit id</th>
                  
                        <th>Name</th>
                        
                        <th>weight</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach var="kit" items="${list}">
                        <tr>
                            <td>${kit.kid}</td>
                            <td>${kit.name}</td>
                            
                            <td>${kit.size}</td>
                        	<td><button><a href="deleteitm${kit.kid}">Delete this kit</a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>