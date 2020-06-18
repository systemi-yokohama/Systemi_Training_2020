package teamc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamc.beans.Top;
import teamc.beans.Tweets;
import teamc.beans.Users;
import teamc.dao.TweetDao;

@WebServlet("/SerchServlet")
public class SerchServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String tweetsCreated_at = request.getParameter("tweetsCreated_at");
		String category = request.getParameter("category");

		List<Top> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		HttpSession session = request.getSession();
		Users loginUser = (Users) session.getAttribute("loginUser");


		if(LoginServlet.emptyCheck(tweetsCreated_at)) {
			//select * from tweets where created_at > '2020-06-15 14:53:25';
			Calendar now = Calendar.getInstance();
			sb.append("select * from tweets where created_at >= '");

			 if(tweetsCreated_at.equals("oneweek")) {
				now.add(Calendar.DAY_OF_MONTH , -7);
			}else if(tweetsCreated_at.equals("onemonth")) {
				now.add(Calendar.MONTH , -1);
			}else if(tweetsCreated_at.equals("oneyear")) {
				now.add(Calendar.YEAR , -1);
			}

			Date serchDate = now.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd' 'k':'mm':'ss");
			sb.append(sdf.format(serchDate));
			sb.append("';");
			String sql = sb.toString();

			list = selectTop(sql);

		}
		else if(LoginServlet.emptyCheck(category)) {
			sb.append("select * from tweets where category like '%");
			sb.append(category);
			sb.append("%'");
			String sql = sb.toString();

			list = selectTop(sql);

		}
		else {
			System.out.println("全件取得");
			list = TopServlet.selectAll();
		}

		request.setAttribute("list", list);
		request.setAttribute("loginUser", loginUser);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Top.jsp");
		dispatcher.forward(request, response);
	}



	private static List<Top> selectTop(String tweetSQL) {

		List<Tweets> tweetList = new ArrayList<>();
		List<Top> list = new ArrayList<>();
		List<Top> allList = TopServlet.selectAll();

		System.out.println(tweetSQL);

		try {
			tweetList = TweetDao.select(tweetSQL);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		for(Top top:allList) {
			for (Tweets tweet : tweetList) {
				if(tweet.getId() == top.getTweet_id()) {
					list.add(top);
				}
			}
		}

		return list;
	}
}
