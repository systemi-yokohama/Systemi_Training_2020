<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>

<style>
  label {
      margin-right:40px;
      width:130px;
      float:left;

  }

  ul li{
    list-style:none;
  }


  ul{
    width :500px;
    margin:0 auto;
    }

   .new_registration_buttun{
     text-align:center;

   }

  h5{
    text-align:center;
  }


</style>
</head>
<header>
  <h2>新規登録画面</h2>

<form action="UserManagement_Servlet" name="new_return"  method="post">
      <input type="submit"  onclick="location.href ='./usermanagement.jsp'" value="戻る" formnovalidate style="position: absolute; right: 0px; top: 0px">
    </form>



</header>
<body>
	<form action="NewAccount_Servlet" method="post" ><br />
      <ul>
		    <li >
		      <label for="user_account" >アカウント名</label>
		      <input name="user_account" type="text" id="user_account"  required/>
		    </li>

            <br>

            <li>
			  <label for="user_password">パスワード</label>
		      <input name="user_password" type="password" id="user_password"  required/>
            </li>

            <br>

            <li>
			  <label for="check_user_password">パスワード確認</label>
		      <input name="check_user_password" type="password" id="check_user_password"  required />
		    </li>

		    <br>

		    <li>
			  <label for="user_name">名称</label>
		      <input name="user_name" type="text" id="user_name"  required/>
		    </li>

		    <br>

            <li>
			  <label for="user_office">支社</label>

			  <select name="user_office" size="1" id="user_department">
			      <option value="1" label="本社"/>
			      <option value="2" label="A支社"/>
			      <option value="3" label="B支社"/>
			      <option value="4" label="C支社"/>
			  </select>
			</li>
			<br/>

            <li>
			  <label for="user_department">部署</label>
		      <select name="user_department" size="1" id="user_department">
			      <option value="1" label="総務人事部"/>
			      <option value="2" label="情報管理部"/>
			      <option value="3" label="営業部"/>
			      <option value="4" label="技術部"/>
			  </select>
		    </li><br>

            <li class="new_registration_buttun">
			  <input type="submit"  value="登録"  >
            </li>
	    </ul>
	    <br>

	</form>

	   <p>${errorMessage}</p>











</body>
</html>