<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Road share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-sm mt-3">
		<div class="row justify-content-center">
			<div class="col-md-10">
			<h2>Welcome <c:out value="${currentUser.userName}"/></h2>
			<h5><a href="/logout" style="text-decoration: none;">Logout</a></h5>
			</div>
		</div>
	</div>
	
	<p>Books from everyone shelves</p>
	
	<span><a href="/new">+ add to my shelf</a></span>
  <table class="table table-dark table-striped">
  <tr>
  <th >ID</th>
  <th >Title</th>
  <th >Author Name</th>
   <th >Posted By</th>
  </tr>
  <c:forEach var="book" items="${books}">
  <tr>
  <td>
	<c:out value="${book.id}"/>
 </td>
  <td><a href="/show/${book.id}"><c:out value="${book.title}"/></a></td>
  <td><c:out value="${book.author}"/></td>
  <td><c:out value="${book.user.userName}"/></td>
  </tr>

 </c:forEach>
</table>


</body>
</html>