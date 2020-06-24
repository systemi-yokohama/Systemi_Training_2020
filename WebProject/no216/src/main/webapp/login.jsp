<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログイン</title>
		<link href="./style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="main-contents">

			<!--エラーメッセージの中にあったら配列の中にある分だけ出力-->
			<c:if test="${ not empty errorMessages }">
				<div class="errorMessages">
					<ul>
						<c:forEach items="${errorMessages}" var="message">
							<li><c:out value="${message}" />
						</c:forEach>
					</ul>
				</div>
				<c:remove var="errorMessages" scope="session"/>
			</c:if>

			<!--actionのところに送られる-->
			<form action="login" method="post"><br />
				<label for="accountOrEmail">アカウント名かメールアドレス</label>
				<input name="accountOrEmail" id="accountOrEmail"/> <br />

				<label for="password">パスワード</label>
				<input name="password" type="password" id="password"/> <br />

				<input type="submit" value="ログイン" /> <br />
				<a href="./">戻る</a>
			</form>
			<div class="copylight"> Copyright(c)YourName</div>
		</div>
	</body>
</html>