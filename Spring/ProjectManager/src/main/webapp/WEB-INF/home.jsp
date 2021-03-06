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
<title>Project Manger Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-sm mt-3">
		<div class="row justify-content-center">
			<div class="col-md-10">
			<h2>Welcome <c:out value="${currentUser.userName}"/> !</h2>
			<span><a href="/logout">log out</a></span>
			</div>
		</div>
	</div>
	
	<h1>All projects</h1>
<a href="/new">new project</a>
	
  <table class="table table-dark table-striped">
  <tr>
  <th >Project</th>
  <th >Team Lead</th>
  <th >Due Date</th>
  <th >Action</th>
  </tr>
  <c:forEach var="project" items="${notcontain}">
  <tr>
  <td><a href=""><c:out value="${project.title}"/></a></td>
  <td><c:out value="${project.user.userName}"/></td>
  <td><c:out value="${project.duedate}"/></td>
  <td><a href="">Join team</a></td>
  </tr>
 </c:forEach>
</table>

 <h3>Your Projects </h3>
  <table class="table table-dark table-striped">
  <tr>
  <th >Project</th>
  <th >Lead</th>
   <th >Due Date</th>
   <th >Actions</th>
  </tr>
  <c:forEach var="pro" items="${contain}">
  <tr>

  <td><a href="/show/${pro.id}"><c:out value="${pro.title}"/></a></td>
  <td><c:out value="${pro.leadProject}"/></td>
  <td><c:out value="${pro.duedate}"/></td>
  <td><a href="/return/${pro.id}">edit</a></td>
  </tr>

 </c:forEach>
</table>
</body>
</html>