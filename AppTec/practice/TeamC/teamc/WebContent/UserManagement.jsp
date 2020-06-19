<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー管理</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/UserManagement.css">
<script type="text/javascript">

function dd() { if(confirm("稼働状況の切り替えを行きますか？" )) return true; return false; }
</script>
</head>
<body>
	<header>
		<div class="container">


			<div class="list">
				<form action="TopServlet" method="post">
					<button class="btn">ホーム</button>

				</form>
				<form action="newUser.jsp" method="post">
					<button class="btn">新規登録</button>

				</form>
			</div>
		</div>

	</header>
	<main>
		<div class="container"></div>
			<div class="tittle">
				<h2>ユーザー管理</h2>
			</div>
			<div>
				<table border="1" class="mytable" >
					<thead>
						<tr>
							<th>アカウント名</th>
							<th>名称</th>
							<th>支社名</th>
							<th>部署名</th>
							<th>登録日時</th>
							<th>稼働状況</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${usersList}">
							<tr>
								<td>
									<form action="ToUserEditServlet" method="post">
										<button class="btn1">編集</button>
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

								<td class="stop">${user.getName()}</td>
								<td class="stop">${user.getBranches_name()}</td>
								<td class="stop">${user.getDepartments_name()}</td>
								<td class="stop"><fmt:formatDate value="${user.getCreated_at()}" pattern="yyyy/MM/dd HH:mm:ss" /></td>


								<td class="stop">

									<form action="StopServlet" method="post" onclick="return dd();">
										<button value="${user.getStop_message()}" class="btn2">${user.getStop_message()}</button>
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
					</tbody>
				</table>
		</div>
	</main>
</body>
</html>