<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<!DOCTYPE html>
<html>
	<head>
    	<title>新規投稿</title>
        <link rel="style" href="style.css">
            <style>
            h2{
            font-size:30px;
            text-align:center;
            background-size:cover;
            background-color:green;
            }
            h3{
            font-size:25px;
            }
            .btn1{
            float:right;
            }
            .btn2{
            float:right;
            }
            contents{
            margin-bottom:10px;
            }
            textarea{
            rows:50;
            }
            </style>
    </head>
   <body>
        <div class = header>
            <h2>掲示板システム</h2>
        </div>
        <h3>新規投稿</h3>

        <div class="main-contents">
                <form method="post" action="/bbs/newContribution">
                    <input type="submit" name="cansel" value="キャンセル" class="btn1"><br>
			<div class="contents">
                    <%-- <p>ID：<input type="text" name="id" ></p> --%>
                    <p>${loginUser.getAccount()}</p><br>
                    <label for="text">件名:</label>
                        <input type="text" name="title" size="20">
                    <label for="category">カテゴリー:</label>
                        <input type="text" name="category" size="20"><br>
                    <label for="text"></label>
                    <textarea name="text" cols="70" rows="10"></textarea><br>
			</div>
				<c:if test="${ not empty errorMessages }">
                <div class="errorMessages">
                    <ul>
                        <c:forEach items="${errorMessages}" var="errorMessage">
                            <li><c:out value="${errorMessage}" />
                        </c:forEach>
                    </ul>
                </div>
                <c:remove var="errorMessages" scope="session"/>
            </c:if>
                    <input type="submit" name="contribution" value="投稿" class="btn2"><br>
                </form>
        </div>
    </body>
</html>