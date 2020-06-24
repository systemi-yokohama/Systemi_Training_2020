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
@WebServlet(urlPatterns = { "/signup" })
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws IOException, ServletException {
	        request.getRequestDispatcher("signup.jsp").forward(request, response);
	    }
	 @Override
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws IOException, ServletException {
		 request.setCharacterEncoding("UTF-8");
		 List<String> messages = new ArrayList<String>();
		 HttpSession session = request.getSession();
		 //メッセージがないなら入力値を受け取る
		 if (isValid(request, messages) == true) {
	            User user = new User();
	            user.setAccount(request.getParameter("account"));
	            user.setPassword(request.getParameter("password"));
	            user.setName(request.getParameter("name"));
	            user.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
	            user.setBranchId(Integer.parseInt(request.getParameter("branchId")));
	           /////////////////////////////////////////////////////////////////////////////////////////
	            Connection connection = null;
	            try {
	                connection = getConnection();
//	                String encPassword = CipherUtil.encrypt(user.getPassword());
//	                user.setPassword(encPassword);
	                UserDao userDao = new UserDao();
	                User oldUser = userDao.getUser(connection, user);
	                System.out.println(oldUser);



	                if(oldUser == null) {
	                	userDao.insert(connection, user);
	                	commit(connection);
	                	request.getRequestDispatcher("/userManagement").forward(request, response);
	                } else {
	                	messages.add("※そのユーザーはすでに登録されています");
	                	session.setAttribute("errorMessages", messages);
	    	            request.getRequestDispatcher("signup.jsp").forward(request, response);
	                }
//	                userDao.insert(connection, user);

	            } catch (RuntimeException e) {
	                rollback(connection);
	                throw e;
	            } catch (Error e) {
	                rollback(connection);
	                throw e;
	            } finally {
	                close(connection);
	            }
	            ////////////////////////////////////////////////////////////////////////////
	        } else {
	            session.setAttribute("errorMessages", messages);
	            request.getRequestDispatcher("signup.jsp").forward(request, response);
	        }
	 }
	 private boolean isValid(HttpServletRequest request, List<String> messages)  {
		 String account = request.getParameter("account");
	     String password = request.getParameter("password");
	     String password2 = request.getParameter("password2");
	     String name = request.getParameter("name");
	     int departmentId = Integer.parseInt(request.getParameter("departmentId"));
	     int branchId = Integer.parseInt(request.getParameter("branchId"));
	     //isEmpty・・・文字列がnullまたは""=入力されていない とtrue
	     //入力値がなかったらエラー
	     if (StringUtils.isBlank(account)) {
	         messages.add("※アカウントを入力してください");
	     } else if((StringUtils.length(account) <= 5) || (StringUtils.length(account) >= 21) || !(StringUtils.isAlphanumeric(account))) {
	     	//半角英数字じゃなかったらエラー
	    	//文字数が足りていない/多かったらエラー
	   	    messages.add("※アカウントを6文字以上20文字以下の半角英数字で入力してください");
	   	 }
	   //入力値がなかったらエラー
	     if (StringUtils.isBlank(password)) {
	         messages.add("※パスワードを入力してください");
	        } else if((StringUtils.length(password) <= 5) || (StringUtils.length(password) >= 21) || !(password.matches("^[a-zA-Z0-9,/]+$"))) {
	        //文字数が足りていない/多かったらエラー
	        messages.add("※パスワードを6文字以上20文字以下の記号を含む半角文字で入力してください");
		     }
	     //パスワードと再入力が違っていたらエラー
	     if(!(StringUtils.equals(password, password2))) {
	    	 messages.add("※入力したパスワードが一致しません");
	     }
	   //入力値がなかったらエラー
	     if(StringUtils.isBlank(name)) {
	    	 messages.add("※名称を入力してください");
	     }
	     //11文字以上だったらエラー
	     if(StringUtils.length(name) > 10) {
	    	 messages.add("※名称を10文字以内で入力してください");
	     }
	   //入力値がなかったらエラー
	     if(branchId == 0) {
	    	 messages.add("※支社を入力してください");
	     }
	   //入力値がなかったらエラー
	     if(departmentId == 0) {
	    	 messages.add("※部署を入力してください");
	     }
	     if(branchId == 1 && departmentId >= 3) {
	    	 messages.add("※正しい組み合わせで支社/部署を入力してください");
	     }
	     if(branchId >= 2 && (departmentId == 1 || departmentId == 2)) {
	    	 messages.add("※正しい組み合わせで支社/部署を入力してください");
	     }
	     if (messages.size() == 0) {
	            return true;
	       } else {
	            return false;
	       }
	 }
}
