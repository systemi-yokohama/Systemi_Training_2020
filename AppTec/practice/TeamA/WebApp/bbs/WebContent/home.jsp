<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="./style.css" rel="stylesheet" type="text/css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

	<script>
        	function delcb() { if(confirm("投稿を削除しますか？" )) return true; return false; }
        	function delcm() { if(confirm("コメントを削除しますか？" )) return true; return false; }
    </script>

</head>
<body>
	<header class="container">
		<h2>掲示板システム</h2>
		 <ul class="fas fa-bars">
		 	 <c:if test="${loginUser.getDepartmentId() == 1}">
	         	<li><a href="/bbs/userManagement">ユーザー管理</a></li>
	         </c:if>
	         	<li><a href="/logout">ログアウト</a></li>
      	 </ul>
	</header>

	<div class="container">
		<div class="top">
			<h3>投稿一覧</h3>

			<!-- 新規投稿ボタン -->
			<a href="/bbs/newContribution.jsp">
            	<button type="button">新規投稿</button>
      		</a>

      		<!-- 絞り込み -->
      		<div  class="narrow">
				<form action="/bbs/narrow" method="post">
		      		<p>〇投稿日</p>
						<select name="date">
							<option value="" selected>期間を選択してください</option>
							<option value="1d">1日以内</option>
							<option value="3d">3日以内</option>
							<option value="1w">1週間以内</option>
							<option value="1m">1ヶ月以内</option>
							<option value="3m">3ヶ月以内</option>
							<option value="1y">1年以内</option>
						</select>
					<p>〇カテゴリー</p>
						<input type="text" name="category" />
						<!-- エラーメッセージの表示 -->
						<c:if test="${ not empty categoryError }">
						        <p>${categoryError}</p>
					        <c:remove var="categoryError" scope="session" />
					    </c:if>
					<!-- 絞り込むボタン -->
					<input type="submit" value="絞り込む" />
				</form>
			</div>



			<!-- 投稿を最大10件表示 -->
			<c:forEach items="${contributions}" var="contribution">

				<!-- 投稿 -->
				<div class="contributions">
					<p>${contribution.getCbUserAccount()}</p>
					<p>${contribution.getCbTitle()}</p>
					<p>${contribution.getCbCategory()}</p>
					<p>${contribution.getCbText()}</p>
					<p>${contribution.getCbCreatedDate()}</p>

						<!-- <a href="#"> -->
			            	<!-- <button type="button">コメント</button> -->
			      		<!-- </a> -->
			      		<!-- 自分の投稿なら削除ボタンをつける -->
			      		<c:if test="${contribution.getCbUserAccount() == loginUser.getAccount()}">
			      		<form action="/bbs/deleteCb" method="post">
			      			<input type="hidden" name="cbId" value="${contribution.getCbId()}">
			      			<input type="submit" value="削除" onclick="return delcb();">
			      		</form>
		      			</c:if>
				</div>
				<!-- コメント -->
				 <div class="comments">
					<!-- 新規コメント -->
					<div class="new-comment">
						<p>${loginUser.getAccount()}</p>
						<textarea name="comment" ></textarea>
						<input type="submit" value="投稿">
					</div>
					<!-- 既存コメント -->
					<div class="old-comments">
							<!-- コメントあるだけ表示 -->
							<p>${contribution.getComments().get(0)}</p>
							<c:if test="${not empty contribution.getComments()}">

							<c:forEach items="${contribution.getComments()}" var="comment">
								<div class="comment">
									<p>${comment.getUserAccount()}</p>
									<p>${comment.getText()}</p>
									<p>${comment.getCreatedDate()}</p>
								</div>
								<!-- 自分の投稿なら削除ボタンをつける -->
					      		<c:if test="${comment.getUserAccount() == loginUser.getAccount()}">
					      			<form action="/bbs/deleteCｍ" method="post">
			      						<input type="hidden" name="cmId" value="${contribution.getComment().getId()}">
						      			<input type="submit" value="削除" onclick="return delcm();">
						      		</form>
				      			</c:if>
							 </c:forEach>
							 </c:if>
					</div>
				 </div>

			</c:forEach>

			<div class="page-change">

					<a href="#">＜前へ</a>


				<a href="#">次へ＞</a>
			</div>

		</div>
	</div>
</body>
</html>