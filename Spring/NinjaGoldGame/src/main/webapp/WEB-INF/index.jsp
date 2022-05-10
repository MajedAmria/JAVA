<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
 Your Gold: <c:out value="${gold}"/>
    <br><br>
    <div class="cont">
    <div class="box">
        <h1>Farm</h1>
        <p>(earn 10-20 golds)</p>
         <form method="post" action="/process_money">
   
        <input type="hidden" name="which_form" value="farm">
        <input type="submit" value="Find Gold">
    </form>

    </div>
    <div class="box">
        <h1>Cave</h1>
        <p>(earn 10-20 golds)</p>
         <form method="post" action="/process_money">
    
        <input type="hidden" name="which_form" value="cave">
        <input type="submit" value="Find Gold">
    </form>
    </div>
    <div class="box">
        <h1>House</h1>
        <p>(earn 10-20 golds)</p>
         <form method="post" action="/process_money">
       
        <input type="hidden" name="which_form" value="house">
        <input type="submit" value="Find Gold">
    </form>
    </div>
    <div class="box">
        <h1>Quest</h1>
        <p>(earn/takes 0-50 golds)</p>
         <form method="post" action="/process_money">
        
        <input type="hidden" name="which_form" value="quest">
        <input type="submit" value="Find Gold">
    </form>
    </div>
</div>
    <div class="bottom">
        <p>Activities:</p>
        <textarea name="activity" readonly>
         <c:out value="${activities}"/>
        </textarea>
    </div>
</body>
</html>