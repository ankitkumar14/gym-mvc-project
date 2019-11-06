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
                        <th>NAME</th>
                        
                        <th>EMAIL ID</th>
                        <th>PHONE</th>
                        <th>SLOT NUMBER</th>
                    
                    </tr>
                    <c:forEach items="${list}" var="trainer" >
                        <tr>
                          
                            <td>${trainer.name}</td>
                  
                            <td>${trainer.email_id}</td>
                            <td>${trainer.contact_no}</td>
                            <td>${trainer.slot_no}</td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>