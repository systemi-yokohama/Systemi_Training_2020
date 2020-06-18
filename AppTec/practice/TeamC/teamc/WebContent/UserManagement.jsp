<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー管理</title>
<script type="text/javascript">

function dd() { if(confirm("稼働状況の切り替えを行きますか？" )) return true; return false; }
</script>
</head>
<body>
	<div class="top">
		<h1>ユーザー管理</h1>
	</div>

	<div class="botton">
		<form action="TopServlet" method="post">
			<input type="submit" value="ホームに戻る" />

		</form>
		<form action="newUser.jsp" method="post">
			<input type="submit" value="ユーザー新規登録" />

		</form>
	</div>
	<table border="1">
		<tr>
			<th>アカウント名</th>
			<th>名称</th>
			<th>支社名</th>
			<th>部署名</th>
			<th>登録日時</th>
			<th>稼働状況</th>
		</tr>

			<c:forEach var="user" items="${usersList}">


			<tr>
			<td>
			<form action="ToUserEditServlet" method="post">
			<input type="submit" value="編集" />
			<input type="hidden" name="id" value="${user.getId()}"/>
			<input type="hidden" name="name" value="${user.getName()}"/>
			<input type="hidden" name="account" value="${user.getAccount()}"/>
			<input type="hidden" name="branches" value="${user.getBranches_name()}"/>
			<input type="hidden" name="departments" value="${user.getDepartments_name()}"/>
			<input type="hidden" name="stop" value="${user.getUser_stop()}" />
			<input type="hidden" name="password" value="${user.getPassword()}" />



			${user.getAccount()}
			</form>
			</td>

			<td>${user.getName()}</td>
			<td>${user.getBranches_name()}</td>
			<td>${user.getDepartments_name()}</td>
			<td><fmt:formatDate value="${user.getCreated_at()}" pattern="yyyy/MM/dd HH:mm:ss" /></td>


			<td>

			 <form action="StopServlet" method="post" onclick="return dd();">
		<input type="submit" value="${user.getStop_message()}" />
			<input type="hidden" name="id" value="${user.getId()}"/>
			<input type="hidden" name="name" value="${user.getName()}"/>
			<input type="hidden" name="account" value="${user.getName()}"/>
			<input type="hidden" name="branches" value="${user.getBranches_name()}"/>
			<input type="hidden" name="departments" value="${user.getDepartments_name()}"/>
			<input type="hidden" name="stop" value="${user.getUser_stop()}" />


	</form>


			</td>

			</tr>
			</c:forEach>


	</table>

</body>
</html>