<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
<title>ユーザー編集</title>
</head>
<body>
	<h1>ユーザー編集</h1>
	<div class="useredit">
	<form action="UserManagementServlet" method="post">
		<input type="submit" value="戻る">
		</form>

	<form action="UserEditServlet" method="post">

			<p>


				アカウント名<input name="account" type="text" size="20" value="${Edit.getAccount()}" />
				<input type="hidden" name="accountp" value="${Edit.getAccount()}"/>
				<input type="hidden" name="id" value="${Edit.getId()}"/>
				<input type="hidden" name="passwordp" value="${Edit.getPassword()}" />
			</p>
			<p>
				名称<input name="name" size="20" type="text" value="${Edit.getName()}"  />
			</p>

			<p>
				支社<select name="branches_name">
				<option value="0" selected>支社を選択してください</option>
				<c:forEach var="branches" items="${branches}">

					<option value="${branches.getId()}">${branches.getName()}</option>
				</c:forEach>
				</select>
			</p>

			<p>
				部署<select name="departments_name">
				<option value="0" selected>部署を選択してください</option>
				<c:forEach var="departments" items="${departments}">

					<option value="${departments.getId()}">${departments.getName()}</option>
				</c:forEach>
					</select>
			</p>
			<p>
				パスワード<input name="password" size="20" />
			</p>
			<p>
				確認パスワード<input name="samePassword" size="20" />
			</p>


				<input type="submit" value="編集" />
			</form>
			<p>${error}</p>

	</div>
</body>
</html>