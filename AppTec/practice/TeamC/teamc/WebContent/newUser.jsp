<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
<title>ユーザー新規</title>
</head>
<body>
	<h1>ユーザー新規</h1>
	<div class="newuser">
	<form action="/teamc/UserManagementServlet" method="post">
		<input type="submit" value="戻る" />
	</form>
		<form action="/teamc/nU" method="post">
			<p>
				アカウント名<input name="account" size="20" />
			</p>
			<p>
				名称<input name="name" size="20" />
			</p>
			<p>
				支社<select name="branches_name">
					<option value=0 selected>支社を選択してください</option>
					<option value=1>本社</option>
					<option value=2>A支社</option>
					<option value=3>B支社</option>
					<option value=4>C支社</option>
				</select>
			</p>
			<p>
				部署<select name="departments_name">
					<option value=0 selected>部署を選択してください</option>
					<option value=1>総務人事</option>
					<option value=2>情報管理</option>
					<option value=3>営業部</option>
					<option value=4>技術部</option>
					</select>
			</p>
			<p>
				パスワード<input name="password" size="20" />
			</p>
			<p>
				確認パスワード<input name="samePassword" size="20" />
			</p>
			<p>
				<input type="submit" value="登録" />
			</p>

			<p>${error }</p>
		</form>
	</div>
</body>
</html>