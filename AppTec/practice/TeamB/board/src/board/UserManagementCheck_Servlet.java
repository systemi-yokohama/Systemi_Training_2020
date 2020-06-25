package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DButil;

@WebServlet("/UserManagementCheck_Servlet")
public class UserManagementCheck_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		Connection connection = DButil.getConnection();

		try {

			//connection.setAutoCommit(false);

			String user_account = request.getParameter("user_account");
			String user_status = request.getParameter("user_status");

			System.out.println("user_account:" + user_account);
			System.out.println("user_status:" + user_status);

			//DBにSQL文を送るための入れ物
			Statement statement = null;
			statement = connection.createStatement();

			//SQL文作成
			StringBuilder sql = new StringBuilder();

			sql.append("UPDATE users SET user_status=");
			sql.append(user_status);
			sql.append(" WHERE user_account='");
			sql.append(user_account);
			sql.append("';");

			System.out.println(sql.toString());
			//executeQuery()は引数に入れたものを実行してくれる関数。結果をrsに入れている

			statement.executeUpdate(sql.toString());

			statement.close();
			connection.commit();

			// response.sendRedirect("/UserManagement_Servlet");

			 getServletConfig().getServletContext().getRequestDispatcher("/UserManagement_Servlet").forward(request,response);

			//    connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//	private void flame() {
	//		// TODO 自動生成されたメソッド・スタブ
	//
	//	}
}
