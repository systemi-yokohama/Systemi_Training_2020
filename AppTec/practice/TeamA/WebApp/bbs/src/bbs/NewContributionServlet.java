package bbs;

import static bbs.util.DBUtil.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

@WebServlet(urlPatterns = { "/newContribution" })
public class NewContributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String> messages = new ArrayList<String>();
		HttpSession session = request.getSession();
    	StringBuilder sql = new StringBuilder();
    	Connection connection = null;
    	PreparedStatement statement = null;
//    	int uc = 0;
    	//jspで入力された値を獲得
		String title = request.getParameter("title").toString();
		String category = request.getParameter("category").toString();
		String text = request.getParameter("text").toString();
		User loginUser = (User) session.getAttribute("loginUser");

		System.out.println(title);

		if (!(isValid(request, messages))) {
			session.setAttribute("errorMessages", messages);
			request.getRequestDispatcher("/newContribution.jsp").forward(request,response);
		} else {
			try {
		      	connection = getConnection();
		      	//実行したいSQL文
		      	sql.append("INSERT INTO contributions ( ");
		      	sql.append("text");
		      	sql.append(", category");
	            sql.append(", title");
	            sql.append(", user_account");
	            sql.append(", created_date");
	            sql.append(", updated_date");
	            sql.append(") VALUES ( '");
	            sql.append(text); // title
	            sql.append("', '");
	            sql.append(category); // category
	            sql.append("', '");
	            sql.append(title); // text
	            sql.append("', '");
	            sql.append(loginUser.getAccount()); // userAccount
	            sql.append("', CURRENT_TIMESTAMP"); // createdDate
	            sql.append(", CURRENT_TIMESTAMP"); // updatedDate
	            sql.append(")");

		      	//sql.append("INSERT INTO contributions VALUES(?,?,?);");
		      	System.out.println(sql.toString());
		      	statement = connection.prepareStatement(sql.toString());
		    	statement.executeUpdate(sql.toString());
//		    	System.out.println(uc);
		    	statement.close();
		    	commit(connection);
		    	request.getRequestDispatcher("/contributionIndex").forward(request,response);

		      }catch (SQLException e) {
		      	//TODO 自動生成されたcatchブロック
		      	e.printStackTrace();
		      }
		}
      }
		private boolean isValid(HttpServletRequest request, List<String> messages) {
			String title = request.getParameter("title").toString();
			String category = request.getParameter("category").toString();
			String text = request.getParameter("text").toString();
			//件名（title）関連のエラーメッセージ
		    if (StringUtils.isBlank(title)) {
		        messages.add("※件名を入力してください");
		    }
		    if (!(StringUtils.isBlank(title)) && 30 < title.length()) {
		        messages.add("※件名は30文字以下で入力してください");
		    }
		    //カテゴリーのエラーメッセージ
		    if (StringUtils.isBlank(category)) {
		        messages.add("※カテゴリーを入力してください");
		    }
		    if (!(StringUtils.isBlank(category)) && 10 < category.length()) {
		        messages.add("※カテゴリーは10文字以下で入力してください");
		    }
		    //本文（text）のエラーメッセージ
		    if (StringUtils.isBlank(text)) {
		        messages.add("※本文を入力してください");
		    }
		    if (!(StringUtils.isBlank(text)) && 1000 < text.length()) {
		        messages.add("※本文は1000文字以下で入力してください");
		    }
		    if (messages.size() == 0) {
		    	return true;
		    } else {
		    	return false;
		    }
		}
	}