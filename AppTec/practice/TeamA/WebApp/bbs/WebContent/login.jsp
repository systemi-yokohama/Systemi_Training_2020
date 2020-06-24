<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン</title>
	<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<header>
		<h2>掲示板システム</h2>
	</header>

		<div class="login-top">
			<h3>ログイン</h3>
		</div>
		<br>
		<br>
		<div class="login-container">
			<!-- 入力欄 -->
			<form action="/bbs/login" method="post">
				<label for="account">アカウント：</label>
				<input type="text" name="account" value="${account}"/><br/>

				<br/>

				<label for="password">パスワード：</label>
				<input type="password" name="password" value="${password}"><br/>

				<br/>

				<!-- エラーメッセージの表示 -->
				<c:if test="${ not empty errorMessages }">
	                <div class="errorMessages">
	                    <ul>
	                        <c:forEach items="${errorMessages}" var="message">
	                            <li><c:out value="${message}" />
	                        </c:forEach>
	                    </ul>
	                </div>
                	<c:remove var="errorMessages" scope="session" />
           		</c:if>

				<!-- ログインボタン -->
           		<br><input class="submit" type="submit" value="ログイン"><br>
			</form>
	</div>
</body>
</html>