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
<title>Book share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Edit Book</h1>
<form:form action="/edit/${book.id}" method="post" modelAttribute="book">
<input type="hidden" name="_method" value="put">
  <div class="row mb-3">
    <form:label  path="title" class="col-sm-2 col-form-label">Title</form:label>
    <form:errors path="title"/>
    <div class="col-sm-10">
      <form:input type="text" path="title" class="form-control" id="inputEmail3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3" path="author" class="col-sm-2 col-form-label">Author</form:label>
    <form:errors path="author"/>
    <div class="col-sm-10">
      <form:input type="text" path="author" class="form-control" id="inputPassword3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3"  path="thought" class="col-sm-2 col-form-label">My Thought</form:label>
    <form:errors path="thought"/>
    <div class="col-sm-10">
      <form:input type="text" path="thought" class="form-control" id="inputPassword3"/>
    </div>
  </div>
   
  <input type="submit" value="Edit" class="btn btn-dark"/>
  </form:form>
</body>
</html>