package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Home_been;
import bean.Users;

@WebServlet("/HomeDate_Servlet")
public class HomeDate_Servlet  extends HttpServlet{

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
	        String user_name = null;
	        String write_category = null;
	    	String write_subject = null;
	    	String write_text = null;

	        List<Home_been> ret = new ArrayList<Home_been>();

		    try {
		    	       String strdateA= request.getParameter("dateA");
			            String strdateB= request.getParameter("dateB");

			         SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd");
		    	  //      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			                System.out.println("元:"+strdateA);
				          System.out.println("元:"+strdateB);

			           Date dateA = sdf.parse(strdateA);

			            Date dateB = sdf.parse(strdateB);
			            String dateC;
			            // Date dateC= new Date();
//			         System.out.println("後:"+dateA);
//			            System.out.println("後:"+dateB);


		    	//ドライバの初期化。後続のgetConnectionでDB接続できるようにする。これがないと繋がらないかもしれない。
				Class.forName(driver);
				 //javaとDBのコネクションの取得(引数の中は上記三つのもの。必須)
		        connection = DriverManager.getConnection(url,USER, password);

		        //DBにSQL文を送るための入れ物
		        Statement statement=null;
		        statement = connection.createStatement();

		        //date比較
		        int BW=(dateA.compareTo(dateB));


		        //SQL文作成
		      //SELECT * FROM writes WHERE write_created_date BETWEEN '2020/06/17' AND '2020/06/19';
		        ResultSet rs=null;
		        StringBuilder sql=new StringBuilder();
		        sql.append("SELECT * FROM writes right join users on users.user_id = writes.write_user_id WHERE write_created_date ");
//		        sql.append("BETWEEN '");
//		        sql.append(strdateA);
//		        sql.append("' AND '");
//		        sql.append(strdateB);
//		        sql.append("');");



		        if(0==BW){  //同日検索の場合
		        	sql.append("=");
		        	sql.append( strdateA);
		        	sql.append(";");
		        }

		        if(1==BW) {//dateAが未来の場合
		           dateC=strdateA;
		           strdateA=strdateB;
		           strdateB=dateC;
		           BW=-1;
		        }
		        if(-1==BW) {
		        	sql.append("BETWEEN '");
		        	sql.append(strdateA);
		        	sql.append("' AND '");
		        	sql.append(strdateB);
		        	sql.append("';");
		        }


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
				 List<String> dateMessage = new ArrayList<String>();
				if(flag>=2) {
				request.setAttribute("writesList",ret);
				getServletConfig().getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
				}else {
			         dateMessage.add("検索の日付に投稿された件数は０件です。");
			         request.setAttribute("dateMessage", dateMessage);
			         request.getRequestDispatcher("/home.jsp").forward(request,response);
				}
		    }catch(SQLException  |ClassNotFoundException | ParseException e) {
     	    	e.printStackTrace();
		    }

	 }

}

