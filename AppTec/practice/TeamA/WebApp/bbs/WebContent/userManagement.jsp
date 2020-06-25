
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<!DOCTYPE html>
<html>
    <head>
        <title>ユーザー管理</title>
        <link href="css/style.css" rel="stylesheet">

        <script>
        	function tk() { if(confirm("稼働させますか？" )) return true; return false; }
        	function kt() { if(confirm("停止させますか？" )) return true; return false; }
        </script>

    </head>
	<body>
    <header>
        <h2>掲示板システム</h2>
        <div class="menu">
			 <ul class="fas fa-bars">
			 		<li>${loginUser.getAccount()}：</li>
		         	<li><a href="/bbs/logout">ログアウト</a></li>
	      	 </ul>
      	 </div>
    </header>
    <div class="top topManegement">
        <h3>ユーザー管理</h3>
        <form action="/bbs/signup.jsp">
			<input class="new-person" type="submit" value="新規登録">
		</form>
		<form action="/bbs/contributionIndex">
			<input  class="cansel-person" type="submit" value="戻る">
		</form>
	</div>

	<div class="main-contents">
	<table border="1" style="border-collapse: collapse">
		<tr class="columns">
			<td>編集</td>
			<td>ユーザー状態</td>
			<td>アカウント名</td>
			<td>名称</td>
			<td>支社</td>
			<td>部署</td>
			<td>登録日時</td>
			<td>更新日時</td>
		</tr>

		<c:forEach items="${mnUsers}" var="mnUser">
			<tr>
				<td>
				<form action="/bbs/edit" method="post">
					<input  class="editButton" type="submit" value="編集">
					<input type="hidden" name="account" value="${mnUser.getAccount()}">
					<input type="hidden" name="name" value="${mnUser.getName()}">
				</form>
				</td>
				<td>
				<c:if test="${mnUser.getAccount() == loginUser.getAccount()}">
					<p>稼働中</p>
				</c:if>
				<c:if test="${mnUser.getAccount() != loginUser.getAccount() && mnUser.getStatus() == 0}">
					<form action="/bbs/changeStatus" method="post">
						<input type="hidden" name="account" value="${mnUser.getAccount()}">
						<input type="hidden" name="status" value="${mnUser.getStatus()}">
						<input class="editButton2" type="submit" value="停止中" onclick="return tk();">
					</form>
				</c:if>
				<c:if test="${mnUser.getAccount() != loginUser.getAccount() && mnUser.getStatus() == 1}">
					<form action="/bbs/changeStatus" method="post">
						<input type="hidden" name="account" value="${mnUser.getAccount()}">
						<input type="hidden" name="status" value="${mnUser.getStatus()}">
						<input class="editButton2" type="submit" value="稼働中" onclick="return kt();">
					</form>
				</c:if>

				</td>

				<td>${mnUser.getAccount()}</td>
				<td>${mnUser.getName()}</td>
				<td>${mnUser.getBranchName()}</td>
				<td>${mnUser.getDepartmentName()}</td>
				<td>${mnUser.getCreatedDate()}</td>
				<td>${mnUser.getUpdatedDate()}</td>
			</tr>
		</c:forEach>
	</table>
	</div>

	</body>
	<br>
	<br>
	<br>
	<br>


</html>


