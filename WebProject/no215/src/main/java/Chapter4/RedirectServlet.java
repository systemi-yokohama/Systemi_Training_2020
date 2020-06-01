package Chapter4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/redirect" })
public class RedirectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        int no = Integer.parseInt(request.getParameter("no"));

        System.out.println("no = " + no);

        String url;
        switch (no) {
        case 0:
            url = "http://yahoo.co.jp/";
            break;
        case 1:
            url = "http://google.co.jp/";
            break;
        case 2:
            url = "http://www.sbcr.jp/";
            break;
        case 3:
            url = "http://isbn.sbcr.jp/53402/";
            break;
        case 4:
            url = "http://www.sbcr.jp/products/4797359039.html";
            break;
        default:
            url = "redirect?no=" + (no + 1);
            break;
        }

        System.out.println(url);

        response.sendRedirect(url);
    }
}