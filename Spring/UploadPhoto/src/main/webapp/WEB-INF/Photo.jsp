<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="/users/save"  method="post" enctype="multipart/form-data" >
    ...
    <div>
     
    <label>Photos: </label>
    <input type="file" name="image" accept="image/png, image/jpeg" />
	<input type="submit" value="upload">
    </div>
    ...</form>
    ${showPhoto}
   
<img src="${user.getPhotosImagePath()}" alt=" helllllooooooo" width="50px" height="50px">

</body>
</html>