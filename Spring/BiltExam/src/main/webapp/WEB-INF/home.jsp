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
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-sm mt-3">
		<div class="row justify-content-center">
			<div class="col-md-10">
			<div>
			<h2>Hello, <c:out value="${currentUser.userName}"/>. Here are some name suggestions   </h2>      </div>
			        
			     	<div><h2> <a href="/logout" style="text-decoration: none;">Logout</a></h2></div> 
			</div>
		</div>
	</div>
	
	<br><br>
	
	
	 <table class="table">
<th>Baby Names</th>
<th></th>
<th></th>
<th>Votes</th>
  <c:forEach var="baby" items="${babies}">
  <tr>
  <td>
  <form:form action="/upvvote" method="post" modelAttribute="baby">
	<input style="background-color: #b4a7d6" type="submit" value="upvote!"/>
	<a href="/show/${baby.id}"><c:out value="${baby.babyName}"/></a>
	</form:form>
	
 </td>
 
  
  <td><c:out value="${baby.gender}"/></td>
 
  <td><c:out value="Origin:${baby.origin}"/></td>
  <td><c:out value="28"></c:out></td>
  </tr>
 </c:forEach>
</table>

<a href="/new" 
 style="
 background-color: green;
 text-decoration: none;
  color: white;
"
 >  new name</a>

</body>
</html>