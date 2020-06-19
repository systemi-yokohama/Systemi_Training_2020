<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="./style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<header class="container">
		<h2>掲示板システム</h2>
	</header>

	<div class="container">
		<div class="main">

			<h3>ログイン</h3>

			<!-- 入力欄 -->
			<form action="/bbs/home" method="post">
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
           		<br><input type="submit" value="ログイン"><br>
			</form>


		</div>
	</div>
</body></html>