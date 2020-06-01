package WebProject.no218.src.main.twitter.src.chapter6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/index.jsp" })
public class TopServlet extends Http{
	public void doGet(HttpServletRequest result, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/top.jsp").forward(request, response);
	}


	
}