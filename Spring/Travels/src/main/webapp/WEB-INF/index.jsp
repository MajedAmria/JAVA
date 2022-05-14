<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Save Travels</h1>

<table>
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
        </tr>
    </thead>
   <tbody>
    <c:forEach var="e" items="${exp}">
    	<tr>
    <td>
    	<c:out value="${e.expense}"/></td>
    	<td>
    	<c:out value="${e.vendor}"/></td>
    	<td>
    	<c:out value="${e.amount}"/></td>
    	</tr>

</c:forEach>
</tbody>
</table>

<h1>Add a expense</h1>
<form:form action="/exp" method="post" modelAttribute="expense">
    <p>
        <form:label path="expense">Expense Name</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
   
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount"/>
    </p>   
     <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p> 
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>