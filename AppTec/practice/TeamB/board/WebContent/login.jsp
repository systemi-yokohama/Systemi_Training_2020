<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Here</title>
</head>
<body>
	<form action="/board/login" method="post">
		<c:if test="${ not empty errorMessages }">
			<div class="errorMessages">
				<ul>
					<c:forEach items="${errorMessages}" var="errorMessage">
						<c:out value="${errorMessage}" />
					</c:forEach>
				</ul>
			</div>
			<c:remove var="errorMessages" scope="session" />
		</c:if>
	</form>

	<form action="/board/login" method="post">
		<br /> <label for="account">アカウント:</label> <input name="account"
			id="account" /><br /> <label for="pw">パスワード:</label> <input
			type="password" name="password" id="pw" /><br />
		<p>
			<input type="submit" value="ログイン" />
		</p>
	</form>

</body>
</html>