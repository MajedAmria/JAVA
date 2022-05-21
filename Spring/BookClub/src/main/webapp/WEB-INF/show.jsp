<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read share</title>
</head>
<body>
<h1>${currbook.title}</h1>
<p>${currbook.user.userName} read ${currbook.title} by ${currbook.author}</p>
<p>Here are ${currbook.user.userName} thouts:</p>
<hr>
<p>${currbook.thought}</p>
<hr>
</body>
</html>