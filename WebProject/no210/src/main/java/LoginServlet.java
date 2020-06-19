

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import service.LoginService;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {

        //ユーザーが入力したログイン情報を受け取る
        String accountOrEmail = request.getParameter("accountOrEmail");
        String password = request.getParameter("password");

        //DBの実行
        LoginService loginService = new LoginService();
        User user = loginService.login(accountOrEmail, password);

        //sessionスコープを作成
        HttpSession session = request.getSession();

        //上手くいっているとき
        if (user != null) {

            //セッションスコープにユーザーを入れる
            session.setAttribute("loginUser", user);
            response.sendRedirect("./");
        } else {

            //login.jspでエラーメッセージを表示するため
            List<String> messages = new ArrayList<String>();
            messages.add("ログインに失敗しました。");
            session.setAttribute("errorMessages", messages);
            response.sendRedirect("login");
        }
    }

}