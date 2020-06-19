package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws IOException, ServletException {

		 	request.setCharacterEncoding("UTF-8");

		 	String account = request.getParameter("account");
		 	String name = request.getParameter("name");

		 	request.setAttribute("account", account);
		 	request.setAttribute("name", name);
	        request.getRequestDispatcher("/settings.jsp").forward(request, response);

	    }
}
