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
<form:form action="/ninja" method="post" modelAttribute="ninja">
  <div class="row mb-3">
    <form:label  path="dojo" class="col-sm-2 col-form-label">Dojo:</form:label>
    <div class="col-sm-10">
    <form:select path="dojo"  class="form-control" id="inputEmail3">
    <c:forEach var="onedojo" items="${Dojos}">
  		<form:option value="${onedojo.id}">
  		<c:out value="${onedojo.name}" />
  		</form:option>
  		
  	
 </c:forEach>
 </form:select>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3" path="firstName" class="col-sm-2 col-form-label">First Name:</form:label>
   <form:errors path="firstName" />
    <div class="col-sm-10">
      <form:input type="text" path="firstName" class="form-control" id="inputPassword3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3"  path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
    <form:errors path="lastName"/>
    <div class="col-sm-10">
      <form:input type="text" path="lastName" class="form-control" id="inputPassword3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3"  path="age" class="col-sm-2 col-form-label">Age</form:label>
    <form:errors path="age"/>
    <div class="col-sm-10">
      <form:input type="text" path="age" class="form-control" id="inputPassword3"/>
    </div>
  </div>
   
  <input type="submit" value="Create" class="btn btn-dark"/>
  </form:form>
</body>
</html>