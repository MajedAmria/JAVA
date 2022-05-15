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
<h1>language Details</h1>
<p>expense name:  ${language.languageName}</p> 
<p>expense Description:  ${language.creater}</p>
<p>expense vendor:  ${language.version}</p>
<a href="/edit/${language.id}">edit</a><br>
<a href="/delete/${language.id}">delete</a>
</body>
</html>