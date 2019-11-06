    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>offline pay</title>
</head>
<body>
	<table border="1px solid black">
                    <tr>
                        <th>Username</th>
                        <th>amount</th>
                        <th>date</th>
                        
                        <th>from</th>
                        <th>to</th>
                        <th>payment_id</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach var="offline_pay" items="${list}">
                        <tr>
                            <td>${offline_pay.username}</td>
                            <td>${offline_pay.amount}</td>
                            <td>${offline_pay.d_ate}</td>
                            
                            <td>${offline_pay.start_month}</td>
                            <td>${offline_pay.end_month}</td>
                            <td>${offline_pay.payment_id}</td>
                        	<td><button><a href="deleteoffpay${offline_pay.username}">Delete this </a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>