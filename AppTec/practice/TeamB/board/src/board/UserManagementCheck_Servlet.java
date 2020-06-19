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

@WebServlet("/UserManagementCheck_Servlet")
public class UserManagementCheck_Servlet extends HttpServlet{
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


		        String user_account=request.getParameter("user_account");
			     String user_status=request.getParameter("user_status");

			     System.out.println("user_account:"+ user_account);
			     System.out.println("user_status:" + user_status);


		        //DBにSQL文を送るための入れ物
		        Statement statement=null;
		        statement = connection.createStatement();

               		        //SQL文作成
		        StringBuilder sql=new StringBuilder();


		        	  sql.append("UPDATE users SET user_status=");
		        	  sql.append(user_status);
		        	  sql.append(" WHERE user_account='");
		        	  sql.append(user_account);
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

//	private void flame() {
//		// TODO 自動生成されたメソッド・スタブ
//
//	}
}
