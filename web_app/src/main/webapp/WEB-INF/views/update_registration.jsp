<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration Here...</title>
</head>
<body>
	<form action="updateReg" method="post">
		<input type="hidden" name="id" value="${reg.id}" />
		<table style="border: 1px solid black;">
			<tr>
				<th style="border: 1px solid blue;">First Name</th>
				<th style="border: 1px solid blue;">Last Name</th>
				<th style="border: 1px solid blue;">Email Id</th>
				<th style="border: 1px solid blue;">Mobile Number</th>
			</tr>
			<tr>
				<td style="border: 1px solid blue;"><input type="text"
					id="firstName" name="firstName" value="${reg.firstName}" /></td>
				<td style="border: 1px solid blue;"><input type="text"
					id="lastName" name="lastName" value="${reg.lastName}" /></td>
				<td style="border: 1px solid blue;"><input type="text"
					id="email" name="email" value="${reg.email}" /></td>
				<td style="border: 1px solid blue;"><input type="text"
					id="mobile" name="mobile" value="${reg.mobile}" /></td>
			</tr>
		</table>
		<input type="submit" value="Update Registration" />
	</form>
</body>
</html>