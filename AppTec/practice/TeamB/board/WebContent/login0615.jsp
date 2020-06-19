<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

  			<c:if test="${ not empty errorMessages }">
                <div class="errorMessages">
                    <ul>
                        <c:forEach items="${errorMessages}" var="errorMessage">
                            <c:out value="${errorMessage}" />
                        </c:forEach>
                    </ul>
       			</div>
			</c:if>


<form action="/board/Login" method="post"><br />

	<label for="account">アカウント:</label>
    <input name="account" id="account" /><br />
	<label for="pw">パスワード:</label>
    <input type="password" name="pw" id="pw" /><br />

	<p><input type="submit" value="ログイン"/></p>

</form>

</body>
</html>
-->