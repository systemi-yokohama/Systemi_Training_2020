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

@WebServlet("/Home_Servlet")
public class Home_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// どのドライバを使うか指定（今回はmysql）
		Connection connection = DButil.getConnection();

		//        String user_name = null;
		//    	String write_category = null;
		//    	String write_subject = null;
		//    	String write_text = null;

		ResultSet rs = null;
		Statement statement = null;
		Statement statementcom = null;



		StringBuilder sb = new StringBuilder();
		StringBuilder sbcom = new StringBuilder();

		// ログインのセッションを取得する
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("loginUser");

		int user_id = users.getUser_id();

		List<Home_bean> ret = new ArrayList<Home_bean>();
		List<Home_bean> ret2 = new ArrayList<Home_bean>();

		try {
			statement = connection.createStatement();
			statementcom = connection.createStatement();

			sb.append(
					"SELECT * from writes left join users on writes.write_user_id = users.user_id");
			sbcom.append(
					"SELECT * from comments left join users on comments.comment_user = users.user_id");

			System.out.println(sb.toString());
			System.out.println(sbcom.toString());

			// 作成したsql文をexecuteQuery()で実行
			// DBの検索結果が入る
			rs = statement.executeQuery(sb.toString());
			ResultSet rscom = statementcom.executeQuery(sbcom.toString());

			// 変数rsに取得したデータが入る
			// .nextは一行目で取得できたら次の行を取得しに行く
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


				ret.add(writes);

			}
			while(rscom.next()) {
				bean.Home_bean comments = new bean.Home_bean();
				bean.Users users2 = new bean.Users();

				comments.setComment_text(rscom.getString("comment_text"));
				comments.setComment_write_id(rscom.getInt("comment_write_id"));
				comments.setComment_id(rscom.getInt("comment_id"));
				comments.setComment_user(rscom.getInt("comment_user"));
				System.out.println(rscom.getInt("comment_user"));
				users2.setUser_id(rscom.getInt("user_id"));


				ret2.add(comments);
			}

			// 使った資産の後片付け
			// dbを使い終わったら必ず終了
			rs.close();
			rscom.close();
			statement.close();
			statementcom.close();

			request.setAttribute("writesList", ret);
			request.setAttribute("commentsList", ret2);
			request.setAttribute("user_id",user_id);

			getServletConfig().getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	//    public static boolean nullEmpty(String param) {
	//    	return(param == null || param.length() == 0);
	//    }
}
