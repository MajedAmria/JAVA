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
<p>You have visited <a href="/">http//your server</a> <c:out value="${count}"/> times</p><br>
<a href="/">Test another visit?</a>
<br>
   <form action='/rest' method='GET'>
    	<input type='submit' value='rest'>
    </form>
</body>
</html>