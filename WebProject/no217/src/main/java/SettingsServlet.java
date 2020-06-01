// package chapter6.controller;

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

import beans.User;
import exception.NoRowsUpdatedRuntimeException;
import service.UserService;

@WebServlet(urlPatterns = { "/settings" })
public class SettingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        //セッションよりログインユーザーの情報を取得
        User loginUser = (User) session.getAttribute("loginUser");
        //ログインユーザー情報のidを元にDBからユーザー情報取得
        User editUser = new UserService().getUser(loginUser.getId());
        request.setAttribute("editUser", editUser);

        request.getRequestDispatcher("settings.jsp").forward(request, response);
    }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<String> messages = new ArrayList<String>();
		HttpSession session = request.getSession();
		User editUser = getEditUser(request);

		if (isValid(request, messages) == true) {

			try {
				new UserService().update(editUser);
			} catch (NoRowsUpdatedRuntimeException e) {
				messages.add("他の人によって更新されています。最新のデータを表示しました。データを確認してください。");
				session.setAttribute("errorMessages", messages);
				request.setAttribute("editUser", editUser);
				request.getRequestDispatcher("settings.jsp").forward(request, response);
				return;
			}

			session.setAttribute("loginUser", editUser);

			response.sendRedirect("./");
		} else {
			session.setAttribute("errorMessages", messages);
			request.setAttribute("editUser", editUser);
			request.getRequestDispatcher("settings.jsp").forward(request, response);
		}
	}

	private User getEditUser(HttpServletRequest request)
			throws IOException, ServletException {

		User editUser = new User();
		editUser.setId(Integer.parseInt(request.getParameter("id")));
		editUser.setName(request.getParameter("name"));
		editUser.setAccount(request.getParameter("account"));
		editUser.setPassword(request.getParameter("password"));
		editUser.setEmail(request.getParameter("email"));
		editUser.setDescription(request.getParameter("description"));
		return editUser;
	}


	private boolean isValid(HttpServletRequest request, List<String> messages) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");

		if (StringUtils.isEmpty(account) == true) {
			messages.add("アカウント名を入力してください");
		}
		if (StringUtils.isEmpty(password) == true) {
			messages.add("パスワードを入力してください");
		}
		// TODO アカウントが既に利用されていないか、メールアドレスが既に登録されていないかなどの確認も必要
		if (messages.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}