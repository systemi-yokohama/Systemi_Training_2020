<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ユーザー編集</title>
		<link href="css/style.css" rel="stylesheet">
	</head>
<body>
	<header>
		<div class="header-container" align="center">
		    <h2>掲示板システム</h2>
		    <div class="menu">
				<ul>
			 		<li>${loginUser.getAccount()}：</li>
		         	<li><a href="/bbs/logout">ログアウト</a></li>
		      	 </ul>
		  	 </div>
		</div>
  	</header>
  	<div class="top">
		<h3>ユーザー設定の編集</h3>
	</div>
		<form action="/bbs/settings" method="post">
		<input type="hidden" name="oldAccount" value="${account}">
			<div class="main-input">
				<table>
					<tr>
						<td class="na"><label for="account">アカウント:</label></td>
					    <td><input type="text" name="account" id="account" value="${account}"/></td>

					</tr>
					<tr>
					    <td></td>
					    <td><p class="t">(6~20文字の半角英数字で入力してください)</p></td>
				    </tr>
					<tr>
					    <td class="na"><label for="name">名称:</label></td>
					    <td><input type="text" name="name" id="name" value="${name}"/></td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td><p class="t">(10文字以内で入力してください)</p></td>
				    </tr>
					<tr>
					    <td class="na"><label for="branchId">支社:</label></td>
					    <td><select name="branchId" id="branchId" >
					    		<option value="0" selected>選択してください</option>
					    		<option value="1">本社</option>
					    		<option value="2">A支社</option>
					    		<option value="3">B支社</option>
					    		<option value="4">C支社</option>
					    		</select>
					    </td>
				    </tr>
					<tr>
					    <td class="na"><label for="departmentId">部署:</label></td>
					    <td><select  name="departmentId" id="departmentId" >
					    		<option value="0" selected>選択してください</option>
					    		<option value="1">総務人事部</option>
					    		<option value="2">情報管理部</option>
					    		<option value="3">営業部</option>
					    		<option value="4">技術部</option>
					    		</select>
					    </td>
				    </tr>
				    <tr>
					    <td class="na"><label for="password">パスワード:</label></td>
					    <td><input type="password" name="password" id="password" /></td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td><p class="t">(6~20文字の記号を含む半角文字で入力してください)</p></td>
				    </tr>
					<tr>
					    <td class="na"><label for="password2">パスワード（再入力）:</label></td>
					    <td><input type="password" name="password2" id="password2" /></td>
				    </tr>
				</table>
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
	        <br>
	        <br>
		    <p class="float">
				<input class="to" type="submit" value="登録"><br><br>
				<a href="/bbs/userManagement">
					<button class="can" type="button">キャンセル</button>
				</a>
			</p>
		 </div>
		</form>
</body>

<br>
<br>
<br>
<br>

</html>