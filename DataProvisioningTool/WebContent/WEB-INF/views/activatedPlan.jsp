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
<br><br>
<c:if test="${requestScope.plan!=null }">
	<h2>Your plan details saved successfully.. services will be activated in 24 hours</h2>
	<h3>Followings are your plan details</h3>
	<c:set var="plan" value="${requestScope.plan }"></c:set>
		Plan Name: ${plan.pack }<br>
		Validity: ${plan.validity }<br>
		Price:${plan.price } <br>
		Description: ${plan.description }<br>
	</c:if>
	
	<c:set var="list"  value="${requestScope.plans }"></c:set>
	
	<c:choose>
	<c:when test="${list!=null }">
	<table border=1>
			<th>Sr.No</th>
	      <TH>Pack/Plan</th>
	      <TH>Validity</th>
	      <TH>Price</th>
	      <TH>Description</th>
	<c:forEach var="u" items="${list }">
		<tr>
		<td>${u.id }
			<td>${u.pack }</td>
			<td>${u.validity }</td>
			<td>${u.price }</td>
			<td>${u.description }</td>
		</tr>
	</c:forEach>
	</c:when>
	<c:otherwise>
		No plan yet purchased
	</c:otherwise>
	</c:choose>
	</table>
</body>
</html>