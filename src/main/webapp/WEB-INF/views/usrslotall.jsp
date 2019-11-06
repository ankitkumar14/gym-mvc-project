    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>slots</title>
</head>
<body>
	<table border="1px solid black">
                    <tr>
                        <th>SLOT NUMBER</th>
                        <th>STARTING TIME</th>
                        <th>ENDING TIME</th>
                        <th>NO OF STUDENT</th>
       
                    </tr>
                    <c:forEach var="slotdash" items="${list}">
                        <tr>
                            <td>${slotdash.slot_no}</td>
                            <td>${slotdash.start_time}</td>
                            <td>${slotdash.end_time}</td>
                            <td>${slotdash.no_of_stud}</td>
       
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>