package controller;

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
import exception.exception.NoRowsUpdatedRuntimeException;
import service.UserService;

@WebServlet(urlPatterns = { "/setting" })
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        User user = new UserService().select(loginUser.getId());

        request.setAttribute("user", user);
        request.getRequestDispatcher("setting.jsp").forward(request, response);
	}
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<String> errorMessages = new ArrayList<String>();

        User user = getUser(request);
        if (isValid(user, errorMessages)) {
            try {
                new UserService().update(user);
            } catch (NoRowsUpdatedRuntimeException e) {
                errorMessages.add("他の人によって更新されています。最新のデータを表示しました。データを確認してください。");
            }
        }

        if (errorMessages.size() != 0) {
            request.setAttribute("errorMessages", errorMessages);
            request.setAttribute("user", user);
            request.getRequestDispatcher("setting.jsp").forward(request, response);
            return;
        }

        session.setAttribute("loginUser", user);
        response.sendRedirect("./");
    }

    private User getUser(HttpServletRequest request) throws IOException, ServletException {

        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setAccount(request.getParameter("account"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setDescription(request.getParameter("description"));
        return user;
    }

    private boolean isValid(User user, List<String> errorMessages) {

        String name = user.getName();
        String account = user.getAccount();
        String password = user.getPassword();
        String email = user.getEmail();

        if (!StringUtils.isEmpty(name) && (20 < name.length())) {
            errorMessages.add("名前は20文字以下で入力してください");
        }
        if (StringUtils.isEmpty(account)) {
            errorMessages.add("アカウント名を入力してください");
        } else if (20 < account.length()) {
            errorMessages.add("アカウント名は20文字以下で入力してください");
        }
        if (StringUtils.isEmpty(password)) {
            errorMessages.add("パスワードを入力してください");
        }
        if (!StringUtils.isEmpty(email) && (50 < email.length())) {
            errorMessages.add("メールアドレスは50文字以下で入力してください");
        }

        if (errorMessages.size() != 0) {
            return false;
        }
        return true;
    }
}