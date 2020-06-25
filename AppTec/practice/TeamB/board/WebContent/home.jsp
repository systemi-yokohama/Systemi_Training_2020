<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.Users"%>
<%@ page import="bean.Home_bean"%>
<%@ page import="bean.Writes"%>

<%
	// beanのUsersを取得
	Users users = (Users) session.getAttribute("loginUser");

	// bean内のUser_officeを変数に代入
	String office = users.getUser_office();
	String department = users.getUser_department();

	System.out.println("ホーム画面");
	System.out.println("officeID：" + office);
	System.out.println("departmentID：" + department);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板システム「board」</title>

<script type="text/javascript">
	function dd() {
		if (confirm("削除しますか？"))
			return true;

		return false;
	}
</script>

</head>
<body>
	<header>
		<h1 class="left" align="left">
			<form action="/board/newpost.jsp" method="post">
				<input type="submit" value="新規投稿">
			</form>
		</h1>

		<h1 class="right" align="right">
			<form action="Logout_Servlet" method="post">
				<input type="submit" value="ログアウト">
			</form>
			<%
				if (office.equals("1") && department.equals("1")) {
			%>
			<form action="UserManagement_Servlet" method="post">
				<input type="submit" value="ユーザー管理画面はこちら">
			</form>
			<%
				} else {
			%>
			<form action="UserManagement_Servlet" method="post">
				<input type="submit" value="ユーザー管理画面はこちら" disabled>
			</form>
			<%
				}
			%>
		</h1>
	</header>
	<h1>投稿一覧</h1>
	<div>
		<form action="Home_Servlet" method="post">
			<a style="float: right;"><input type="submit"
				style="color: red; background-color: #ffcce5;" value="検索リセット" /></a>
		</form>
		<br> <br>
		<form action="HomeCategory_Servlet" method="post">
			<a style="float: right;">カテゴリー検索：<input type="text"
				name="category"></a>
		</form>
		<form action="HomeDate_Servlet" method="post">
			<a style="float: right;">期間検索： <select name="date" size="1">
					<option value="1" label="1日以内" />
					<option value="3" label="3日以内" />
					<option value="7" label="1週間以内" />
					<option value="30" label="1ヶ月以内" />
			</select> <input type="submit" value="検索" />
			</a>
		</form>
	</div>

	<c:forEach var="write_List" items="${writesList}">
		<a style="float: left;">投稿日：${write_List.getWrite_created_date()}</a>
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

				<th>本文
                    <c:if test="${ user_id == write_List.getWrite_user_id() }">
					<form action="Delete_Write_Servlet" method="post">
						<input type="hidden" name="write_id"
							value="${ write_List.getWrite_id() }" />
						<button onclick="return dd();">削除</button>
					</form>
					</c:if>

				</th>
				<td colspan="3" style="word-wrap: break-word;">${ write_List.getText() }</td>
			</tr>

			<c:forEach var="comment_List" items="${commentsList}">
				<c:if
					test="${comment_List.getComment_write_id() ==  write_List.getWrite_id()}">
					<tr>
						<th>コメント

						<c:if test="${ user_id == comment_List.getComment_user() }">
							<form action="Delete_Comment_Servlet" method="post">
								<input type="hidden" name="comment_id"
									value="${ comment_List.getComment_id() }" />
								<button onclick="return dd();">削除</button>
							</form>
							</c:if>
						</th>
						<td colspan="3" style="word-wrap: break-word;">${ comment_List.getComment_text() }</td>
					</tr>

				</c:if>

			</c:forEach>


		</table>

		<p>コメントの投稿</p>
		<form action="NewComment_Servlet" method="POST">
			<input type="hidden" name="comment_write_id"
				value="${write_List.write_id}">
			<textarea name="comment_text" id="comment_text" style="width: 100%"></textarea>
			<c:if test="${ not empty errorMessage}">
				<a style="text-align: center; color: red;"> <c:forEach
						items="${errorMessage}" var="errorMessage">
						<c:out value="${errorMessage}" />
					</c:forEach>
				</a>
				<c:remove var="errorMessage" scope="session" />
			</c:if>
			<button>投稿</button>
		</form>
	</c:forEach>


	<br>

	<c:if test="${ not empty searchResults}">
		<div class="searchResults">
			<ul style="text-align: center; color: red;">
				<c:forEach items="${searchResults}" var="searchResults">
					<c:out value="${searchResults}" />
				</c:forEach>
			</ul>
		</div>
		<c:remove var="searchResults" scope="session" />
	</c:if>
</body>
</html>