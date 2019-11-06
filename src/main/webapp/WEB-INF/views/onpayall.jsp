    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>online pay</title>
</head>
<body>
	<table border="1px solid black">
                    <tr>
                        <th>USERNAME</th>
                        <th>AMOUNT</th>
                        <th>PAYMENT DATE</th>
                        <th>PAYMENT USING</th>
                        <th>PAYMENT FROM</th>
                        <th>PAYMENT TO</th>
                        <th>PAYMENT ID</th>
                        <th>Delete it</th>
       
                    </tr>
                    <c:forEach var="online_pay" items="${list}">
                        <tr>
                            <td>${online_pay.username}</td>
                            <td>${online_pay.amount}</td>
                            <td>${online_pay.d_ate}</td>
                            <td>${online_pay.via}</td>
                            <td>${online_pay.start_month}</td>
                            <td>${online_pay.end_month}</td>
                            <td>${online_pay.payment_id}</td>
                        	<td><button><a href="deleteonpay${online_pay.username}">Delete this </a></button></td>
                        </tr>
                    </c:forEach>
                </table>
</body>
</html>