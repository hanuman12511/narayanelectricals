<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="fileform" method="post" action="show" >
             <input type="submit" value="Save">
        </form>
        <!DOCTYPE html> 
<html> 
<head> 
<title> Java File Upload Servlet Example </title> 
</head> 
<body>

  <form method="post" action="img1" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Upload" />
  </form>


<h1 style="color:red" align="center">ADD IMAGE DETAIL</h1>

<div align="center">

<form action="AddImage" method="post" enctype="multipart/form-data">
   Select Image :
   <input type="file" name="image">
   <input type="submit" value="Add Image">
</form>

</div>

</body>
</html>
</body>
</html>