<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="center">
<h1>Send an Omikuji</h1>
 <form action="/omikuji" method="post">
        <label>Pick any number from 5 to 25</label><br>
        <input type="number" name="number"><br>
        <label>Enter a name of any city</label><br>
        <input type="text" name="name"><br>
         <label>Enter a name of any real person</label><br>
        <input type="text" name="person"><br>
         <label>Enter a professional endeavor or hoppy</label><br>
        <input type="text" name="hoppy"><br>
         <label>Enter any type of living anything</label><br>
        <input type="text" name="living"><br>
        <label>say something nice to someone </label><br>
        <input type="text" name="des"><br>
        <label>send and show a friend </label><br>
        <input type="submit">
    </form>
</body>
</html>