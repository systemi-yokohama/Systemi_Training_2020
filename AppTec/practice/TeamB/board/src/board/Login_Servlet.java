package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import service.LoginService;

@WebServlet(urlPatterns = { "/login" })
public class Login_Servlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

	 @Override
	 protected void doGet(HttpServletRequest request,
	         HttpServletResponse response) throws IOException, ServletException {
	
	     request.getRequestDispatcher("login.jsp").forward(request, response);
	 }
	
	 @Override
	 protected void doPost(HttpServletRequest request,
	         HttpServletResponse response) throws IOException, ServletException {
	
	     String account = request.getParameter("account");
	     String password = request.getParameter("password");
	
	     LoginService loginService = new LoginService();
	     Users user = loginService.login(account, password);
	     
	     // セッションを取得する
	     HttpSession session = request.getSession();
	     if (user != null) {
	    	 // セッションに値をセットする
	         session.setAttribute("loginUser", user);
	
	         request.getRequestDispatcher("/Home_Servlet").forward(request,response);
	     } else {
	
	         List<String> messages = new ArrayList<String>();
	         messages.add("ログインに失敗しました。");
	         session.setAttribute("errorMessages", messages);
	         request.getRequestDispatcher("/login.jsp").forward(request,response);
	     }
 }

}