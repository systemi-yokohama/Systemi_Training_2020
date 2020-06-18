package teamc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamc.beans.Comments;
import teamc.beans.Top;
import teamc.beans.Users;
import teamc.dao.CommentDao;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String comment = request.getParameter("comment");
		String tweetId = request.getParameter("tweetId");
		Integer.parseInt(tweetId);

		HttpSession session = request.getSession();

		if(!LoginServlet.emptyCheck(comment)) {
			List<Top> list = TopServlet.selectAll();

			request.setAttribute("list", list);
			request.setAttribute("tweetIdCheck", tweetId);
			request.setAttribute("commentVal", "値を入力してください");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Top.jsp");
			dispatcher.forward(request, response);

		}else if(comment.length() > 500) {
			List<Top> list = TopServlet.selectAll();

			request.setAttribute("list", list);
			request.setAttribute("tweetIdCheck", tweetId);
			request.setAttribute("commentVal", "500字以下で入力してください");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Top.jsp");
			dispatcher.forward(request, response);

		}else {
			Comments commentins = new Comments();
			//sessionからログインユーザーを取得
			Users loginUser = (Users) session.getAttribute("loginUser");
			int userId = loginUser.getId();

			commentins.setText(comment);
			//ログインしているuserのidを取得→代入にする
			commentins.setUser_id(userId);
			commentins.setTweets_id(Integer.parseInt(tweetId));

			try {
				CommentDao.insert(commentins);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("TopServlet");
			dispatcher.forward(request, response);
		}

	}

}
