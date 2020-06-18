package teamc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import teamc.beans.Tweets;
import teamc.beans.Users;
import teamc.dao.CommentDao;
import teamc.dao.TweetDao;
import teamc.dao.UserDao;

@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		List<Top> allList = selectAll();

		List<Top> list = new ArrayList<>();
		//画面遷移チェックに使う値
		String before = null;
		String next = null;
		//今いるページを把握する値
		int topTweet = 0;
		if(LoginServlet.emptyCheck(request.getParameter("topTweet"))){
			topTweet = Integer.parseInt(request.getParameter("topTweet"));
		}

		HttpSession session = request.getSession();
		Users loginUser = (Users) session.getAttribute("loginUser");

		String post = request.getParameter("post");

		int i = 0;

		//初期状態
		if(!(LoginServlet.emptyCheck(post))) {
			//tweetが20件以下の場合
			if(allList.size() <= 20) {
				list.addAll(allList);
			//tweetが20件より多い場合
			}else {
				for(Top top:allList) {
					list.add(top);
					i++;
					if(i >= 20) {
						next = "ok";
						break;
					}
				}
			}

		//次へを押した時
		}else if(post.equals("20")) {
			before = "ok";
			topTweet += 20;
			//次の画面で表示するtweetが20件以下の場合
			if(allList.size() <= 20+topTweet) {
				for(Top top:allList) {
					if(topTweet <= i) {
						list.add(top);
					}
					i++;
					if(i >= allList.size()) {
						break;
					}
				}
			//次の画面で表示するtweetが20件より多い場合
			}else {
				for(Top top:allList) {
					if(topTweet <= i) {
						list.add(top);
					}
					i++;
					if(i >= 20+topTweet) {
						next = "ok";
						break;
					}
				}
			}

		//前へを押した時
		}else if(post.equals("-20")) {
			next = "ok";
			topTweet -= 20;
			//遷移先が先頭の場合
			if(topTweet <= 0) {
				for(Top top:allList) {
					list.add(top);
					i++;
					if(i >= 20) {
						break;
					}
				}
			}
			//遷移先が先頭でない場合
			else {
				for(Top top:allList) {
					if(topTweet <= i) {
						list.add(top);
					}
					i++;
					if(i >= 20+topTweet) {
						before = "ok";
						break;
					}
				}
			}
		}

		request.setAttribute("list", list);
		request.setAttribute("before", before);
		request.setAttribute("next", next);
		request.setAttribute("topTweet", topTweet);
		request.setAttribute("loginUser", loginUser);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Top.jsp");
		dispatcher.forward(request, response);

	}



	public static List<Top> selectAll() {

		List<Top> list = new ArrayList<>();
		List<Tweets> tweetList = null;
		List<Comments> commentList = null;
		List<Users> userList = null;

		try {
			tweetList = TweetDao.select("select * from tweets order by created_at desc;");
			commentList = CommentDao.select("select * from comments order by created_at desc;");
			userList = UserDao.select("select * from users;");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		for (Tweets tweet : tweetList) {
			Top top = new Top();
			List<Comments> comments = new ArrayList<>();

			top.setTweet_id(tweet.getId());
			top.setSubject(tweet.getSubject());
			top.setText(tweet.getText());
			top.setCategory(tweet.getCategory());
			top.setCreated_at(tweet.getCreated_at());
			top.setUpdated_at(tweet.getUpdated_at());


			for (Users user : userList) {
				if (tweet.getUser_id() == user.getId()) {
					top.setUser(user);
					break;
				}
			}
			for (Comments comment : commentList) {
				if (tweet.getId() == comment.getTweets_id()) {
					comments.add(comment);
				}
			}
			top.setComment(comments);
			list.add(top);
		}

		return list;
	}

}
