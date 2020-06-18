<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<div class=validation>
		<p> ${ val } </p>
	</div>
	<form action="top" method="post">
		<p>
			アカウント<br> <input type="text" name="account">
		</p>
		<p>
			パスワード<br>
			<input type="text" name="password">
		</p>
		<p>
			<input type="submit" value="ログイン">
		</p>
	</form>

</body>
</html>