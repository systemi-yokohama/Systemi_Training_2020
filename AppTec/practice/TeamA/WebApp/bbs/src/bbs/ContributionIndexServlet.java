package bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.bean.UserCC;
import bbs.service.ContributionService;

@WebServlet(urlPatterns = {"/contributionIndex"})
public class ContributionIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

//		HttpSession session =request.getSession();
//
//		int limit = Integer.parseInt((String) session.getAttribute("limit"));

		request.setCharacterEncoding("UTF-8");

		List<UserCC> contributions = new ContributionService().getContribution();



		System.out.println(contributions);

		request.setAttribute("contributions", contributions);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
}
