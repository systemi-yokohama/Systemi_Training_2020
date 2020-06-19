package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;

@WebServlet("/Management_Servlet")
public class Management_Servlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 @Override
 protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws IOException, ServletException {

	// ログインのセッションを取得する
     HttpSession session = request.getSession();
     Users users = (Users) session.getAttribute("loginUser");
     
     System.out.println(users);

     request.getRequestDispatcher("usermanagement.jsp").forward(request, response);
         }
}
