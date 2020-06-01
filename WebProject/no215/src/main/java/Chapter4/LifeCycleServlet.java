package Chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/lifeCycleServlet" })
public class LifeCycleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    private int i = 0;

    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet#LifeCycleServlet()がコールされました。");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        i++;

        PrintWriter writer = response.getWriter();
        writer.write("iの値は" + i + "です。");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LifeCycleServlet#init()がコールされました。");
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleServlet#destroy()がコールされました。");
    }

	
}