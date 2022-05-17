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
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1> Create Dojo</h1>
<form:form action="/dojo" method="post" modelAttribute="dojo">
  <div class="row mb-3">
    <form:label for="inputPassword3"  path="name" class="col-sm-2 col-form-label">Name</form:label>
    <form:errors path="name"/>
    <div class="col-sm-10">
      <form:input type="text" path="name" class="form-control" id="inputPassword3"/>
    </div>
  </div>
   
  <input type="submit" value="Create" class="btn btn-dark"/>
  </form:form>
</body>
</html>