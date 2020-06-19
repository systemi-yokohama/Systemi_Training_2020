//package board;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//
//@WebServlet("/Login")
//public class Login_Servlet0615 extends HttpServlet{
//	private static final long serialVersionUID = 1L;
//
//	 @Override
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//	    		throws ServletException, IOException {
//
//		 String driver = "com.mysql.jdbc.Driver";
//	        // 「database_name」は各環境に合わせます
//	        String url = "jdbc:mysql://192.168.2.22:3306/board";
//	        // MySQLに接続する際のユーザー名(デフォルトはroot)
//	        String user = "testuser";
//	        // MySQLに接続する際のパスワード(今回はroot)
//	        String password = "test";
//
//	       // String account = request.getParameter("account");
//	       // String pw = request.getParameter("pw");
//
//	        Connection connection=null;
//
//	        List<String> errorMessages = new ArrayList<String>();
//
//	        try {
//	        //getConnectionでDB接続
//	        Class.forName(driver);
//
//	        //コネクション接続　どこのDBに名前とパスで接続
//	        connection = DriverManager.getConnection(url,
//	                user, password);
//
//	        Statement statement=null;
//	        statement = connection.createStatement();
//
//	        //String sql="SELECT * FROM users";
//	        //ResultSet rs = statement.executeQuery(sql);
//	        //全取得
//	 		//StringBuilderだからappendできる
//	        StringBuilder sb=new StringBuilder();
//	        sb.append("SELECT * FROM users");
//
//
//	 		//String account=request.getParameter("account").toString();
//	 		//String pw=request.getParameter("pw").toString();
//
//		    //HttpSession session = request.getSession(true);
//
//
//
//		    //boolean check = notNull(account, pw);
//		    //if (check==true){
//		      /* 認証済みにセット */
//		      //session.setAttribute("login", "OK");
//		    //setAttributeはjspに表示するためのもの
//
//		      //データベースと合致するか
////		      	sb.append(" WHERE user_account='");
////	        	sb.append(account);
////	        	sb.append("' AND user_password='");
////	        	sb.append(pw);
////	        	sb.append("'");
//
//
//
//		    	String sql=sb.toString();
//		    	System.out.println(sql/*.toString()*/);
//		    	ResultSet rs = statement.executeQuery(sql);
//
//
//		    	//検索結果を入れる入れ物を用意
//		     	//List<Login_Been> ret=new ArrayList<Login_Been>();
//
//
//		      //取得したコードの数だけ繰り返し処理
//		     // while (rs.next()) {
//		       // 	Login_Been login_been=new Login_Been();
//
//		        //    login_been.setAccount(rs.getString("account"));
//		        //    login_been.setPw(rs.getString("pw"));
//
//		        //    ret.add(login_been);
//
//		        //    }
//	            //if(ret!=null) {
//			        //request.setAttribute("account", account);
//
//			      /* 本来のアクセス先へ飛ばす */
//			      //String target = (String)session.getAttribute("target");
//			      //response.sendRedirect("/board/home.jsp");
//	          /* }else{
//
//		            errorMessages.add("ログインに失敗しました");
//		            request.setAttribute("errorMessages", errorMessages);
//		            request.getRequestDispatcher("login.jsp").forward(request, response);*/
//
//
//			     // session.setAttribute("status", "Not Auth");
//			      //response.sendRedirect("/board/login.jsp");
//
//			     //return;
//			   //  }
//
//
//
//
//			     rs.close();
//			     statement.close();
//		  //  }
//
//
//		    //if(check==false){
//		      /* 認証に失敗したら、ログイン画面に戻す */
//
//	        //    errorMessages.add("ログインに失敗しました");
//	        //    request.setAttribute("errorMessages", errorMessages);
//	        //    request.getRequestDispatcher("login.jsp").forward(request, response);
//
//
//		      //session.setAttribute("status", "Not Auth");
//		     // response.sendRedirect("/board/login.jsp");
//
//		     //return;
//		    //}
//
//
//		     //   request.setAttribute("LoginList", ret);
//		        getServletConfig().
//		        getServletContext().
//		        getRequestDispatcher("/home.jsp").
//		        forward(request,response);
//
//
//
//		    }catch(Exception e) {
//	        	e.printStackTrace();
//	        }
//
//	 }
//
//		    public static boolean notNull(String account, String pw){
//		        /* 取りあえずユーザー名とパスワードが入力されていれば認証する */
//		        if (account == null || account.length() == 0 || pw == null || pw.length() == 0){
//		          return false;
//
//		        }else {
//
//		        return true;
//		      }
//
//
//
//		  }
//}
//
//
