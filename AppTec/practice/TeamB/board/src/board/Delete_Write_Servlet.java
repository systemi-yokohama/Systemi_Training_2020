package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Home_bean;

@WebServlet(urlPatterns = { "/Delete_Write_Servlet" })
public class Delete_Write_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String driver = "com.mysql.jdbc.Driver";
		// 接続するDBのURLを変数に入れる
		String url = "jdbc:mysql://192.168.2.5/board";
		// MySQLに接続する際のユーザー名(デフォルトはroot)
		String user = "testuser";
		// MySQLに接続する際のパスワード(今回はroot)
		String password = "test";

		Connection connection = null;

		//UniversalDao.delete();

		Home_bean home_bean = new Home_bean();
		String write_id = request.getParameter("write_id");
		int i = Integer.parseInt(write_id);
		//write_id = home_bean.getWrite_id();


		//String write_id = request.getParameter(name);

		//write_id = write.getWrite_id();

		PreparedStatement ps = null;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM  writes WHERE ");
			sql.append("write_id = ");
			sql.append(i);
			ps = connection.prepareStatement(sql.toString());

			//ps.setInt(1, i);

			System.out.println(sql);
			System.out.println(i);

			ps.executeUpdate();

			connection.commit();

			connection.close();
			ps.close();

			getServletConfig().getServletContext().getRequestDispatcher("/Home_Servlet").forward(request, response);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new ServletException();
		}

	}

}
