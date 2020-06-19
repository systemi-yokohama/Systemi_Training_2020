<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.Users"%>

<%
	// beanのUsersを取得
	Users users = (Users) session.getAttribute("loginUser");

	// bean内のUser_officeを変数に代入
	String office = users.getUser_office();
	String department = users.getUser_department();

	System.out.println("officeID：" + office);
	System.out.println("departmentID：" + department);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板システム「board」</title>
</head>
<body>
	<header>
		<h1 class="left" align="left">
			<form action="/board/newpost.jsp" method="post">
				<input type="submit" value="新規投稿">
			</form>
		</h1>

		<h1 class="right" align="right">
			<form action="/board/Logout_Servlet" method="post">
				<input type="submit" value="ログアウト">
			</form>

			<%
				if (office.equals("1") && department.equals("1")) {
			%>
			<form action="/board/UserManagement_Servlet" method="post">
				<input type="submit" value="ユーザー管理画面はこちら">
			</form>
			<%
				} else {
			%>
			<form action="/board/UserManagement_Servlet" method="post">
				<input type="submit" value="ユーザー管理画面はこちら" disabled>
			</form>
			<%
				}
			%>
		</h1>
	</header>

	<h1>投稿一覧</h1>
	<form action="/board/HomeCategory_Servlet" method="post">
		<a style="float: right;">カテゴリー検索：<input type="text"
			name="category"></a>
	</form>
	<form action="/board/HomeDate_Servlet" method="post">
		<a style="float: right;">期間指定： <input name="dateA" type="date" />～<input
			name="dateB" type="date" /> <input type="submit" value="検索" /></a>
	</form>
	<br>




	<c:forEach var="write_List" items="${writesList}">
		<a style="float: left;">投稿日：${write_List.getWriteDate()}</a>
		<br>
		<table border="1" style="table-layout: fixed; width: 100%;">
			<tr>
				<th>名前</th>
				<td>${ write_List.getName() }</td>
				<th>カテゴリ</th>
				<td>${ write_List.getCategory() }</td>
			</tr>
			<tr>
				<th>件名</th>
				<td colspan="3">${ write_List.getSubject() }</td>
			</tr>
			<tr>
				<th>本文</th>
				<td colspan="3" style="word-wrap: break-word;">${ write_List.getText() }</td>
			</tr>

			<c:forEach var="comment_List" items="${commentsList}">
				<!-- 	<c:if test="${not empty comment_List.getCommentText() }" > -->
				<c:if
					test="${comment_List.getComment_write_id() ==  write_List.getWrite_id()}">
					<tr>
						<th>コメント</th>
						<td colspan="3" style="word-wrap: break-word;">${ comment_List.getCommentText() }</td>
					</tr>
				</c:if>
				<!--	</c:if> -->
			</c:forEach>

				 <td>
                <form action="/board/Delete_Write_Servlet" method="post">
                <input type="hidden" name="write_id" value="${ write_List.getWrite_id() }"/>
				<button>削除</button>
				</form>
                </td>

		</table>
			</c:forEach>
		<br>
		<details>
			<summary>コメント欄</summary>
			<c:forEach var="Comment_List" items="${commentsList }">
				<p>${ Comment_List.text }</p>
				<button onclick="#" style="float: right;">削除</button>
				<br>
			</c:forEach>
			<h4>コメントの投稿</h4>
			<div class="form-area">
				<c:if test="${ isShowCommentForm }">
					<form action="newcomment" method="post">
						<textarea name="comment" cols="100" rows="5" class="comment-box"></textarea>
						<br /> <input type="submit" value="投稿">（500文字まで）
					</form>
				</c:if>
			</div>
		</details>
		<button onclick="#" style="float: right;">削除</button>
		<a style="float: right;">投稿日：2020/06/12</a>
		<br>
		<a href="#" style="float: right;">前の10件</a>
		<a href="#" style="float: left;">次の10件</a>

		<c:if test="${ not empty categoryMessage}">
			<div class="categoryMessage">
				<ul style="text-align: center; color: red;">
					<c:forEach items="${categoryMessage}" var="categoryMessage">
						<c:out value="${categoryMessage}" />
					</c:forEach>
				</ul>
			</div>
			<c:remove var="categoryMessage" scope="session" />
		</c:if>

		<c:if test="${ not empty dateMessage}">
			<div class="dateMessage">
				<ul style="text-align: center; color: red;">
					<c:forEach items="${dateMessage}" var="dateMessage">
						<c:out value="${dateMessage}" />
					</c:forEach>
				</ul>
			</div>
			<c:remove var="dateMessage" scope="session" />
		</c:if>
</body>
</html>