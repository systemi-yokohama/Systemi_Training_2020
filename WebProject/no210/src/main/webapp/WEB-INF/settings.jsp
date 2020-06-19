<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${loginUser.account}の設定</title>
        <link href="./style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="main-contents">

            <c:if test="${ not empty errorMessages }">
                <div class="errorMessages">
                    <ul>
                        <c:forEach items="${errorMessages}" var="message">
                            <li><c:out value="${message}" />
                        </c:forEach>
                    </ul>
                </div>
                <c:remove var="errorMessages" scope="session"/>
            </c:if>

            <!-- ユーザーのidは隠しておく -->
            <!-- 最初のeditUserはSettingsServletのdoGetメソッドを介して表示されるログインユーザーの情報 -->
            <form action="settings" method="post"><br />
                <input name="id" value="${editUser.id}" id="id" type="hidden"/>
                <label for="name">名前</label>
                <input name="name" value="${editUser.name}" id="name"/>（名前はあなたの公開プロフィールに表示されます）<br />

                <label for="account">アカウント名</label>
                <input name="account" value="${editUser.account}" /><br />

                <label for="password">パスワード</label>
                <input name="password" type="password" id="password"/> <br />

                <label for="email">メールアドレス</label>
                <input name="email" value="${editUser.email}" id="email"/> <br />

                <label for="description">説明</label>
                <textarea name="description" cols="35" rows="5" id="description"><c:out value="${editUser.description}" /></textarea> <br />

                <input type="submit" value="登録" /> <br />
                <a href="./">戻る</a>
            </form>
            <div class="copyright"> Copyright(c)Your Name</div>
        </div>
    </body>
</html>