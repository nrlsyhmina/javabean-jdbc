<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>User Logged Successfully</title>
</head>
<body>
	<center>
		<%
			String name = (String) session.getAttribute("firstName");
			String userid = (String) session.getAttribute("userid");
		%>
		Welcome <%=name%>
	</center>
	<br>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href='buy.jsp'>Buy</a>
	<a href='update?userid=<%=userid %>'>Update</a>
	<a href='delete?userid=<%=userid %>'>Delete</a>
</body>
</html>
