<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="./stylesheet.css">  -->
<title>ユーザー管理画面</title>

<style type="text/css">
header p{
	text-align:right;
}

.main-content{
	text-align:center;
	}

.main-content table{
    width:80%;
    margin:0 auto;
    }

 th{
    background-color:#ffdbb7;
 }

#account {
    width:10%;
    }
#botan{
    margin:0 auto;
    color:blue;
    width:100%;
    height:100%;
    border:solid 1px blue;

    }
#name {
    width:20%;
     }
#office{
     width:10%;
      }
#department{
     width:10%;
      }
#status{
     width:20%;
      }

footer p{
	text-align:right;
}
</style>
<script type="text/javascript">
function dd() { if(confirm("稼働状況の切り替えを行いますか？" )) return true; return false; }
</script>
</head>
<body>
<header>

<form action="/board/Home_Servlet" method="post">
      <input type="submit" value="ホーム" formnovalidate style="position: absolute; right: 0px; top: 0px">
    </form>


      <h3>ユーザー管理画面</h3>


</header>
<div class="main-content"><!-- ここでアカウントの状況一覧を表示する。c:forEachで繰り返し表示すること。 -->
    <table border="1">
        <tr><th>アカウント</th>
            <th>氏名</th>
            <th>支社</th>
            <th>部署</th>
            <th>停止状況</th>
        </tr>

        <!-- <a href="csv.php" onclick="document.download.submit();return false;">ダウンロード</a> -->

        <!-- ここでforEach -->
        <c:forEach var="users" items="${userslist}">
            <tr>
                    <td id="account"><form action ="/board/EditAccount_Servlet" method ="post">
                  <!--   <input type="hidden" name="user_account" value="${users.user_account}"> -->
                    <input type="submit"name= "user_account" value="${users.user_account}" id="botan"/></form></td>
                        <!--aタグ内 " onclick="document.form1.submit();return false;" -->
                    <!-- ユーザー名 -->
                    <td id="name">${users.user_name} </td>
                    <!-- 支社・本社 -->
                    <td id="office">${users.office_name} </td>
                    <!-- 部署 -->
                    <td id="department">${users.department_name}</td>
                    <!-- 稼働状況 -->
                    <td id="status">
                        <form action="/board/UserManagementCheck_Servlet" method="post">
                            <c:if test="${users.user_status==0}">
                                <input type="radio" name="user_status" value="0"checked/>稼働中
                                <input type="radio" name="user_status" value="1" />停止中
                            </c:if>
                                <input type="hidden" name="user_account" value="${users.user_account}">
                            <c:if test="${users.user_status==1}">
                                <input type="radio" name="user_status" value="0"/>稼働中
                                <input type="radio" name="user_status" value="1" checked/>停止中
                            </c:if>
                                <input type="submit" value="更新"  onclick="return dd();">
                         </form>
                </td>

         </tr>
        </c:forEach>
     <!-- ここまで繰り返す情報 -->
     </table>
</div>

<footer>
            <p><input type="submit" onclick="location.href='./newaccount.jsp'" value="新規登録画面へ"></p>


</footer>
</body>
</html>