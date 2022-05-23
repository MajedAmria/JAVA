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
<title>Project Manger</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<h1 class="body" style="color:hsl(276deg 100% 50%);">Project Manger</h1><br><br>
<h2 class="body">a place for team to manger projects</h2>
<main class="main">
             <div class="row justify-content-center col-md-4 me-5 border p-4 mt-4">
            <h3>Register</h3>
  				<br>
                <form:form action="/register" method="post" modelAttribute="newUser">

                    <form:input path="userName" type="text" class="mb-3 row" placeholder="User name" />
					<form:errors path="userName" style="color:red;"/>
					<br><br>
                    <form:input path="email" type="text" class="mb-3 row" placeholder="Email" />
					<form:errors path="email" style="color:red;" />
					<br><br>
                    <form:input path="password" type="password" class="mb-3 row" placeholder="Password" />
                    <form:errors path="password" style="color:red;" />
					<br><br>
                    <form:input path="confirm" type="password" class="mb-3 row" placeholder="Confirm Passsword"/>
					<form:errors path="confirm" style="color:red;" />
					<br><br>
                    <div class="mb-3 ">
					<button type="submit" class="btn btn-success btn-sm">Register</button>
					</div>
                </form:form>
            
         
</div>
 
   <div class="row justify-content-center col-md-4 me-5 border p-4 my-4">
            
            <h3>Login</h3>
            <br>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                    
                    
                    <form:input path="email" type="text" class="form-control mt-4" placeholder="Email" />
					<form:errors path="email" style="color:red;" />
                    <br><br>
                    <form:input path="password" type="password" class="form-control mt-4" placeholder="Password" />
					<form:errors path="password" style="color:red;" />
					<br><br>
					<div class="mt-4">
					<button type="submit" class="btn btn-success btn-sm">Log in</button>
					</div>
                    
                </form:form>
          
        </div>
 
   
    </main>
</body>
</html>