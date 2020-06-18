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

import teamc.beans.Comments;
import teamc.dao.CommentDao;
import teamc.dao.TweetDao;

@WebServlet("/TweetDeleteServlet")
public class TweetDeleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		System.out.println("TweetDeleteServlet実行");

		String tweet_id = request.getParameter("tweet_id");

		//deleteするtweetに含まれるcomment削除
		try {
			List<Comments> comments = CommentDao.select("select * from comments");

				for (Comments comment : comments) {
					if (comment.getTweets_id() == Integer.parseInt(tweet_id)) {
						System.out.println(comment.getId());
						CommentDao.delete(comment.getId());
						System.out.println("コメント削除");
					}
				}
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		//tweet削除
		try {
			TweetDao.delete(Integer.parseInt(tweet_id));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("TopServlet");
		dispatcher.forward(request, response);

	}

}
