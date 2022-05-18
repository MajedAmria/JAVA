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
<title>Category Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<main class="main">
<h1 class="center"><c:out value="${category.name}"/></h1>
<a href="/">Home</a>
<hr>
<h1>Products:</h1>
<ul>
<c:forEach var="pro" items="${product}">
<li><c:out value="${pro.name}"/></li>
</c:forEach>
</ul>
<hr>
<h1>Add Product</h1>
<form:form action="/category/new" method="post" modelAttribute="category">
  <div class="row mb-3">
    <div class="col-sm-10">
    <form:select path="products"  class="form-control" id="inputEmail3">
    <c:forEach var="product" items="${pro}">
  		<form:option value="${product.id}">
  		<c:out value="${product.name}" />
  		</form:option>
  	
 </c:forEach>
 </form:select>
    </div>
  </div>
   <input type="submit" value="Create" class="btn btn-dark"/>
  </form:form>
</main>
</body>
</html>