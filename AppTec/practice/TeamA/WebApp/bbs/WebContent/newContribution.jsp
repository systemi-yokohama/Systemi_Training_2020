<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<!DOCTYPE html>
<html>
	<head>
    	<title>新規投稿</title>
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>
        <header>
            <h2>掲示板システム</h2>
            <div class="menu">
			 <ul>
			 		<li>${loginUser.getAccount()}：</li>
		         	<li><a href="/bbs/logout">ログアウト</a></li>
	      	 </ul>
      	 	 </div>
        </header>
        <div class="top">
        	<h3>新規投稿</h3>
        	<form action="/bbs/contributionIndex">
        		<input class="cansel" type="submit" value="キャンセル">
            </form>
        </div>
			<div class="new-contribution">
			<form action="/bbs/newContribution" method="post">
				<div class="contents">
	                <p class="contribution-account">＜${loginUser.getAccount()}＞</p><br>
	                <table>
	                <tr>
	                <td class="title2">
	                	<label for="title">件名:</label>
	                </td>
	                <td><input class="titleInput" type="text" name="title"></td>
	                <tr>
	                <td class="category2" >
	                	<label for="category">カテゴリー:</label>
	                </td>
	                <td><input class="categoryInput" type="text" name="category"></td>
	                </tr>
	                <tr>
	                <td colspan="2">
	                <label for="text"></label>
	                <textarea name="text" cols="70" rows="10" placeholder="いまなにしてる？"></textarea><br>
					</td>
					</tr>
					</table>
				</div>
				<c:if test="${ not empty errorMessages }">
	                <div class="errorMessages">
	                    <ul>
	                        <c:forEach items="${errorMessages}" var="message">
	                            <li><c:out value="${message}" />
	                        </c:forEach>
	                    </ul>
	                </div>
	                <c:remove var="messages" scope="session"/>
	            </c:if>
	            <input class="submit" type="submit" value="投稿"><br>
			</form>
        </div>
    </body>
    <br>
    <br>
    <br>
    <br>
</html>