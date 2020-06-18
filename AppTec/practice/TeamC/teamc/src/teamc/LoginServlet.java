package teamc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teamc.beans.Users;
import teamc.dao.UserDao;

@WebServlet("/top")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		List<Users> resultList = null;
		HttpSession session = request.getSession();

		System.out.println(account + "," + password);

		String sqlTop = "SELECT * FROM users where account ='";
		StringBuilder sb = new StringBuilder();

		//入力チェック
		if (!emptyCheck(account) && !emptyCheck(password)) {
			System.out.println("入力なし");

			request.setAttribute("val", "アカウント名が正しくありません");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		} else {
			//アカウントの入力チェック
			if (emptyCheck(account)) {
				//入力あり
				sb.append(sqlTop);
				sb.append(account);
				sb.append("';");

				String sql = sb.toString();

				try {
					resultList = UserDao.select(sql);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (resultList.size() == 0) {
					//アカウント名が違う
					System.out.println("アカウントなし");

					request.setAttribute("val", "アカウント名が正しくありません");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				} else {
					//アカウントが存在する

					//パスワードの入力チェック
					if (emptyCheck(password)) {
						//入力あり
						StringBuilder sb2 = new StringBuilder();
						sb2.append(sqlTop);
						sb2.append(account);
						sb2.append("' and password ='");
						sb2.append(password);
						sb2.append("';");

						String sqlAddPass = sb2.toString();
						System.out.println(sqlAddPass);

						try {
							resultList = UserDao.select(sqlAddPass);
						} catch (Exception e) {
							e.printStackTrace();
						}

						if (resultList.size() == 0) {
							//パスワードがアカウントと一致しない
							System.out.println("アカウントあり-パスワードが違う");

							request.setAttribute("val", "パスワードが正しくありません");
							RequestDispatcher dispatcher = request
									.getRequestDispatcher("login.jsp");
							dispatcher.forward(request, response);
						} else {
							//一致
							System.out.println("アカウント/パスワード一致");

							//アカウント停止チェック
							Users user = null;
							for(Users i:resultList) {
								user = i;
							}
							if(user.getUser_stop() == 0) {
								System.out.println("アカウント停止中");
								request.setAttribute("val", "アカウントが停止中です");
								RequestDispatcher dispatcher = request
										.getRequestDispatcher("login.jsp");
								dispatcher.forward(request, response);
							}else {
								//ログイン成功
								System.out.println("ログイン成功");

								//loginUserをsessionにセット
								session.setAttribute("loginUser", user);

								RequestDispatcher dispatcher = request
										.getRequestDispatcher("TopServlet");
								dispatcher.forward(request, response);
							}


						}

					} else {
						//パスワード入力なし
						System.out.println("アカウントあり-パスワードなし");
						request.setAttribute("val", "パスワードを入力してください");
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("login.jsp");
						dispatcher.forward(request, response);
					}
				}
			}else {
				//パスワード入力あり、アカウント入力なし
				System.out.println("アカウント入力なし");

				request.setAttribute("val", "アカウントを入力してください");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}

		}

	}

	public static boolean emptyCheck(String str) {
		if (str != null && !(str.trim().equals(""))) {
			return true;
		} else {
			return false;
		}
	}

}
