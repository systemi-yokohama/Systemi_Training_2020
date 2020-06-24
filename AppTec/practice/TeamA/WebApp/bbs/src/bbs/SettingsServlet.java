package bbs;

import static bbs.util.CloseableUtil.*;
import static bbs.util.DBUtil.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import bbs.bean.User;
import bbs.dao.UserDao;

//1.新規登録の内容を確認
@WebServlet(urlPatterns = { "/settings" })
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws IOException, ServletException {
	        request.getRequestDispatcher("settings.jsp").forward(request, response);
	    }
	 @Override
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws IOException, ServletException {
		 request.setCharacterEncoding("UTF-8");
		 List<String> messages = new ArrayList<String>();
		 HttpSession session = request.getSession();
		 Connection connection = null;
		 //メッセージがないなら入力値を受け取る
		 if (isValid(request, messages, session) == true) {
			 String account = request.getParameter("account");
			 String oldAccount = request.getParameter("oldAccount");
			 System.out.println(account);
			 System.out.println(oldAccount);
			 UserDao userDao = new UserDao();
			 if (userDao.getOldUser(connection, account, oldAccount)) {
				 User user = new User();
		         user.setAccount(request.getParameter("account"));
		         user.setPassword(request.getParameter("password"));
		         user.setName(request.getParameter("name"));
		         user.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
		         user.setBranchId(Integer.parseInt(request.getParameter("branchId")));
				 try {
		                connection = getConnection();
//		                String encPassword = CipherUtil.encrypt(user.getPassword());
//		                user.setPassword(encPassword);

				        userDao.update(connection, user, oldAccount);
		                commit(connection);
		                request.getRequestDispatcher("/userManagement").forward(request, response);
//		                response.sendRedirect("/bbs/userManagement");
				 	} catch (RuntimeException e) {
		                rollback(connection);
		                throw e;
		            } catch (Error e) {
		                rollback(connection);
		                throw e;
		            } finally {
		                close(connection);
		            }
			 } else {
				 messages.add("※そのアカウントはすでに登録されています");
				 session.setAttribute("errorMessages", messages);
		         request.getRequestDispatcher("/settings.jsp").forward(request, response);
	        }
		 }
		 session.setAttribute("errorMessages", messages);
         request.getRequestDispatcher("/settings.jsp").forward(request, response);

	 }
	 //部署、支社の組み合わせが違うときのエラー分岐
	 private boolean isValid(HttpServletRequest request, List<String> messages, HttpSession session)  {
		 String account = request.getParameter("account");
		 String oldAccount = request.getParameter("oldAccount");
	     String password = request.getParameter("password");
	     String password2 = request.getParameter("password2");
	     String name = request.getParameter("name");
	     int departmentId = Integer.parseInt(request.getParameter("departmentId"));
	     int branchId = Integer.parseInt(request.getParameter("branchId"));
//	     User editUser = (User) session.getAttribute("editUser");
	     //アカウント
	     if(!(StringUtils.isBlank(account)) && !(account.equals(oldAccount))) {
	    	 if((StringUtils.length(account) <= 5) || (StringUtils.length(account) >= 21) || !(StringUtils.isAlphanumeric(account))) {
		    	 messages.add("※アカウント名を6文字以上20文字以下の半角英数字で入力してください");
		     }
	     }
	     //10文字以上だったらエラー
	     if(StringUtils.length(name) > 10) {
	    	 messages.add("※名称を10文字以内で入力してください");
	     }
	     if(branchId == 1 && departmentId >= 3) {
	    	 messages.add("※正しい組み合わせで支社/部署を入力してください");
	     }
	     if(branchId >= 2 && (departmentId == 1 || departmentId == 2)) {
	    	 messages.add("※正しい組み合わせで支社/部署を入力してください");
	     }
	     //パスワード
	     if(!(StringUtils.isBlank(password)) &&
	    		 (!(password.matches("^[a-zA-Z0-9,/]+$")) || StringUtils.length(password) <= 5) || (StringUtils.length(password) >= 21)) {
		    messages.add("※パスワードを6文字以上20文字以下の記号を含む半角文字で入力してください");
	     }
	     //パスワードと再入力が違っていたらエラー
	     if(!(StringUtils.equals(password, password2))) {
	    	 messages.add("※入力したパスワードが一致しません");
	     }
	     if (messages.size() == 0) {
	            return true;
	       } else {
	            return false;
	       }
	 }
}