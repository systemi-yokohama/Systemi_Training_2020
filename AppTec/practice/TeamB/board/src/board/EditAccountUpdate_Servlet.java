package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditAccountUpdate_Servlet")
public class EditAccountUpdate_Servlet  extends HttpServlet{
	 private static final long serialVersionUID = 1L;

	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

		    request.setCharacterEncoding("UTF-8");
		   //DBアクセス情報を記述
		    String driver = "com.mysql.jdbc.Driver";//DBによってここは変わる。MySQLだからこれというだけ

	        // jdbcを使ってMySQLの中のローカルホストの中のDBを使う宣言
		    String url = "jdbc:mysql://192.168.2.5:3306/board";

	        // MySQLに接続する際のユーザー名(デフォルトはroot)
	        String USER = "testuser";

	        // MySQLに接続する際のパスワード(今回はroot)
	        String password = "test";

	    	Connection connection=null;

		    try {

		    	 //ドライバの初期化。後続のgetConnectionでDB接続できるようにする。これがないと繋がらないかもしれない。
				Class.forName(driver);
				 //javaとDBのコネクションの取得(引数の中は上記三つのもの。必須)
		        connection = DriverManager.getConnection(url,USER, password);

		        String old_user_account=request.getParameter("old_user_account");
		        String new_user_account=request.getParameter("new_user_account");
		        String user_password=request.getParameter("user_password");
		        String user_name=request.getParameter("user_name");
		        String user_office=request.getParameter("user_office");
		        String user_department=request.getParameter("user_department");


			     System.out.println("user_account:"+ new_user_account);
			     System.out.println("user_password:"+ user_password);
			     System.out.println("user_name:"+ user_name);
			     System.out.println("office_name:" + user_office);
			     System.out.println("department_name:"+ user_department);


		        //DBにSQL文を送るための入れ物
		        Statement statement=null;
		        statement = connection.createStatement();

              		        //SQL文作成
		        StringBuilder sql=new StringBuilder();

		        /*UPDATE users SET user_account='sakakibara',user_password='sakakibara',
		         * user_name='榊原義人', user_office=1 ,user_department=2 where user_account='koyamada';*/
		        sql.append("UPDATE users SET");
		        //アカウント名が変更される場合

			      if(!(new_user_account==null )&& !(new_user_account.trim().equals(""))) {
		        	  sql.append(" user_account = '");
			    	  sql.append(new_user_account);
			    	  sql.append("',");

			   	  }

			      if(!(user_password==null )&& !(user_password.trim().equals(""))) {
			    	  sql.append(" user_password = '");
			    	  sql.append(user_password);
			    	  sql.append("',");

			      }
			       if(!(user_name==null )&& !(user_name.trim().equals(""))) {
				    	  sql.append(" user_name = '");
				    	  sql.append(user_name);
				    	  sql.append("',");
			       }
				   if(!(user_office==null )&& !(user_office.trim().equals(""))) {
					       	sql.append(" user_office  =");
						    sql.append(user_office);
						    sql.append(",");
				   }
				    if(!(user_department==null )&& !(user_department.trim().equals(""))) {
					        	sql.append(" user_department = ");
							    sql.append(user_department);

				    }
				    sql.append(" WHERE user_account='");
				    sql.append(old_user_account);
				    sql.append("';");


		        System.out.println(sql.toString());
		        //executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている


		         statement.executeUpdate(sql.toString());

		        getServletConfig().
			    getServletContext().
			    getRequestDispatcher("/UserManagement_Servlet").forward(request,response);

		        statement.close();
		        connection.close();


		    }catch(SQLException | ClassNotFoundException e){
		    	e.printStackTrace();
		    }
		    }

}
