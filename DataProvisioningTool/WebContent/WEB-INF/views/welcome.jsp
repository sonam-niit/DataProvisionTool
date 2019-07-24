<%@page import="com.niit.dpt.dataplan.DataPlan"%>
<%@page import="com.niit.dpt.dataplan.PackDetails"%>
<%@page import="java.util.List"%>
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
<p>${requestScope.message }</p>
<a href="welcome">Home</a> |<a href="dataplan">Activated Plan</a> | <a href="profile">profile</a> |<a href="logout">Logout</a>

<h2>New Plans</h2>

<form action="welcome">
  <select name="productId">
    <option value="1">Airtel</option>
    <option value="2">Idea</option>
    <option value="3">Jio</option>
  </select>
  <input type="Submit" value="Submit" name="Submit">
</form>

<c:set var="list"  value="${requestScope.list }"></c:set>
	
	<c:if test="${list!=null }">
	<table border=1>
			<th>Sr.No</th>
	      <TH>Pack/Plan</th>
	      <TH>Validity</th>
	      <TH>Price</th>
	      <TH>Description</th>
	<c:forEach var="u" items="${list }">
		<tr>
		<td>${u.id }
			<td><a href="purchase?planid=${u.id }&&sim=${requestScope.productId }" >${u.pack }</a></td>
			<td>${u.validity }</td>
			<td>${u.price }</td>
			<td>${u.description }</td>
		</tr>
	</c:forEach>
	
	</c:if>
</table>
</body>
</html>