<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
aaaaa
<c:forEach var="comment_List" items="${commentsList}">
				<<%-- c:if
					test="${comment_List.getComment_write_id() ==  write_List.getWrite_id()}"> --%>
					<tr>
						<th>コメント</th>
						<td colspan="3" style="word-wrap: break-word;">${ comment_List.getCommentText() }</td>
					</tr>
	<%-- 			</c:if> --%>
			</c:forEach>
</body>
</html>