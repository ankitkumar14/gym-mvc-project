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
                        <th>USERNAME</th>
                        <th>AMOUNT</th>
                        <th>PAYMENT DATE</th>
                        
                        <th>PAYMENT FROM</th>
                        <th>PAYMENT TO</th>
                        <th>PAYMENT IDS</th>
                  
       
                    </tr>
                    <c:forEach var="offline_pay" items="${list}">
                        <tr>
                            <td>${offline_pay.username}</td>
                            <td>${offline_pay.amount}</td>
                            <td>${offline_pay.d_ate}</td>
                            
                            <td>${offline_pay.start_month}</td>
                            <td>${offline_pay.end_month}</td>
                            <td>${offline_pay.payment_id}</td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>