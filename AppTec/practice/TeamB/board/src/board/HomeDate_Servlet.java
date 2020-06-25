package board;

import java.io.IOException;
import java.sql.Connection;
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

import bean.Home_bean;
import bean.Users;
import utils.DButil;

@WebServlet("/HomeDate_Servlet")
public class HomeDate_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Connection connection = DButil.getConnection();

		// ログインのセッションを取得する
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("loginUser");

		int user_id = users.getUser_id();
		String date = request.getParameter("date");
		int datedate = Integer.parseInt(date);
		System.out.println("指定期間"+datedate);


		List<Home_bean> ret = new ArrayList<Home_bean>();
		 List<Home_bean> ret2 = new ArrayList<Home_bean>();
		List<String> searchResults = new ArrayList<String>();

		try {

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			Statement statementcom = null;
			statement = connection.createStatement();
			statementcom = connection.createStatement();

			//SQL文作成
			//SELECT * FROM writes WHERE write_created_date BETWEEN '2020/06/17' AND '2020/06/19';
			ResultSet rs = null;
			StringBuilder sql = new StringBuilder();
			StringBuilder sbcom = new StringBuilder();

			//select *from board.writes where write_created_date <= now() and write_created_date >= date_sub(now(), interval 7 day) ;

			//	"SELECT * from writes left join users on writes.write_user_id = users.user_id"
			sql.append("SELECT * from writes left join users on writes.write_user_id = users.user_id");
			sql.append("  where");
			sql.append(" write_created_date <= now() and write_created_date >= date_sub(now(), interval ");
			sql.append(datedate);
			sql.append(" day);");

		 	sbcom.append("SELECT * from comments left join users on comments.comment_user = users.user_id ;");


				// 作成したsql文をexecuteQuery()で実行
				// DBの検索結果が入る

				System.out.println(sql.toString());
				System.out.println(sbcom.toString());
				//executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている

				rs = statement.executeQuery(sql.toString());
				ResultSet rscom = statementcom.executeQuery(sbcom.toString());

				int flag = 0;

				while (rs.next()) {

					bean.Home_bean writes = new bean.Home_bean();
					bean.Users users2 = new bean.Users();

					writes.setName(rs.getString("user_name"));
					writes.setCategory(rs.getString("write_category"));
					writes.setSubject(rs.getString("write_subject"));
					writes.setText(rs.getString("write_text"));

					writes.setWrite_user_id(rs.getInt("write_user_id"));


					writes.setWrite_created_date(rs.getDate("write_created_date"));
					writes.setWrite_id(rs.getInt("write_id"));

					users2.setUser_id(rs.getInt("user_id"));

					System.out.println("writeの繰り返し");
					System.out.println(rs.getInt("write_id"));

					ret.add(writes);


					flag++;
					}


				while(rscom.next()) {
					bean.Home_bean comments = new bean.Home_bean();
					bean.Users users2 = new bean.Users();

					comments.setComment_text(rscom.getString("comment_text"));
					comments.setComment_write_id(rscom.getInt("comment_write_id"));
					comments.setComment_id(rscom.getInt("comment_id"));
					comments.setComment_user(rscom.getInt("comment_user"));


					System.out.println("commentの繰り返し");
					System.out.println(rscom.getInt("comment_id"));


					users2.setUser_id(rscom.getInt("user_id"));


					ret2.add(comments);
				}


				// 使った資産の後片付け
				// dbを使い終わったら必ず終了
				rs.close();
				rscom.close();
				statement.close();
				statementcom.close();



				if (flag > 0) {
					System.out.println("検索結果："+ flag);

					for(Home_bean h:ret) {
						System.out.println(h.getText());
					}
					request.setAttribute("writesList", ret);
					request.setAttribute("commentsList", ret2);
					request.setAttribute("user_id",user_id);


					getServletConfig().getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

				} else {
					searchResults.add("検索結果：０件");
					System.out.println("検索結果："+flag);
					request.setAttribute("searchResults", searchResults);
					request.getRequestDispatcher("/home.jsp").forward(request, response);
				}


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
