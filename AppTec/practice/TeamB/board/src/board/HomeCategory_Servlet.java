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

@WebServlet("/HomeCategory_Servlet")
public class HomeCategory_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Connection connection = DButil.getConnection();

		// ログインのセッションを取得する
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("loginUser");

		String category = request.getParameter("category");

		List<Home_bean> ret = new ArrayList<Home_bean>();
		List<String> searchResults = new ArrayList<String>();

		try {

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			statement = connection.createStatement();

			//SQL文作成
			//select * from writes where write_category like '%カテゴリー%';
			ResultSet rs = null;
			StringBuilder sql = new StringBuilder();

			//		        sql.append("SELECT * from users left join writes on users.user_id = writes.write_user_id;\n");

			sql.append(
					"select * from writes right join users on users.user_id = writes.write_user_id where write_category like '%");
			sql.append(category);
			sql.append("%';");
			//sql.append("SELECT * FROM writes WHERE write_category LIKE '%");
			//sql.append(category);
			//sql.append("%';");

			// 作成したsql文をexecuteQuery()で実行
			// DBの検索結果が入る

			System.out.println(sql.toString());
			//executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている

			rs = statement.executeQuery(sql.toString());

			int flag = 0;

			while (rs.next()) {
				bean.Home_bean writes = new bean.Home_bean();

				writes.setName(rs.getString("user_name"));
				writes.setCategory(rs.getString("write_category"));
				writes.setSubject(rs.getString("write_subject"));
				writes.setText(rs.getString("write_text"));
				ret.add(writes);
				if(ret.add(writes)) {
				flag++;
				}
			}


			// 使った資産の後片付け
			// dbを使い終わったら必ず終了
			rs.close();
			statement.close();



			if (flag > 0) {
				System.out.println("検索結果："+ flag);

				request.setAttribute("writesList", ret);

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
