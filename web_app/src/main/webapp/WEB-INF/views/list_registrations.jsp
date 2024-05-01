<%@page import="com.webapp.entity.Registration"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table style="border:1px solid black;">
		<tr>
			<th style="border:1px solid blue;">First Name</th>
			<th style="border:1px solid blue;">Last Name</th>
			<th style="border:1px solid blue;">Email Id</th>
			<th style="border:1px solid blue;">Mobile Number</th>
		</tr>		
		<c:forEach var="reg" items="${registrations}">
		<tr>
			<td style="border:1px solid blue;">${reg.firstName}</td>
			<td style="border:1px solid blue;">${reg.lastName}</td>
			<td style="border:1px solid blue;">${reg.email}</td>
			<td style="border:1px solid blue;">${reg.mobile}</td>
			<td style="border:1px solid red;"><a href="delete?id=${reg.id}">delete</a></td>
			<td style="border:1px solid yellow;"><a href="getRegistrationById?id=${reg.id}">update</a></td>
		</tr>
		</c:forEach>
	</table>	
</body>
</html>