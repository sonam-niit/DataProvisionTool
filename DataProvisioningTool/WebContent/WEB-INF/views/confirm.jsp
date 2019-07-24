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

<h2> Kindly confirm your selected Plan</h2>
<c:set var="plan" value="${requestScope.plan }"></c:set>
Plan Name: ${plan.pack }<br>
Validity: ${plan.validity }<br>
Price:${plan.price } <br>
Description: ${plan.description }<br>

<a href="confirm?info=${plan.id}&&sim=${requestScope.sim }">Confirm</a>
</body>
</html>