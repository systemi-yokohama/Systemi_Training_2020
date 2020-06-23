<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/login.css">
</head>
<body>
<div class="container">
	<h1>ログイン</h1>
	<div class="validation">
	<c:if test="${ val != null }"><p> ${ val } </p></c:if>
		<c:if test="${ val == null }"><p>  <br></p></c:if>
	</div>
	<form action="top" method="post">
		<p>
			アカウント<br> <input type="text" name="account">
		</p>
		<p>
			パスワード<br> <input type="password" name="password">
		</p>
			<input class="btn" type="submit" value="ログイン">
	</form>
</div>
</body>
</html>