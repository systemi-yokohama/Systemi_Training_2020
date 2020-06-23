package teamc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamc.beans.Tweets;
import teamc.beans.Users;
import teamc.dao.TweetDao;

@WebServlet("/TweetServlet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String subject = null;
		String text = null;
		String category = null;
		boolean subjectFlag = false;
		boolean textFlag = false;
		Tweets tweets = new Tweets();
		//セッションを取得する
		HttpSession session = req.getSession();

		try {

			////nullEmptyの処理
			if (!nullEmptyCheck(req.getParameter("subject")) && !nullEmptyCheck(req.getParameter("text"))
					&& !nullEmptyCheck(req.getParameter("category"))) {
				//件名チェック
				if (subjectCheck(req.getParameter("subject"))) {
					subject = req.getParameter("subject");
					req.setAttribute("subject", subject);
					System.out.println("件名OK");
					tweets.setSubject(subject);
					subjectFlag = true;
				} else {
					System.out.println("件名が正しくありません");
					req.setAttribute("error_subject", "件名が正しくありません");
					RequestDispatcher dispatcher = req
							.getRequestDispatcher("tweets.jsp");
					dispatcher.forward(req, resp);
				}
				//本文チェック
				if (subjectFlag) {
					if (textCheck(req.getParameter("text"))) {
						text = req.getParameter("text");
						req.setAttribute("text", text);
						System.out.println("本文OK");
						tweets.setText(text);
						textFlag = true;
					} else {
						System.out.println("本文が正しくありません");
						req.setAttribute("error_text", "本文が正しくありません");
						RequestDispatcher dispatcher = req
								.getRequestDispatcher("tweets.jsp");
						dispatcher.forward(req, resp);
					}
				}
				//カテゴリーチェック
				if (textFlag) {
					if (categoryCheck(req.getParameter("category"))) {
						category = req.getParameter("category");
						req.setAttribute("category", category);
						System.out.println("カテゴリーOK");
						tweets.setCategory(category);
						//INSERT文の実行
						System.out.println("DBに登録しました");
						//セッションから値を取得する
						Users users = (Users) session.getAttribute("loginUser");

						TweetDao.insert(tweets, users);
						getServletConfig().getServletContext().getRequestDispatcher("/TopServlet").forward(req, resp);
					} else {
						System.out.println("カテゴリーが正しくありません");
						req.setAttribute("error_category", "カテゴリーが正しくありません");
						RequestDispatcher dispatcher = req
								.getRequestDispatcher("tweets.jsp");
						dispatcher.forward(req, resp);
					}
				}
			} else {
				System.out.println("いずれかが空");
				req.setAttribute("error", "いずれかが空です");
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("tweets.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//空文字&NULL確認用メソッド
	public static boolean nullEmptyCheck(String str) {
		return (str == null | str.length() == 0);
	}

	//件名(1～30字)確認用メソッド
	public static boolean subjectCheck(String str) {
		return str.length() < 31;
	}

	//本文(1000字以下)確認用メソッド
	public static boolean textCheck(String str) {
		return str.length() < 1001;
	}

	//カテゴリー(10字以下)確認用メソッド
	public static boolean categoryCheck(String str) {
		return str.length() < 11;
	}

}