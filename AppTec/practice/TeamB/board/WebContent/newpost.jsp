<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規投稿</title>
</head>
<body>

	<form action="Home_Servlet" method="post">
		<input type="submit" value="戻る" formnovalidate
			style="position: absolute; right: 0px; top: 0px" >
	</form>

	<form action="NewPost" method="post">
		<br /> <label for="write_subject">件名</label> <input
			name="write_subject" id="write_subject" required /><br /> <label for="">カテゴリー</label>
		<input name="write_category" id="write_category" required /><br /> <label
			for="write_text">本文</label>
		<textarea name="write_text" id="write_text" cols="100" rows="5" required></textarea>
		<br /> <br />

		<p>
			<input type="submit" value="投稿"  />
		</p>

	</form>
	<p>${errorMessage}</p>


</body>
</html>