package board;

import java.io.IOException;
//import java.util.List;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Comments;

//import org.apache.commons.lang.StringUtils;

import bean.Users;
import dao.CommentDao;
import utils.DButil;

@WebServlet(urlPatterns = { "/NewComment_Servlet" })
public class NewComment_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		// どのドライバを使うか指定（今回はmysql）
		Connection connection = DButil.getConnection();

		String text = request.getParameter("comment_text");
		String write_id = request.getParameter("comment_write_id");
		int comment_write_id = Integer.parseInt(write_id);
		System.out.println(text);
		System.out.println(comment_write_id);

		HttpSession session = request.getSession();

		//     List<String> writes = new ArrayList<String>();

		//     if (isValid(request, writes) == true) {

		Users user = (Users) session.getAttribute("loginUser");

		//コメントの文字列
		if (text.length() > 500 || text==null || text.trim().equals("") ) {
			request.setAttribute("errorMessage", "本文の文字数は1~500文字です");
			request.getRequestDispatcher("/Home_Servlet").forward(request, response);
			return;
		}

		CommentDao commentdao = new CommentDao();

		Comments comment = new Comments();

		comment.setComment_text(text);
		comment.setComment_write_id(comment_write_id);

		commentdao.insert(comment, user);

		//         write.setWrite_text(request.getParameter("write"));
		//         write.setUser_id(user.getUser_id());

		//         new WriteService().register(write);

		//		RequestDispatcher dispatcher = request.getRequestDispatcher("/Home_Servlet");
		//		dispatcher.forward(request, response);
		request.getRequestDispatcher("/Home_Servlet").forward(request, response);

		//         response.sendRedirect("./");
		//     } else {
		//         session.setAttribute("errorMessages", writes);
		//         response.sendRedirect("./");
		//     }


	}



	// private boolean isValid(HttpServletRequest request, List<String> messages) {
	//
	//     String write = request.getParameter("write");
	//
	//     if (StringUtils.isEmpty(write) == true) {
	//         messages.add("メッセージを入力してください");
	//     }
	//     if (1000 < write.length()) {
	//         messages.add("1000文字以下で入力してください");
	//     }
	//     if (messages.size() == 0) {
	//         return true;
	//     } else {
	//         return false;
	//     }
	// }

}