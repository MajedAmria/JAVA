<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Expense Details</h1>
<p>expense name:  ${expense.name}</p> 
<p>expense Description:  ${expense.description}</p>
<p>expense vendor:  ${expense.vendor}</p>
<p>expense amount:  ${expense.amount}</p>
</body>
</html>