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
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<main class="main">
<h1 class="center">New Product</h1>
<a href="/">Home</a>
<hr>
<form:form action="/product/new" method="post" modelAttribute="product">
<table class="table">
  <tbody class="table-group-divider">
    <tr>
      <td scope="col">Name</td>
      <td scope="col"><form:input type="text" path="name" placeholder="Name"/>
      <form:errors path="name"/>
      </td>
    </tr>
    <tr>
      <td scope="col">Description</td>
      <td scope="col"><form:input type="text" path="description" placeholder="Description"/>
      <form:errors path="description"/>
      </td>
    </tr>
    <tr>
      <td scope="col">Price</td>
      <td scope="col"><form:input type="number" path="price" placeholder="Price"/>
      <form:errors path="price"/>
      </td>
    </tr>
    <tr >
      <td scope="col"><input  type="submit" value="Submit"></td>
    </tr>
  </tbody>
</table>
</form:form>
</main>
</body>
</html>