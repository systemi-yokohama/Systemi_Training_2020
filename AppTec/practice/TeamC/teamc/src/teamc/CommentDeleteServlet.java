package teamc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teamc.dao.CommentDao;

@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String comment_id = request.getParameter("comment_id");

		try {
			CommentDao.delete(Integer.parseInt(comment_id));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("TopServlet");
		dispatcher.forward(request, response);

	}

}
