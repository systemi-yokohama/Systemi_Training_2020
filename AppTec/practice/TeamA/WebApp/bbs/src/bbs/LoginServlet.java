package bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import bbs.bean.User;
import bbs.service.LoginService;



@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

	@Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {

		//文字化け防止
		request.setCharacterEncoding("UTF-8");

		//ユーザーが入力したログイン情報を受け取る
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//login.jspでエラーメッセージを表示するため
        List<String> messages = new ArrayList<String>();
		//sessionスコープの作成
		HttpSession session = request.getSession();

		if (isValid(account) && isValid(password)) {
			messages.add("※アカウントを6文字以上20文字以下の半角英数字で入力してください");
			messages.add("※パスワードを6文字以上20文字以下の記号を含む半角文字で入力してください");
		} else if (isValid(account)) {
			messages.add("※アカウントを6文字以上20文字以下の半角英数字で入力してください");
		} else if (isValid(password)) {
			messages.add("※パスワードを6文字以上20文字以下の記号を含む半角文字で入力してください");
		} else {
			//DBの実行
			LoginService loginService = new LoginService();
			User user = loginService.login(account, password);
//			System.out.println(user);

			//上手くいってるとき
			if (user != null && user.getStatus() == 1) {
				//セッションスコープにユーザーを入れる
	            session.setAttribute("loginUser", user);
//	            request.getRequestDispatcher("/contributionIndex").forward(request, response);

	            request.getRequestDispatcher("/contributionIndex").forward(request, response);
	        //エラー条件
	        //停止中のアカウント
	        } else if (user == null) {
	        	messages.add("※アカウントとパスワードが一致しません");
	       // 一致するユーザーがいなかった
	        } else {
	        	messages.add("※停止中のアカウントのため利用できません");
	        }
		}

		if (!(messages.isEmpty())) {
			session.setAttribute("errorMessages", messages);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	    }

		private boolean isValid(String param) {
			return StringUtils.isBlank(param) || param == null;
		}
}
