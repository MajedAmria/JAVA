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
<title>Edit Name of Baby</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Change ${baby.babyName}</h1>
<form:form action="/edit/${baby.id}" method="post" modelAttribute="baby">
<input type="hidden" name="_method" value="put">
  <div class="row mb-3">
    <form:label  path="babyName" class="col-sm-2 col-form-label">New Name</form:label>
    <form:errors path="babyName"/>
    <div class="col-sm-10">
      <form:input type="text" path="babyName" class="form-control" id="inputEmail3"/>
    </div>
  </div>
    <div class="row mb-3">
    <form:label  path="gender" class="col-sm-2 col-form-label">Typical Gender:</form:label>
    <div class="col-sm-10">
    <form:select path="gender"  class="form-control" id="inputEmail3">
  		<form:option value="male"/>
  		<form:option value="female"/>
 </form:select>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3" path="origin" class="col-sm-2 col-form-label">Origin</form:label>
    <form:errors path="origin"/>
    <div class="col-sm-10">
      <form:input type="text" path="origin" class="form-control" id="inputPassword3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3"  path="meaning" class="col-sm-2 col-form-label">Meaning</form:label>
    <form:errors path="meaning"/>
    <div class="col-sm-10">
      <form:input type="text" path="meaning" class="form-control" id="inputPassword3"/>
    </div>
  </div>
    
  <input type="submit" value="Submit" class="btn btn-light"/>
 
  </form:form>
  
   <form:form action="/delete/${baby.id}" method="delete">
  <input type="submit" value="Delete" class="btn btn-danger"/>
   </form:form>
 
 
</body>
</html>