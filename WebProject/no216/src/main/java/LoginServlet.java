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

        //ユーザーがログインした情報を受け取る
        String accountOrEmail = request.getParameter("accountOrEmail");
        String password = request.getParameter("password");

        //ログインメソッドを使うためにインスタンス化する
        LoginService loginService = new LoginService();
        User user = loginService.login(accountOrEmail, password);


        //セッションスコープを作る
        HttpSession session = request.getSession();

        //UserDaoのif文分岐でnullが入っていない＝うまくログインできている
        if (user != null) {
            //liginUserにuserのデータをセットする
            //セッションスコープに入れることでログアウトするときにセッションを切る
            //セッションを切るとuserデータも消える＝また他のでもログインができるようになる
            session.setAttribute("loginUser", user);
            //画面推移をしている
            response.sendRedirect("./");

            //データがないからログインできないため、
            //jspに出力するためにerrorMessagesに格納してlogin.jspに送る

        } else {

            //jspでこの配列の中の文だけエラーメッセージを出力するためにリストを作成
            List<String> messages = new ArrayList<String>();
            messages.add("ログインに失敗しました。");
            //配列にエラーメッセージを追加
            session.setAttribute("errorMessages", messages);
            response.sendRedirect("login");
        }
    }
}