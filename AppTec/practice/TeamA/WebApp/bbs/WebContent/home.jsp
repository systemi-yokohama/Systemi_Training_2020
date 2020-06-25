<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ホーム</title>
	<link href="css/style.css" rel="stylesheet">

	<script>
        	function delcb() { if(confirm("投稿を削除しますか？" )) return true; return false; }
        	function delcm() { if(confirm("コメントを削除しますか？" )) return true; return false; }
    </script>

</head>
<body>
	<header>
		<h2>掲示板システム</h2>
		<div class="menu">
			 <ul>
			 		<li>${loginUser.getAccount()}：</li>
			 	<c:if test="${loginUser.getDepartmentId() == 1}">
		         	<li><a href="/bbs/userManagement">ユーザー管理</a></li>
			 	</c:if>
		         	<li><a href="/bbs/logout">ログアウト</a></li>
	      	 </ul>
      	 </div>
	</header>

	<div class="top">
		<h3>投稿一覧</h3>
		<!-- 新規投稿ボタン -->
		<div class="new">
			<form action="/bbs/newContribution.jsp">
				<input type="submit" value="新規投稿">
			</form>
	      	<br>
	    </div>
	</div>

    	<!-- 絞り込み -->
    	<div  class="narrow">
			<form action="/bbs/narrow" method="post">
			<table>
	      		<tr class="factor"><td>〇投稿日</td><td>〇カテゴリー</td><td></td></tr>
				<tr>
				<td><select class="find-date" name="date">
						<option value="" selected>期間を選択してください</option>
						<option value="1d">1日以内</option>
						<option value="3d">3日以内</option>
						<option value="1w">1週間以内</option>
						<option value="1m">1ヶ月以内</option>
						<option value="3m">3ヶ月以内</option>
						<option value="1y">1年以内</option>
						</select>
				</td>
				<td>
					<input class="find-category" type="text" name="category" />
				</td>
				<td class="button"><!-- 絞り込むボタン -->
					<input class="narrow-button" type="submit" value="絞り込む" />
				</td>
				</tr>
				<tr><td></td>
				<td><!-- エラーメッセージの表示 -->
					<c:if test="${ not empty categoryError }">
						<div class="errorMessages">
						    <p>${categoryError}</p>
					    	<c:remove var="categoryError" scope="session" />
				    	</div>
				    </c:if>
				</td>
				<td></td>
				</tr>
				</table>
			<br>
			</form>
		</div>

		<c:if test="${not empty error}">
			<div class="errorMessages">
				<h4>${error}</h4>
				<c:remove var="error" scope="session" />
			</div>
		</c:if>
		<br>
		<br>

		<c:if test="${not empty contributions}">
		<!-- 投稿を最大10件表示 -->
		<div class="contributions">
			<c:forEach items="${contributions}" var="contribution">
			<div class="contribution">
				<h4>＜${contribution.getCbUserAccount()}＞</h4>
				<table border=1>
				<!-- 投稿 -->
					<tr>
					<td colspan="2" class="title">件名：${contribution.getCbTitle()}</td>
					<td colspan="2" class="category">カテゴリー：${contribution.getCbCategory()}</td>
					</tr>
					<tr>
					<td colspan="4" class="text">${contribution.getCbText()}</td>
					</tr>
					<tr>
					<!-- 他人の投稿ボタンなし -->
					<c:if test="${contribution.getCbUserAccount() != loginUser.getAccount()}">
						<td colspan="4">${contribution.getCbCreatedDate()}</td>
					</c:if>
					<!-- 自分の投稿なら削除ボタンをつける -->
					<c:if test="${contribution.getCbUserAccount() == loginUser.getAccount()}">
					<td colspan="3">${contribution.getCbCreatedDate()}</td>
						<td>
							<form action="/bbs/deleteCb" method="post">
								<input type="hidden" name="cbId" value="${contribution.getCbId()}">
								<input class="delete" type="submit" value="削除" onclick="return delcb();">
							</form>
						</td>
					</c:if>
					</tr>
				</table>
			</div>
			<br>

			<!-- コメント -->
			<div class="comments">
				<!-- 新規コメント -->
				<c:if test="${contribution.getCbUserAccount() != loginUser.getAccount()}">
				<form action="/bbs/newComment" method="post">
					<div class="new-comment">
						<p>＜${loginUser.getAccount()}＞</p>
						<input type="hidden" name="cbId" value="${contribution.getCbId()}">
						<textarea name="text" placeholder="入力してください"></textarea>
						<br>
						<c:if test="${ not empty errorMessages }">
							<div class="errorMessages">
								<ul>
									<c:forEach items="${errorMessages}" var="message">
										<li><c:out value="${message}" />
									</c:forEach>
								</ul>
							</div>
							<c:remove var="errorMessages" scope="session" />
		          		</c:if>
						<input class="submit color" type="submit" value="投稿">
					</div>
				</form>
				</c:if>
				<br>
				<br>
				<!-- 既存コメント -->
				<div class="old-comments">
					<!-- コメントあるだけ表示 -->
						<c:forEach items="${contribution.getComments()}" var="comment">
						<div class="comment">
							<h4>＜${comment.getUserAccount()}＞</h4>
							<table border=1>
							<tr><td colspan="3" class="text">${comment.getText()}</td></tr>
							<tr>
								<c:if test="${comment.getUserAccount() != loginUser.getAccount()}">
									<td colspan="3">${comment.getCreatedDate()}</td>
								</c:if>
								<!-- 自分の投稿なら削除ボタンをつける -->
					      		<c:if test="${comment.getUserAccount() == loginUser.getAccount()}">
					      			<td colspan="2">${comment.getCreatedDate()}</td>
					      			<td>
					      				<form action="/bbs/deleteCom" method="post">
			      							<input type="hidden" name="cmId" value="${comment.getId()}">
						      				<input class="delete" type="submit" value="削除" onclick="return delcm();">
						      			</form>
						      		</td>
				      			</c:if>
							</tr>
							</table>

		      			</div>
		      			<br>
					</c:forEach>
				</div>

			</div>


			<br>
			<br>
			</c:forEach>
		</div>
		</c:if>
	</body>
</html>