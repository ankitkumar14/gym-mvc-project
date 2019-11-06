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
                
                        <th>NAME</th>
                        <th>ADDRESS</th>
                        <th>EMAIL ID</th>
                        <th>PHONE</th>
                        <th>SLOT NO</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach items="${list}" var="trainer" >
                        <tr>
                            <td>${trainer.username}  </td>
                            <td>${trainer.name}</td>
                            <td>${trainer.address}</td>
                            <td>${trainer.email_id}</td>
                            <td>${trainer.contact_no}</td>
                            <td>${trainer.slot_no}</td>
                        	<td><button><a href="deletetrainer${trainer.username}">Delete this Trainer</a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>