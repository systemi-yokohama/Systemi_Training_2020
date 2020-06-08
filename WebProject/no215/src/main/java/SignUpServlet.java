

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
import service.UserService;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        List<String> messages = new ArrayList<String>();

        HttpSession session = request.getSession();
        if (isValid(request, messages) == true) {
            //リクエストパラメータをUserオブジェクトにセット
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setAccount(request.getParameter("account"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            user.setDescription(request.getParameter("description"));

            //Serviceのメソッドを呼び出してDBへユーザーの登録
            new UserService().register(user);

            response.sendRedirect("./");
        } else {
            //入力値に対するバリデーションを行い、入力値が不正な場合には再度、自画面(signup)を表示する
            session.setAttribute("errorMessages", messages);
            response.sendRedirect("signup");
        }
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