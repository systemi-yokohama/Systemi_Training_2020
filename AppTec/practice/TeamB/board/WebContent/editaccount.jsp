<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集画面</title>
</head>
<body>

	<style type="text/css">
label {
	margin-right: 40px;
	width: 130px;
	float: left;
}

ul li {
	list-style: none;
}

select {
	margin: 0 auto;
	width: 130px;
}

ul {
	width: 500px;
	margin: 0 auto;
}

.new_registration_buttun {
	text-align: center;
}

h5 {
	text-align: center;
}
</style>
</head>
<header>
	<h2>ユーザー編集画面</h2>
	<!-- ユーザ管理画面へ戻る -->
	<form action="UserManagement_Servlet" method="post">
		<input type="submit" value="戻る" formnovalidate
			style="position: absolute; right: 0px; top: 0px">
	</form>
</header>
<body>
	<form action="EditAccountUpdate_Servlet" method="post">
		<br />
		<c:forEach var="user" items="${userslist}">
			<ul>
				<li><label for="new_user_account">アカウント名</label> <input
					type="hidden" name="old_user_account" value="${user.user_account}">
					<input name="new_user_account" type="text" id="user_account"
					value="${user.user_account}" /></li>
				<br>
				<li><label for="user_password">パスワード</label> <input
					name="user_password" type="password" id="user_password" /></li>
				<br>
				<li><label for="check_user_password">パスワード確認</label> <input
					name="check_user_password" type="password" id="check_user_password" />
				</li>
				<br>
				<li><label for="user_name">名称</label> <input name="user_name"
					type="text" id="user_name" value="${user.user_name}" /></li>
				<br>
				<li><label for="user_office">支社</label> <!--<input name="user_office" type="text" id="user_office"  value="${user.office_name}"/>  -->
					<select name="user_office" size="1" id="user_department">
						<option value="1" label="本社" />
						<option value="2" label="A支社" />
						<option value="3" label="B支社" />
						<option value="4" label="C支社" />
				</select></li>
				<br />
				<li><label for="user_department">部署</label> <!--<input name="user_department" type="text" id="user_department" value="${user.department_name}"/>-->
					<select name="user_department" size="1" id="user_department">
						<option value="1" label="総務人事部" />
						<option value="2" label="情報管理部" />
						<option value="3" label="営業部" />
						<option value="4" label="技術部" />
				</select></li>
				<br />

				<li class="new_registration_buttun"><input type="submit"
					name="new_button" value="登録" onClick="touroku()"></li>
			</ul>

		</c:forEach>
	</form>
	<br>
	<c:if test="${ not empty errorMessage}">
		<div class="errorMessage" style="text-align: center; color: red;">
			<a style="text-align: center; color: red;">
				<c:forEach items="${errorMessage}" var="errorMessage">
					<c:out value="${errorMessage}" />
				</c:forEach>

			</a>
		</div>
		<c:remove var="errorMessage" scope="session" />
	</c:if>

</body>
</html>