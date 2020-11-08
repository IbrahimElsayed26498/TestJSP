<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<meta http-equiv="content-type" content="text/html">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<title>Add Student</title>
	</head>
	<body>
	<%@page import="DB.StudentDao" %>
		<jsp:useBean id="s" class="DAL.Student"></jsp:useBean>
		<jsp:setProperty property="*" name="s"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>	
		
		<%
			int num = StudentDao.save(s);
			if(num > 0){
				response.sendRedirect("StudentAdded.jsp");
			}else{
				response.sendRedirect("Studentfailed.jsp");
			}
		%>
	</body>
</html>