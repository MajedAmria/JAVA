<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Language</h1>
<form:form action="/edit/${language.id}" method="post" modelAttribute="language"  >
<input type="hidden" name="_method" value="put">
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
   
  <input type="submit" value="Edit" class="btn btn-dark"/>
</form:form>
<a href="/delete/${language.id}">delete</a>
</body>
</html>