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
import service.UserService;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String accountOrEmail = request.getParameter("accountOrEmail");
        String password = request.getParameter("password");

        User user = new UserService().select(accountOrEmail, password);
        if (user == null) {
            List<String> errorMessages = new ArrayList<String>();
            errorMessages.add("ログインに失敗しました");
            request.setAttribute("errorMessages", errorMessages);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);
        response.sendRedirect("./");
    }
}