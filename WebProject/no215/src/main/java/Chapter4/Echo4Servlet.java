package Chapter4;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/echo4")
public class Echo4Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String message = request.getParameter("m");
        System.out.println(message);

        request.getSession().setAttribute("message", message);

        // "/Chapter4"が返る
        String contextPath = getServletContext().getContextPath(); 
        String path = contextPath + "/echo4.jsp";
        response.sendRedirect(path);
    }
}