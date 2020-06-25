<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規投稿</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/tweets.css">
</head>
<body>

	<div id="main">
		<div>
			<h1><span>新</span>規投稿</h1>
		</div>
		<div class="submain">
				<form class="form1" action="/teamc/TopServlet" method="POST">
					<button class="btn btn1">戻る</button>
<!-- 					<input class="btn btn1" type="submit" value="戻る"> -->
				</form>

			<form class="form2" action="/teamc/TweetServlet" method="POST">
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
<!-- 						<input class="btn btn2" type="submit" value="投稿"> -->
						<button class="btn btn2">投稿</button>
			</form>
			<p class="error">${ error }</p>
			<p class="error">${ error_subject }</p>
			<p class="error">${ error_text }</p>
			<p class="error">${ error_category }</p>
		</div>
	</div>
</body>
</html>