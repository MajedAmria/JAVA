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
<table class="table table-dark table-striped">
  <tr>
  <th >Name</th>
  <th >Creater</th>
   <th >Version</th>
  <th>Action</th>
  </tr>
  <c:forEach var="lan" items="${language}">
  <tr>
  <td>
<a href="/language/${lan.id}"><c:out value="${lan.languageName}"/></a>
</td>
  <td><c:out value="${lan.creater}"/></td>
  <td><c:out value="${lan.version}"/></td>
  <td><a href="/edit/${lan.id}">edit</a>|<a href="/delete/${lan.id}">delete</a></td>
  </tr>
 </c:forEach>
</table>

<form:form action="/lan" method="post" modelAttribute="lang">
  <div class="row mb-3">
    <form:label  path="languageName" class="col-sm-2 col-form-label">Name</form:label>
    <form:errors path="languageName"/>
    <div class="col-sm-10">
      <form:input type="text" path="languageName" class="form-control" id="inputEmail3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3" path="creater" class="col-sm-2 col-form-label">Creater</form:label>
    <form:errors path="creater"/>
    <div class="col-sm-10">
      <form:input type="text" path="creater" class="form-control" id="inputPassword3"/>
    </div>
  </div>
  <div class="row mb-3">
    <form:label for="inputPassword3"  path="version" class="col-sm-2 col-form-label">Version</form:label>
    <form:errors path="version"/>
    <div class="col-sm-10">
      <form:input type="text" path="version" class="form-control" id="inputPassword3"/>
    </div>
  </div>
   
  <input type="submit" value="Submit" class="btn btn-dark"/>
  </form:form>
</body>
</html>