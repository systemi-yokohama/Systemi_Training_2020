<%@page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>入力のサンプル</title>
</head>
<body>
  <h3>入力のサンプル</h3>

  <form action="echo">
    <br /> 入力してください : <input type="text" name="m" /> <br /><input type="submit" /> <br />
  </form>

  <br />

  <c:if test="${ not empty message }">
    入力された文字は、「${ message }」です。
  </c:if>

</body>
</html>