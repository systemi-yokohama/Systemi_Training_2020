package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DButil;

@WebServlet(urlPatterns = { "/Delete_Write_Servlet" })
public class Delete_Write_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Connection connection = DButil.getConnection();

		//UniversalDao.delete();

//		Home_bean home_bean = new Home_bean();
		String write_id = request.getParameter("write_id");
		int i = Integer.parseInt(write_id);
		//write_id = home_bean.getWrite_id();


		//String write_id = request.getParameter(name);

		//write_id = write.getWrite_id();

		PreparedStatement ps = null;

		try {
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

		} catch (SQLException e) {
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
