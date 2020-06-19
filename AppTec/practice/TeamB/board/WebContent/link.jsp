<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.Users"%>

 <%
Users users = (Users) session.getAttribute("loginUser");


 System.out.println(users);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/board/UserManagement_Servlet" method="post">
		<input type="submit" value="次画面へ">
	</form>

</body>
</html>


