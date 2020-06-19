<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/newUser.css">
<title>ユーザー新規登録</title>
</head>
<body>
	<div class="haba">
		<h1>ユーザー新規登録</h1>
		<br>
		<div class="eiei">
			<form action="/teamc/UserManagementServlet" method="post">
				<input type="submit" value="戻る" />
			</form>
		</div>
		<form action="/teamc/nU" method="post">
			<div class="box">
				<p class="account">
					アカウント名<br> <input name="account" />
				</p>
				<p>
					名称<br> <input name="name" />
				</p>
				<p>
					支社<br> <select name="branches_name">
						<option value=0 selected>支社を選択してください</option>
						<option value=1>本社</option>
						<option value=2>A支社</option>
						<option value=3>B支社</option>
						<option value=4>C支社</option>
					</select>
				</p>
				<p>
					部署<br> <select name="departments_name">
						<option value=0 selected>部署を選択してください</option>
						<option value=1>総務人事</option>
						<option value=2>情報管理</option>
						<option value=3>営業部</option>
						<option value=4>技術部</option>
					</select>
				</p>
				<p>
					パスワード<br> <input name="password" />
				</p>
				<p>
					確認パスワード<br> <input name="samePassword" />
				</p>
			</div>
			<div class="ei">
				<p>
					<input type="submit" value="登録" />
				</p>
			</div>
			<div class="error">
				<p>${error }</p>
			</div>
		</form>
	</div>
</body>
</html>