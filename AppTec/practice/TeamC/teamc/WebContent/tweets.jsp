<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規投稿画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/tweets.css">
</head>
<body>
	<div>
		<h1>新規投稿</h1>
	</div>

	<form class="form1" action="/teamc/TopServlet" method="POST">
		<input class="btn" type="submit" value="戻る">
	</form>

	<form class="form2" action="/teamc/TweetServlet" method="POST">
		<div class="main">
			<div class="container">
				<p>
					<input Type="text" placeholder="件名" name="subject">
				</p>
				<p>
					<textarea name="text" placeholder="本文"></textarea>
				</p>
				<p>
					<input Type="text" placeholder="カテゴリー" name="category">
				</p>
		</div>
				<input class="btn2" type="submit" value="投稿">
		</div>
	</form>
		<p class="error">${ error }</p>
		<p class="error">${ error_subject }</p>
		<p class="error">${ error_text }</p>
		<p class="error">${ error_category }</p>

</body>
</html>