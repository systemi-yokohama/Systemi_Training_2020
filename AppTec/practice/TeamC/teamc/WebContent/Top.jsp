<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>掲示板一覧</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport" content="width=device-width">
<meta name="viewport"
	content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script type="text/javascript">
	function dd() {if(confirm("削除しますか？")) return ture;return false;}

</script>
</head>
<body>
	<header>
		<div class="container">
			<div class="header-left">
				<form action="SerchServlet" method="post" onchange="submit(this.form)">
					<p>投稿日</p>
					<select name="tweetsCreated_at" class="tweetsCreate">

						<option value="">---</option>

						<option value="oneweek">一週</option>

						<option value="onemonth">一ヶ月</option>

						<option value="oneyear">一年</option>


					</select>
				</form>

				<form action="SerchServlet" method="post">
					<p>カテゴリ</p>
					<div id="Category">
						<input name="category" type="text" placeholder="カテゴリ">
						<input type="submit" id="serch" value="🔎">
					</div>

				</form>

			</div>
			<div class="header-right">
				<form action="tweets.jsp" method="post" class="btn">
					<input type="submit" value="新規登録投稿" />
				</form>
				<form action="UserManagementServlet" method="post" class="btn">
					<input type="submit" value="ユーザー管理">
				</form>
				<p class="usermanagement">${commentVal}</p>
				<form action="logout" method="get" class="btn">
					<input type="submit" value="ログアウト">
				</form>

			</div>
		</div>

	</header>
	<div class="main">
	<div class="tweet">
		<c:forEach var="i" items="${ list }">
			<table border="1" class="table">
				<tr>
					<td>件名 ${ i.getSubject() }</td>

					<td>投稿者 ${ i.getUser().getName() }</td>

				</tr>
				<tr>
					<td>本文 ${ i.getText()}</td>
				</tr>
				<tr>
					<td>カテゴリ： ${ i.getCategory() }</td>
					<td>投稿日時 <fmt:formatDate value="${ i.getCreated_at() }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td><c:if test="${ i.getUser().getId() == loginUser.getId() }">
							<form action="TweetDeleteServlet" method="post" class="Tweet" onclick="return dd();">
								<input type="hidden" name="tweet_id" value="${ i.getTweet_id() }">
								<input type="submit" value="削除">
							</form>
						</c:if></td>
				</tr>
				<tr>
					<td colspan="3">
						<form action="CommentServlet" method="post" class="Tweet">
							<input name="comment" type="text" id="comment"
								placeholder="コメント入力" /> <input type="hidden" name="tweetId"
								value="${ i.getTweet_id() }"> <input type="submit"
								value="投稿">
							<c:if test="${ tweetIdCheck == i.getTweet_id() }">
								<br>${ commentVal }
							</c:if>
						</form>
					</td>
				</tr>

				<c:forEach var="c" items="${ i.getComment() }">
					<tr>
						<td>コメント文 ${ c.getText() }</td>
					</tr>
					<tr>
						<td>アカウント名 ${ c.getUser().getName() }</td>
						<td>コメント投稿日時 <fmt:formatDate value="${ c.getCreated_at() }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
						<td><c:if
								test="${ c.getUser().getId() == loginUser.getId() }">
								<form action="CommentDeleteServlet" method="post" class="Comment" onclick="return dd();">
								<input type="hidden" name="comment_id" value="${ c.getId() }">
								<input type="submit" value="削除">
								</form>
							</c:if></td>
					</tr>
				</c:forEach>

			</table>
		</c:forEach>
	</div>
	<c:if test="${ before != null }">
	<form action="TopServlet" method="post" class="Tweet">
		<input type="hidden" name="topTweet" value="${ topTweet }">
		<input type="hidden" name="post" value="-20">
		<input type="submit" value="前へ">
	</form>
	</c:if>
	<c:if test="${ next != null }">
	<form action="TopServlet" method="post" class="Tweet">
		<input type="hidden" name="topTweet" value="${ topTweet }">
		<input type="hidden" name="post" value="20">
		<input type="submit" value="次へ">
	</form>
	</c:if>
	</div>
</body>
</html>