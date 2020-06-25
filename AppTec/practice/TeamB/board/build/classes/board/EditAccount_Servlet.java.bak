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

import bean.Users;
import utils.DButil;

@WebServlet("/EditAccount_Servlet")
public class EditAccount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Connection connection = DButil.getConnection();

		try {

			String user_account = request.getParameter("user_account");
			System.out.println("user_account:" + user_account);

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			statement = connection.createStatement();
			//SELECT user_account,user_name,user_office,user_department,user_status FROM board.users;

			//SQL文作成
			StringBuilder sql = new StringBuilder();

			//内部結合
			sql.append(
					"SELECT * FROM users INNER JOIN offices ON users.user_office = offices.office_id INNER JOIN departments on users.user_department = departments.department_id");
			//絞り込み
			sql.append(" WHERE user_account='");
			sql.append(user_account);
			sql.append("';");

			System.out.println(sql.toString());
			//executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている
			ResultSet rs = null;

			rs = statement.executeQuery(sql.toString());

			List<Users> ret = new ArrayList<Users>();

			while (rs.next()) {
				Users users = new Users();
				//ユーザーアカウント
				users.setUser_account(rs.getString("user_account"));
				//PW
				users.setUser_status(rs.getString("user_password"));
				//個人名
				users.setUser_name(rs.getString("user_name"));
				//支社・本社
				users.setOffice_name(rs.getString("office_name"));
				// users.setUser_department(rs.getString("user_department"));
				//部署
				users.setDepartment_name(rs.getString("department_name"));

				ret.add(users);
			}

			request.setAttribute("userslist", ret);

			getServletConfig().getServletContext().getRequestDispatcher("/editaccount.jsp").forward(request, response);

			rs.close();
			statement.close();
			//connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
