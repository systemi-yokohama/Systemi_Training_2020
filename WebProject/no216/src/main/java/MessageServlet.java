//package chapter6.controller;

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

import beans.Message;
import beans.User;
import service.MessageService;

@WebServlet(urlPatterns = { "/newMessage" })
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        List<String> messages = new ArrayList<String>();

        if (isValid(request, messages) == true) {

            User user = (User) session.getAttribute("loginUser");

            Message message = new Message();
            message.setText(request.getParameter("message"));
            message.setUserId(user.getId());

            new MessageService().register(message);

            response.sendRedirect("./");
        } else {
            session.setAttribute("errorMessages", messages);
            response.sendRedirect("./");
        }
    }

    private boolean isValid(HttpServletRequest request, List<String> messages) {

        String message = request.getParameter("message");

        if (StringUtils.isEmpty(message) == true) {
            messages.add("メッセージを入力してください");
        }
        if (140 < message.length()) {
            messages.add("140文字以下で入力してください");
        }
        if (messages.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}