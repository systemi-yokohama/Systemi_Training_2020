

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import beans.UserMessage;
import service.MessageService;

@WebServlet(urlPatterns = { "/index.jsp" })
public class TopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {

        //getSession()でセッションが開始されていればセッションの中身を取得できるメソッド
        User user = (User) request.getSession().getAttribute("loginUser");
        boolean isShowMessageForm;
        //ログイン中のユーザーがいれば投稿が見られる
        if (user != null) {
            isShowMessageForm = true;
        } else {
            isShowMessageForm = false;
        }

        //投稿を最大1000件まで取得（リストで）
        List<UserMessage> messages = new MessageService().getMessage();

        //投稿・ログイン中のユーザーがいるかをtop.jspに送信
        request.setAttribute("messages", messages);
        request.setAttribute("isShowMessageForm", isShowMessageForm);


        request.getRequestDispatcher("/top.jsp").forward(request, response);
    }
}