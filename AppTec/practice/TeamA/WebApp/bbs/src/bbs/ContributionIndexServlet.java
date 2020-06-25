package bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.bean.UserCC;
import bbs.service.ContributionService;

@WebServlet(urlPatterns = {"/contributionIndex"})
public class ContributionIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		String error = "";
		HttpSession session = request.getSession();
		int count = 0;

		List<UserCC> contributions = new ContributionService().getContribution();

		if (contributions.size() == 0) {
     	   error = "まだ投稿がありません...さっそく投稿しましょう！！";
        }

		request.setAttribute("count", count);
		request.setAttribute("contributions", contributions);
		session.setAttribute("error", error);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

//		HttpSession session =request.getSession();
//
//		int limit = Integer.parseInt((String) session.getAttribute("limit"));

		request.setCharacterEncoding("UTF-8");

		String error = "";
		HttpSession session = request.getSession();

		List<UserCC> contributions = new ContributionService().getContribution();

		if (contributions.size() == 0) {
	     	   error = "まだ投稿がありません...さっそく投稿しましょう！！";
	        }

		request.setAttribute("contributions", contributions);
		session.setAttribute("error", error);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
}
