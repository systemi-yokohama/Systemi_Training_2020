package src.chapter6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.chapter6.beans.User;
import src.chapter6.beans.UserMessage;
import src.chapter6.service.MessageService;

@WebServlet(urlPatterns = { "/index.jsp" })
public class TopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        User user = (User) request.getSession().getAttribute("loginUser");
        boolean isShowMessageForm;
        if (user != null) {
            isShowMessageForm = true;
        } else {
            isShowMessageForm = false;
        }

        List<UserMessage> messages = new MessageService().getMessage();

        request.setAttribute("messages", messages);
        request.setAttribute("isShowMessageForm", isShowMessageForm);


        request.getRequestDispatcher("/top.jsp").forward(request, response);
    }
}