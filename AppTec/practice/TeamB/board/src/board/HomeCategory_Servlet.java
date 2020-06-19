package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Home_been;
import bean.Users;

@WebServlet("/HomeCategory_Servlet")
public class HomeCategory_Servlet extends HttpServlet {


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


	        // ログインのセッションを取得する
	        HttpSession session = request.getSession();
	        Users users = (Users) session.getAttribute("loginUser");

	        String category=request.getParameter("category");


	        List<Home_been> ret = new ArrayList<Home_been>();

		    try {

		    	//ドライバの初期化。後続のgetConnectionでDB接続できるようにする。これがないと繋がらないかもしれない。
				Class.forName(driver);
				 //javaとDBのコネクションの取得(引数の中は上記三つのもの。必須)
		        connection = DriverManager.getConnection(url,USER, password);

		        //DBにSQL文を送るための入れ物
		        Statement statement=null;
		        statement = connection.createStatement();

		        //SQL文作成
		        //select * from writes where write_category like '%カテゴリー%';
		        ResultSet rs=null;
		        StringBuilder sql=new StringBuilder();

//		        sql.append("SELECT * from users left join writes on users.user_id = writes.write_user_id;\n");

		        sql.append("select * from writes right join users on users.user_id = writes.write_user_id where write_category like '%");
		        sql.append(category);
		        sql.append("%';");
		        //sql.append("SELECT * FROM writes WHERE write_category LIKE '%");
		        //sql.append(category);
		        //sql.append("%';");

               // 作成したsql文をexecuteQuery()で実行
               // DBの検索結果が入る

		        System.out.println(sql.toString());
		        //executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている


		        rs=statement.executeQuery(sql.toString());

		        int flag=0;

		        while (rs.next()) {
					bean.Home_been writes = new bean.Home_been();

					writes.setName(rs.getString("user_name"));
					writes.setCategory(rs.getString("write_category"));
					writes.setSubject(rs.getString("write_subject"));
					writes.setText(rs.getString("write_text"));
					flag++;
				    ret.add(writes);
				}

	        // 使った資産の後片付け
	        // dbを使い終わったら必ず終了
		        rs.close();
				statement.close();


				 List<String> categoryMessage = new ArrayList<String>();

				if(flag>=2) {


				request.setAttribute("writesList",ret);

				 getServletConfig().getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);

				}else {
			         categoryMessage.add("検索のカテゴリーは見つかりませんでした");

			         request.setAttribute("categoryMessage", categoryMessage);

			         request.getRequestDispatcher("/home.jsp").forward(request,response);
				}

		    }catch(SQLException | ClassNotFoundException e) {


		    	e.printStackTrace();
		    }

	 }




}
