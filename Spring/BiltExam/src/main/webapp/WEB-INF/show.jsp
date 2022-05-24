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
<h1>${currbaby.babyName}</h1>
<p>(Added by ${currbaby.user.userName})</p>
<p>Gender : ${currbaby.gender}</p>
<p>Origin : ${currbaby.origin}</p>
<p>Meaning : ${currbaby.meaning}</p>
<hr>
<c:if test="${curruser.id==currbaby.user.id}"><a href="/edit/${currbaby.id}/update"
 style="
 background-color: green;
 text-decoration: none;
  color: white;
">edit</a></c:if>

</body>
</html>

