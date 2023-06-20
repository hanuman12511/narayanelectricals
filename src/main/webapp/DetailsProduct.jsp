<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String path=request.getServletContext().getRealPath("images");
System.out.print(path);
Object img =request.getAttribute("imagename");
%>
<td><img src="images/<%=img  %>" style="width:100px"/></td>
<h3> <%= request.getAttribute("name") %></h3>
<h3>Rs. <%= request.getAttribute("rate") %>/-</h3>
<%

Object pid = request.getAttribute("id");
%>
<a href="Addtocart?id=<%=  pid%>">Add To cart</a>
</body>
</html>