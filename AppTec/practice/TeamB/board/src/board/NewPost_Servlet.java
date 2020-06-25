package board;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.commons.lang.StringUtils;

import bean.Users;
import bean.Writes;
import dao.WriteDao;
//import service.WriteService;

@WebServlet(urlPatterns = { "/NewPost" })
public class NewPost_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String subject = request.getParameter("write_subject");
		String category = request.getParameter("write_category");
		String text = request.getParameter("write_text");



		HttpSession session = request.getSession();

		//     List<String> writes = new ArrayList<String>();

		//     if (isValid(request, writes) == true) {

		Users user = (Users) session.getAttribute("loginUser");

		//件名の文字数
		if (subject.length() > 30) {
			request.setAttribute("errorMessage", "件名の文字数は30文字までです");
			request.getRequestDispatcher("/newpost.jsp").forward(request, response);
			return;
		}

		//カテゴリーの文字列
		if (category.length() > 10) {
			request.setAttribute("errorMessage", "カテゴリーの文字数は10文字までです");
			request.getRequestDispatcher("/newpost.jsp").forward(request, response);
			return;
		}

		//本文の文字列
		if (text.length() > 1000) {
			request.setAttribute("errorMessage", "本文の文字数は1000文字までです");
			request.getRequestDispatcher("/newpost.jsp").forward(request, response);
			return;
		}


		WriteDao writedao = new WriteDao();

		Writes write = new Writes();

		write.setWrite_subject(subject);
		write.setWrite_category(category);
		write.setWrite_text(text);

		writedao.insert(write, user);

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