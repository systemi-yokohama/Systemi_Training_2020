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

@WebServlet(urlPatterns = { "/newComment" })
public class NewCommentServlet extends HttpServlet {
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
    	//jspで入力された値を獲得
    	String contributionId = request.getParameter("cbId");
		String text = request.getParameter("text");
		User loginUser = (User) session.getAttribute("loginUser");

		if (!(isValid(request, messages))) {
			session.setAttribute("errorMessages", messages);
			request.getRequestDispatcher("/contributionIndex").forward(request,response);
		} else {
			try {
		      	connection = getConnection();
		      	//実行したいSQL文
		      	sql.append("INSERT INTO comments ( ");
		      	sql.append("text");
		      	sql.append(", contribution_id");
	            sql.append(", user_account");
	            sql.append(", created_date");
	            sql.append(", updated_date");
	            sql.append(") VALUES ( '");
	            sql.append(text); // text
	            sql.append("', '");
	            sql.append(contributionId);
	            sql.append("', '");
	            sql.append(loginUser.getAccount()); // userAccount
	            sql.append("', CURRENT_TIMESTAMP"); // createdDate
	            sql.append(", CURRENT_TIMESTAMP"); // updatedDate
	            sql.append(")");

//		      	System.out.println(sql.toString());
		      	statement = connection.prepareStatement(sql.toString());
		    	statement.executeUpdate(sql.toString());
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
			String text = request.getParameter("text");

		    //コメント（text）のエラーメッセージ
		    if (StringUtils.isBlank(text)) {
		        messages.add("※コメントを入力してください");
		    }
		    if (!(StringUtils.isBlank(text)) && 500 < text.length()) {
		        messages.add("※コメントは500文字以下で入力してください");
		    }
		    if (messages.size() == 0) {
		    	return true;
		    } else {
		    	return false;
		    }

}

}
