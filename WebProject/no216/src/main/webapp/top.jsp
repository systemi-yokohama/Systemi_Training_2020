<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>簡易Twitter</title>
		<link href="./style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="main-contents">
			<div class="header">
				<c:if test="${ empty loginUser }">
					<a href="login">ログイン</a>
					<a href="signup">登録する</a>
				</c:if>
				<c:if test="${ not empty loginUser }">
					<a href="./">ホーム</a>
					<a href="settings">設定</a>
					<a href="logout">ログアウト</a>
				</c:if>
			</div>

			<c:if test="${ not empty loginUser }">
			    <div class="profile">
			        <div class="name"><h2><c:out value="${loginUser.name}" /></h2></div>
			        <div class="account">
			            @<c:out value="${loginUser.account}" />
			        </div>
			        <div class="account">
			            <c:out value="${loginUser.description}" />
			        </div>
			    </div>
			</c:if>

			<div class="form-area">
				<c:if test="${ isShowMessageForm }">
					<form action="newMessage" method="post">
						いま、どうしてる？<br />
						<textarea name="message" cols="100" rows="5" class="tweet-box"></textarea>
						<br />
						<input type="submit" value="つぶやく">（140文字まで）
					</form>
				</c:if>
			</div>

			<div class="messages">
			    <c:forEach items="${messages}" var="message">
			            <div class="message">
			                <div class="account-name">
			                    <span class="account"><c:out value="${message.account}" /></span>
			                    <span class="name"><c:out value="${message.name}" /></span>
			                </div>
			                <div class="text"><c:out value="${message.text}" /></div>
			                <div class="date"><fmt:formatDate value="${message.created_date}" pattern="yyyy/MM/dd HH:mm:ss" /></div>
			            </div>
			    </c:forEach>
			</div>
			<div class="copylight"> Copyright(c)YourName</div>
		</div>
	</body>
</html>