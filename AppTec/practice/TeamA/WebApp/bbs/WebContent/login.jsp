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
		掲示板システム
	</header>

	<div class="container">
		<div class="main">
			<h3>ログイン</h3>
			<form method="post">
				<p>アカウント：<input type="text" name="account"></p>
				<p>パスワード：<input type="password" name="account"></p>

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

           		<br><input type="submit" value="ログイン"><br>
			</form>
		</div>
	</div>
</body></html>