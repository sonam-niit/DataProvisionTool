<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${sessionScope.user.name }</h2>
<a href="welcome">Home</a> |<a href="dataplan">Activated Plan</a> | <a href="profile">profile</a> |<a href="logout">Logout</a>
<h1>My profile Details</h1>
<c:set var="user" value="${sessionScope.user }"></c:set>
<table border=1>
<tr> 
<th>Name:</th>
<td>${user.name }</td>
</tr>
<tr>
<th>Phone:</th>
<td>${user.phone }</td>
</tr>
<tr>
<th>Email:</th>
<td>${user.email }</td>
</tr>
<tr>
<th>Sim Type:</th>
<td>${user.simType }</td>
</tr>
<tr>
<th>Address:</th>
<td>${user.address }</td>
</tr>

 </table>
</body>
</html>