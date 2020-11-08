<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%@page import="DAL.Student" %>
	<%@page import="DB.StudentDao" %>
	<%@page import="java.util.*" %>
	<%@page import="java.io.*" %>
	<%@page import="java.sql.*" %>
	<%@page import="javax.servlet.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<head>
		<meta charset="ISO-8859-1">
		<title>View Student</title>
	</head>
	<body>
		<%
			List<Student> list = StudentDao.getAllRecords();
			request.setAttribute("list", list);
		%>
		<table class="table table-bordered">
			<caption>All students</caption>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach var='s' items='${list}'>
					<tr>
						<td>${s.getFirstName()}</td>
						<td>${s.getLastName()}</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		
		
	</body>
</html>